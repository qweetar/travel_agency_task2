package ru.myfirstwebsite.dao.impl;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.myfirstwebsite.dao.HotelDao;
import ru.myfirstwebsite.domain.Hotel;
import ru.myfirstwebsite.domain.enums.Features;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HotelDaoImpl implements HotelDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public static final String HOTEL_ID = "id";
    public static final String HOTEL_NAME = "name";
    public static final String HOTEL_STARS = "stars";
    public static final String HOTEL_WEBSITE = "website";
    public static final String HOTEL_LATITUDE = "latitude";
    public static final String HOTEL_LONGITUDE = "longitude";
    public static final String HOTEL_FEATURES = "features";

    public HotelDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private Hotel getHotelRowMapper(ResultSet resultSet, int i) throws SQLException {
        Hotel hotel = new Hotel();
        hotel.setHotelId(resultSet.getLong(HOTEL_ID));
        hotel.setHotelName(resultSet.getString(HOTEL_NAME));
        hotel.setHotelStars(resultSet.getInt(HOTEL_STARS));
        hotel.setHotelWebSite(resultSet.getString(HOTEL_WEBSITE));
        hotel.setHotelLatitude(resultSet.getString(HOTEL_LATITUDE));
        hotel.setHotelLongitude(resultSet.getString(HOTEL_LONGITUDE));
        hotel.setHotelFeatures(Features.valueOf(resultSet.getString(HOTEL_FEATURES)));
        return hotel;
    }

    @Override
    public List<Hotel> findAll() {
        final String findAllQuery = "select * from hotel";
        return namedParameterJdbcTemplate.query(findAllQuery, this::getHotelRowMapper);
    }

    @Override
    public Hotel getById(Long id) {
        final String getByIdQuery = "select * from hotel where id = :hotelId";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("hotelId", id);

        return namedParameterJdbcTemplate.queryForObject(getByIdQuery, params, this::getHotelRowMapper);
    }

    @Override
    public void delete(Long id) {
        final String deleteQuery = "delete from hotel where id = :hotelId";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("hotelId", id);

        namedParameterJdbcTemplate.update(deleteQuery, params);
    }

    @Override
    public void save(Hotel entity) {
        final String saveQuery = "insert into hotel (name, stars, website, latitude, longitude, features) " +
                "values (:hotelName, :hotelStars, :hotelWebsite, :hotelLatitude, :hotelLongitude, :hotelFeatures)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("hotelName", entity.getHotelName());
        params.addValue("hotelStars", entity.getHotelStars());
        params.addValue("hotelWebsite", entity.getHotelWebSite());
        params.addValue("hotelLatitude", entity.getHotelLatitude());
        params.addValue("hotelLongitude", entity.getHotelLongitude());
        params.addValue("hotelFeatures", entity.getHotelFeatures());

        namedParameterJdbcTemplate.update(saveQuery, params);

    }

    @Override
    public void update(Hotel entity) {
        final  String updateQuery = "update hotel set name = :hotelName, stars = :hotelStars, website = :hotelWebsite," +
                "latitude = :hotelLatitude, longitude = :hotelLongitude, features = :hotelFeatures where id = :hotelId";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("hotelName", entity.getHotelName());
        params.addValue("hotelStars", entity.getHotelStars());
        params.addValue("hotelWebsite", entity.getHotelWebSite());
        params.addValue("hotelLatitude", entity.getHotelLatitude());
        params.addValue("hotelLongitude", entity.getHotelLongitude());
        params.addValue("hotelFeatures", entity.getHotelFeatures());
        params.addValue("hotelId", entity.getHotelId());

        namedParameterJdbcTemplate.update(updateQuery, params);

    }
}
