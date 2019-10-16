package ru.myfirstwebsite.service;

import java.util.List;

public interface GenericService<T, K> {

    List<T> findAll();

    boolean save(T entity);

    T getById(K id);

    void update(T entity);

    void delete(K id);
}
