package ru.myfirstwebsite.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.myfirstwebsite.dao.ReviewDao;
import ru.myfirstwebsite.domain.Review;
import ru.myfirstwebsite.service.ReviewService;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    public ReviewDao reviewDao;

    @Override
    public List<Review> findAll() {
        return reviewDao.findAll();
    }

    @Override
    public boolean save(Review entity) {
        reviewDao.save(entity);
        return true;
    }

    @Override
    public Review getById(Long id) {
        return reviewDao.getById(id);
    }

    @Override
    public void update(Review entity) {
        reviewDao.update(entity);
    }

    @Override
    public void delete(Long id) {
        reviewDao.delete(id);
    }
}
