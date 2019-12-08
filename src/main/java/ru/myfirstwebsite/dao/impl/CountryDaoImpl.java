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
import ru.myfirstwebsite.dao.CountryDao;
import ru.myfirstwebsite.domain.Country;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CountryDaoImpl implements CountryDao {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List<Country> findAll() {
        try (Session session = sessionFactory.openSession()){
            return session.createQuery("select tu from Country tu", Country.class).getResultList();
        }
    }

    @Override
    public Country getById(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(Country.class, id);
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(getById(id));
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void save(Country entity) {
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.save(entity);
            transaction.commit();
        }
    }

    @Override
    public void update(Country entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.saveOrUpdate(entity);
            transaction.commit();
        }
    }

    @Override
    public Country findByCountryName(String countryName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Country> query = session.createQuery("select tu from Country tu where tu.countryName = :countryName", Country.class);
            query.setParameter("countryName", countryName);
            return query.getSingleResult();
        }
    }


}
