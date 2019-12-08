package ru.myfirstwebsite.dao;

import ru.myfirstwebsite.domain.Hotel;

import java.util.List;

public interface HotelDao extends GenericDao<Hotel, Long> {
    List<Hotel> findByNumOfStars(Integer numStars);
}
