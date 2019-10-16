package ru.myfirstwebsite.dao;

import ru.myfirstwebsite.domain.User;


public interface UserDao extends GenericDao<User, Long> {

    Long findUserIdByEmail(String email);
}
