package ru.myfirstwebsite.dao.impl;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.myfirstwebsite.dao.UserDao;
import ru.myfirstwebsite.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public static final String USER_ID = "id";
    public static final String USER_LOGIN = "login";
    public static final String USER_NAME = "username";
    public static final String USER_EMAIL = "email";
    public static final String USER_PASSWORD = "password";

    public UserDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private User getUserRowMapper(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong(USER_ID));
        user.setLogin(resultSet.getString(USER_LOGIN));
        user.setUserName(resultSet.getString(USER_NAME));
        user.setEmail(resultSet.getString(USER_EMAIL));
        user.setPass(resultSet.getString(USER_PASSWORD));
        return user;
    }

    @Override
    public void save(User user) {
        final String saveQuery = "insert into usr (login, username, email, password) values (:login, :userName, :email, :pass)";


        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("login", user.getLogin());
        params.addValue("userName", user.getUserName());
        params.addValue("email", user.getEmail());
        params.addValue("pass", user.getPass());

        namedParameterJdbcTemplate.update(saveQuery, params);
    }

    @Override
    public User getById(Long id) {
        final String getByIdQuery = "select * from usr where id = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return namedParameterJdbcTemplate.queryForObject(getByIdQuery, params, this::getUserRowMapper);
    }

    @Override
    public List<User> findAll() {
        final String findAllQuery = "select * from usr";
        return namedParameterJdbcTemplate.query(findAllQuery, this::getUserRowMapper);
    }

    @Override
    public void update(User user) {
        final String updateQuery = "update usr set login = :login, username = :userName, email = :email," +
                "password = :pass where id = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("login", user.getLogin());
        params.addValue("userName", user.getUserName());
        params.addValue("email", user.getEmail());
        params.addValue("pass", user.getPass());

        params.addValue("id", user.getId());

        namedParameterJdbcTemplate.update(updateQuery, params);

    }

    @Override
    public void delete(Long id) {
        final String delete = "delete from usr where id = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        namedParameterJdbcTemplate.update(delete, params);
    }

    @Override
    public Long findUserIdByEmail(String email) {
        final String getByUserNameQuery = "select usr.id from usr where email = :email";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("email", email);

        List<Long> userIdList = namedParameterJdbcTemplate.query(getByUserNameQuery, params, new RowMapper() {
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getLong(1);
            }
        });

        if (userIdList.isEmpty()) {
            return null;
        } else if (userIdList.size() == 1) {
            return userIdList.get(0);
        } else {
         return userIdList.get(0);
        }

    }
}
