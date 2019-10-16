package ru.myfirstwebsite.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.myfirstwebsite.dao.TourDao;
import ru.myfirstwebsite.domain.Tour;
import ru.myfirstwebsite.service.TourService;

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
}
