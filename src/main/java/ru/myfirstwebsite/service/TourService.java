package ru.myfirstwebsite.service;

import com.sun.deploy.panel.ITreeNode;
import org.springframework.ui.Model;
import ru.myfirstwebsite.domain.Tour;

import java.util.Date;
import java.util.List;

public interface TourService extends GenericService<Tour, Long> {
    Iterable<Tour> findByCountry(String country);

    Iterable<Tour> searchTour(String country, Date tour_date, Integer tourDuration, String tourPrice, Integer numStars, String tourType);

    Iterable<Tour> getToursByHotelId(Long id);

    Iterable<Tour> getToursByUserId(Long id);
}
