package ru.myfirstwebsite.dao.impl;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.myfirstwebsite.dao.CountryDao;
import ru.myfirstwebsite.domain.Country;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CountryDaoImpl implements CountryDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public static final String COUNTRY_ID = "id";
    public static final String COUNTRY_NAME = "name";

    public CountryDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private Country getCountryRowMapper(ResultSet resultSet, int i) throws SQLException {
        Country country = new Country();
        country.setCountryId(resultSet.getInt(COUNTRY_ID));
        country.setCountryName(resultSet.getString(COUNTRY_NAME));
        return country;
    }

    @Override
    public List<Country> findAll() {
        final String findAllQuery = "select * from country";
        return namedParameterJdbcTemplate.query(findAllQuery, this::getCountryRowMapper);
    }

    @Override
    public Country getById(Integer id) {
        final String getByIdQuery = "select * from country where id = :countryId";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("countryId", id);

        return namedParameterJdbcTemplate.queryForObject(getByIdQuery, params, this::getCountryRowMapper);
    }

    @Override
    public void delete(Integer id) {
        final String deleteQuery = "delete from country where id = :countryId";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("countryId", id);

        namedParameterJdbcTemplate.update(deleteQuery, params);
    }

    @Override
    public void save(Country entity) {
        final String saveQuery = "insert into country (name) values (:countryName)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("countryName", entity.getCountryName());

        namedParameterJdbcTemplate.update(saveQuery, params);

    }

    @Override
    public void update(Country entity) {
        final String updateQuery = "update country set name = :countryName where id = :countryId";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("countryName", entity.getCountryName());
        params.addValue("countryId", entity.getCountryId());

        namedParameterJdbcTemplate.update(updateQuery, params);
    }
}
