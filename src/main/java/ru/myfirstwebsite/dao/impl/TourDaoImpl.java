package ru.myfirstwebsite.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.myfirstwebsite.dao.CountryDao;
import ru.myfirstwebsite.dao.HotelDao;
import ru.myfirstwebsite.dao.TourDao;
import ru.myfirstwebsite.dao.UserDao;
import ru.myfirstwebsite.domain.*;
import ru.myfirstwebsite.domain.enums.TourType;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class TourDaoImpl implements TourDao {

    @Autowired
    CountryDao countryDao;

    @Autowired
    HotelDao hotelDao;

    @Autowired
    UserDao userDao;

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List<Tour> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("select tu from Tour tu", Tour.class).getResultList();
        }
    }

    @Override
    public Tour getById(Long id) {
        try (Session session = sessionFactory.openSession()){
            return session.find(Tour.class, id);
        }
    }

    @Override
    public void delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.remove(getById(id));
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void save(Tour entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.save(entity);
            transaction.commit();
        }
    }

    @Override
    public void update(Tour entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.saveOrUpdate(entity);
            transaction.commit();
        }
    }

    @Override
    public Iterable<Tour> findByCountry(String country) {
        Country countryFromDb = countryDao.findByCountryName(country);
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Tour> cr = cb.createQuery(Tour.class);
        Root<Tour> root = cr.from(Tour.class);
        cr.select(root).where(cb.equal(root.get("country"), countryFromDb.getCountryId())).orderBy(cb.asc(root.get("tourDate")));

        Query<Tour> query = session.createQuery(cr);
        List<Tour> results = query.getResultList();
        return results;
        }

    @Override
    public Iterable<Tour> searchTour(String country, Date tour_date, Integer tourDuration, Float minTourPrice, Float maxTourPrice, Integer numStars, String tourType) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Tour> cr = cb.createQuery(Tour.class);
        Root<Tour> tourRoot = cr.from(Tour.class);

        Join<Tour, Country> countryJoin = tourRoot.join(Tour_.country);

        Join<Tour, Hotel> hotelJoin = tourRoot.join(Tour_.hotel);

        List<Predicate> criteria = new ArrayList<Predicate>();

        cr.select(tourRoot);

        if (country != null & !country.isEmpty()) {
            criteria.add(cb.equal(countryJoin.get(Country_.countryName), country));
        }

        if (tour_date != null ) {
            criteria.add(cb.equal(tourRoot.get(Tour_.tourDate), tour_date));
        }

        if (tourDuration != null) {
            criteria.add(cb.equal(tourRoot.get(Tour_.tourDuration), tourDuration));
        }

        if (minTourPrice != null && maxTourPrice != null) {
            criteria.add(cb.between(tourRoot.get(Tour_.tourCost), minTourPrice, maxTourPrice));
        }

        if (numStars != null) {
            criteria.add(cb.equal(hotelJoin.get(Hotel_.hotelStars), numStars));
        }

        if (tourType != null && tourType != "") {
            criteria.add(cb.equal(tourRoot.get(Tour_.tourType), TourType.valueOf(tourType)));
        }

        cr.where(cb.and(criteria.toArray(new Predicate[criteria.size()]))).orderBy(cb.asc(tourRoot.get("tourDate")));;

        System.out.println("8");
        Query<Tour> query = session.createQuery(cr);
        System.out.println("9");
        List<Tour> results = query.getResultList();
        System.out.println("0");
        return results;
    }

    @Override
    public Iterable<Tour> getTourByHotelId(Long id) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Tour> cr = cb.createQuery(Tour.class);
        Root<Tour> root = cr.from(Tour.class);
        cr.select(root).where(cb.equal(root.get("hotel"), id));

        Query<Tour> query = session.createQuery(cr);
        List<Tour> results = query.getResultList();
        return results;
    }

    @Override
    public Iterable<Tour> getToursByHotelId(Long id) {
        Session session = sessionFactory.openSession();
            TypedQuery<Tour> query = session.createQuery("select tu from Tour tu join tu.users u where u.id = :iduser", Tour.class);
            query.setParameter("iduser", id);
            List<Tour> results = query.getResultList();
            return results;
    }

}
