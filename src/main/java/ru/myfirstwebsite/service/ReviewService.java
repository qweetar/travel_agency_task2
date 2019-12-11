package ru.myfirstwebsite.service;

import ru.myfirstwebsite.domain.Review;

public interface ReviewService extends GenericService<Review, Long> {
    Iterable<Review> getReviewByTourId(Long id);

    Iterable<Review> getReviewByUserId(Long id);
}
