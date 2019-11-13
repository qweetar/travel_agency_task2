package ru.myfirstwebsite.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.myfirstwebsite.dao.HotelDao;
import ru.myfirstwebsite.domain.Hotel;
import ru.myfirstwebsite.domain.enums.Features;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class HotelDaoImpl implements HotelDao {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List<Hotel> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("select tu from Hotel tu", Hotel.class).getResultList();
        }
    }

    @Override
    public Hotel getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(Hotel.class, id);
        }
    }

    @Override
    public void delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(getById(id));
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void save(Hotel entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.save(entity);
            transaction.commit();
        }
    }

    @Override
    public void update(Hotel entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.saveOrUpdate(entity);
            transaction.commit();
        }
    }
}
