package ru.myfirstwebsite.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.myfirstwebsite.dao.HotelDao;
import ru.myfirstwebsite.domain.Hotel;
import ru.myfirstwebsite.service.HotelService;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    public HotelDao hotelDao;

    @Override
    public List<Hotel> findAll() {
        return hotelDao.findAll();
    }

    @Override
    public boolean save(Hotel entity) {
        hotelDao.save(entity);
        return true;
    }

    @Override
    public Hotel getById(Long id) {
        return hotelDao.getById(id);
    }

    @Override
    public void update(Hotel entity) {
        hotelDao.update(entity);
    }

    @Override
    public void delete(Long id) {
        hotelDao.delete(id);
    }
}
