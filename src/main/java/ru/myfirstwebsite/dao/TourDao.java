package ru.myfirstwebsite.dao;

import ru.myfirstwebsite.domain.Tour;

import java.util.Date;

public interface TourDao extends GenericDao<Tour, Long> {
    Iterable<Tour> findByCountry(String country);

    Iterable<Tour> searchTour(String country, Date tour_date, Integer tourDuration, Float minTourPrice, Float maxTourPrice, Integer numStars, String tourType);

    Iterable<Tour> getTourByHotelId(Long id);

    Iterable<Tour> getToursByHotelId(Long id);
}
