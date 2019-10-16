package ru.myfirstwebsite.domain;

import java.util.Date;
import java.util.Objects;

public class Review {
    private Long reviewId;
    private Date reviewDate;
    private String reviewText;
    private Long userId;
    private Long tourId;

    public Review() {
    }

    public Review(Long reviewId, Date reviewDate, String reviewText, Long userId, Long tourId) {
        this.reviewId = reviewId;
        this.reviewDate = reviewDate;
        this.reviewText = reviewText;
        this.userId = userId;
        this.tourId = tourId;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTourId() {
        return tourId;
    }

    public void setTourId(Long tourId) {
        this.tourId = tourId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(getReviewId(), review.getReviewId()) &&
                Objects.equals(getReviewDate(), review.getReviewDate()) &&
                Objects.equals(getReviewText(), review.getReviewText()) &&
                Objects.equals(getUserId(), review.getUserId()) &&
                Objects.equals(getTourId(), review.getTourId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReviewId(), getReviewDate(), getReviewText(), getUserId(), getTourId());
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", reviewDate=" + reviewDate +
                ", reviewText='" + reviewText + '\'' +
                ", userId=" + userId +
                ", tourId=" + tourId +
                '}';
    }
}
