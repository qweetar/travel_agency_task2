package ru.myfirstwebsite.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.myfirstwebsite.dao.ReviewDao;
import ru.myfirstwebsite.domain.Review;
import ru.myfirstwebsite.domain.Tour;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ReviewDaoImpl implements ReviewDao {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List<Review> findAll() {
        try (Session session = sessionFactory.openSession()){
            return session.createQuery("select tu from Review tu", Review.class).getResultList();
        }
    }

    @Override
    public Review getById(Long id) {
        try (Session session = sessionFactory.openSession()){
            return session.find(Review.class, id);
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
    public void save(Review entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.save(entity);
            transaction.commit();
        }
    }

    @Override
    public void update(Review entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.saveOrUpdate(entity);
            transaction.commit();
        }

    }

    @Override
    public Iterable<Review> getReviewByTourId(Long id) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Review> cr = cb.createQuery(Review.class);
        Root<Review> root = cr.from(Review.class);
        cr.select(root).where(cb.equal(root.get("tour"), id));

        Query<Review> query = session.createQuery(cr);
        List<Review> results = query.getResultList();
        return results;
    }

    @Override
    public Iterable<Review> getReviewByUserId(Long id) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Review> cr = cb.createQuery(Review.class);
        Root<Review> root = cr.from(Review.class);
        cr.select(root).where(cb.equal(root.get("user"), id));

        Query<Review> query = session.createQuery(cr);
        List<Review> results = query.getResultList();
        return results;
    }
}
