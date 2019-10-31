package ru.myfirstwebsite.dao.impl;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.myfirstwebsite.dao.ReviewDao;
import ru.myfirstwebsite.domain.Review;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ReviewDaoImpl implements ReviewDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public static final String REVIEW_ID  = "id";
    public static final String REVIEW_DATE  = "date";
    public static final String REVIEW_TEXT  = "text";
    public static final String REVIEW_USER_ID  = "user_id";
    public static final String REVIEW_TOUR_ID  = "tour_id";

    public ReviewDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private Review getReviewRowMapper(ResultSet resultSet, int i) throws SQLException {
        Review review = new Review();
        review.setTourId(resultSet.getLong(REVIEW_ID));
        review.setReviewDate(resultSet.getTimestamp(REVIEW_DATE));
        review.setReviewText(resultSet.getString(REVIEW_TEXT));
        review.setUserId(resultSet.getLong(REVIEW_USER_ID));
        review.setTourId(resultSet.getLong(REVIEW_TOUR_ID));
        return review;
    }

    @Override
    public List<Review> findAll() {
        final String findAllQuery = "select * from review";
        return namedParameterJdbcTemplate.query(findAllQuery, this::getReviewRowMapper);
    }

    @Override
    public Review getById(Long id) {
        final String getByIdQuery = "select * from review where id = :reviewId";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("reviewId", id);

        return namedParameterJdbcTemplate.queryForObject(getByIdQuery, params, this::getReviewRowMapper);
    }

    @Override
    public void delete(Long id) {
        final String deleteQuery = "delete from review where id = :reviewId";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("reviewId", id);

        namedParameterJdbcTemplate.update(deleteQuery, params);
    }

    @Override
    public void save(Review entity) {
        final String saveQuery = "insert into review (date, text, user_id, tour_id) values (:reviewDate, " +
                ":reviewText, :userId, :tourId)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("reviewDate", entity.getReviewDate());
        params.addValue("reviewText", entity.getReviewText());
        params.addValue("userId", entity.getUserId());
        params.addValue("tourId", entity.getTourId());

        namedParameterJdbcTemplate.update(saveQuery, params);
    }

    @Override
    public void update(Review entity) {
        final String updateQuery = "update review set date = :reviewDate, text = :reviewText, user_id = :userId, " +
                "tour_id = :tourId where id = :reviewId";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("reviewDate", entity.getReviewDate());
        params.addValue("reviewText", entity.getReviewText());
        params.addValue("userId", entity.getUserId());
        params.addValue("tourId", entity.getTourId());
        params.addValue("reviewId", entity.getReviewId());

        namedParameterJdbcTemplate.update(updateQuery, params);

    }
}
