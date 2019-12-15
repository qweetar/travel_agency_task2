package ru.myfirstwebsite.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.myfirstwebsite.dao.UserDao;
import ru.myfirstwebsite.domain.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save (User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.save(user);
            transaction.commit();
        }
    }

    @Override
    public User getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(User.class, id);
        }
    }

    @Override
    public List<User> findAll() {
        try (Session session = sessionFactory.openSession()){
            return session.createQuery("select tu from User tu", User.class).getResultList();
        }
    }

    @Override
    public void update(User user) {
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.saveOrUpdate(user);
            transaction.commit();
        }
    }

    @Override
    public void delete(Long id) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.delete(getById(id));
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public Long findUserIdByEmail(String email) {
        Session session = sessionFactory.openSession();
            TypedQuery<User> query = session.createQuery("select tu from User tu where tu.email = :email", User.class);
            query.setParameter("email", email);
            query.getResultList().stream().findFirst().orElse(null);

            if (query.getResultList().isEmpty()) {
                return null;
            } else if (query.getResultList().size() == 1) {
                return 0L;
            } else {
                return 0L;
            }

    }
}
