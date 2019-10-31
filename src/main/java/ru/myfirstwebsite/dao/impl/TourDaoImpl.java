package ru.myfirstwebsite.dao.impl;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.myfirstwebsite.dao.TourDao;
import ru.myfirstwebsite.domain.Tour;
import ru.myfirstwebsite.domain.enums.TourType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TourDaoImpl implements TourDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public static final String TOUR_ID = "id";
    public static final String TOUR_PHOTO = "photo";
    public static final String TOUR_DATE = "date";
    public static final String TOUR_DURATION = "duration";
    public static final String TOUR_DESCRIPTION = "description";
    public static final String TOUR_COST = "cost";
    public static final String TOUR_TYPE = "tour_type ";
    public static final String HOTEL_ID = "hotel_id";
    public static final String COUNTRY_ID = "country_id";

    public TourDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private Tour getTourRowMapper(ResultSet resultSet, int i) throws SQLException {
        Tour tour = new Tour();
        tour.setTourId(resultSet.getLong(TOUR_ID));
        tour.setTourPhoto(resultSet.getString(TOUR_PHOTO));
        tour.setTourDate(resultSet.getTimestamp(TOUR_DATE));
        tour.setTourDuration(resultSet.getInt(TOUR_DURATION));
        tour.setTourDescription(resultSet.getString(TOUR_DESCRIPTION));
        tour.setTourCost(resultSet.getInt(TOUR_COST));
        tour.setTourType(TourType.valueOf(resultSet.getString(TOUR_TYPE)));
        tour.setHotelId(resultSet.getLong(HOTEL_ID));
        tour.setCountryId(resultSet.getInt(COUNTRY_ID));
        return tour;
    }

    @Override
    public List<Tour> findAll() {
        final String findAllQuery = "select * from tour";
        return namedParameterJdbcTemplate.query(findAllQuery, this::getTourRowMapper);
    }

    @Override
    public Tour getById(Long id) {
        final String getByIdQuery = "select * from tour id = :tourId";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("tourId", id);
        return namedParameterJdbcTemplate.queryForObject(getByIdQuery, params, this::getTourRowMapper);
    }

    @Override
    public void delete(Long id) {
        final String deleteQuery = "delete from tour where id = :tourId";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("tourId", id);

        namedParameterJdbcTemplate.update(deleteQuery, params);

    }

    @Override
    public void save(Tour entity) {
        final String saveQuery = "insert into tour (photo, date, duration, description, cost, tour_type, " +
                "hotel_id, country_id) values (:tourPhoto, :tourDate, :tourDuration, :tourDescription, :tourCost, " +
                ":tourType, :hotelId, :countryId)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("tourPhoto", entity.getTourPhoto());
        params.addValue("tourDate", entity.getTourDate());
        params.addValue("tourDuration", entity.getTourDuration());
        params.addValue("tourDescription", entity.getTourDescription());
        params.addValue("tourCost", entity.getTourCost());
        params.addValue("tourType", entity.getTourType());
        params.addValue("hotelId", entity.getHotelId());
        params.addValue("countryId", entity.getCountryId());

        namedParameterJdbcTemplate.update(saveQuery, params);

    }

    @Override
    public void update(Tour entity) {
        final String updateQuery = "update tour set photo = :tourPhoto, date = :tourDate, duration = :tourDuration, " +
                "description = :tourDescription, cost = :tourCost, tour_type = :tourType, hotel_id = :hotelId, " +
                "country_id = :countryId where id = :tourId";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("tourPhoto", entity.getTourPhoto());
        params.addValue("tourDate", entity.getTourDate());
        params.addValue("tourDuration", entity.getTourDuration());
        params.addValue("tourDescription", entity.getTourDescription());
        params.addValue("tourCost", entity.getTourCost());
        params.addValue("tourType", entity.getTourType());
        params.addValue("hotelId", entity.getHotelId());
        params.addValue("countryId", entity.getCountryId());
        params.addValue("tourId", entity.getTourId());

        namedParameterJdbcTemplate.update(updateQuery, params);
    }
}
