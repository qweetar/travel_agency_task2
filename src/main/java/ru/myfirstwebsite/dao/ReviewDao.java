package ru.myfirstwebsite.dao;

import ru.myfirstwebsite.domain.Review;

public interface ReviewDao extends GenericDao<Review, Long> {
    Iterable<Review> getReviewByTourId(Long id);

    Iterable<Review> getReviewByUserId(Long id);
}
