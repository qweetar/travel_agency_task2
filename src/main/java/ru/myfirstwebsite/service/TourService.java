package ru.myfirstwebsite.service;

import ru.myfirstwebsite.domain.Tour;

import java.util.Date;

public interface TourService extends GenericService<Tour, Long> {
    Iterable<Tour> findByCountry(String country);

    Iterable<Tour> searchTour(String country, Date tour_date, Integer tourDuration, String tourPrice, Integer numStars, String tourType);

    Iterable<Tour> getToursByHotelId(Long id);

    Iterable<Tour> getToursByUserId(Long id);
}
