package ru.myfirstwebsite.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.myfirstwebsite.dao.TourDao;
import ru.myfirstwebsite.domain.Tour;
import ru.myfirstwebsite.service.TourService;

import java.util.Date;
import java.util.List;

@Service
public class TourServiceImpl implements TourService {

    @Autowired
    public TourDao tourDao;

    @Override
    public List<Tour> findAll() {
        return tourDao.findAll();
    }

    @Override
    public boolean save(Tour entity) {
        tourDao.save(entity);
        return true;
    }

    @Override
    public Tour getById(Long id) {
        return tourDao.getById(id);
    }

    @Override
    public void update(Tour entity) {
        tourDao.update(entity);
    }

    @Override
    public void delete(Long id) {
        tourDao.delete(id);
    }

    @Override
    public Iterable<Tour> findByCountry(String country) {
        return tourDao.findByCountry(country);
    }

    @Override
    public Iterable<Tour> searchTour(String country, Date tour_date, Integer tourDuration, String tourPrice, Integer numStars, String tourType) {
        Float minTourPrice = null;
        Float maxTourPrice = null;
        if (tourPrice != null && tourPrice != "") {
            minTourPrice = Float.valueOf(tourPrice) - 300;
            maxTourPrice = Float.valueOf(tourPrice) + 100;
        }

        return tourDao.searchTour(country, tour_date, tourDuration, minTourPrice, maxTourPrice, numStars, tourType);
    }

    @Override
    public Iterable<Tour> getToursByHotelId(Long id) {
        return tourDao.getTourByHotelId(id);
    }

    @Override
    public Iterable<Tour> getToursByUserId(Long id) {
        return tourDao.getToursByHotelId(id);
    }


}
