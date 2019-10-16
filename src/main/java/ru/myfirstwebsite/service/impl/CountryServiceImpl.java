package ru.myfirstwebsite.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.myfirstwebsite.dao.CountryDao;
import ru.myfirstwebsite.domain.Country;
import ru.myfirstwebsite.service.CountryService;

import java.util.List;

public class CountryServiceImpl implements CountryService {

    @Autowired
    public CountryDao countryDao;

    @Override
    public List<Country> findAll() {
        return countryDao.findAll();
    }

    @Override
    public boolean save(Country entity) {
        countryDao.save(entity);
        return true;
    }

    @Override
    public Country getById(Integer id) {
        return countryDao.getById(id);
    }

    @Override
    public void update(Country entity) {
        countryDao.update(entity);
    }

    @Override
    public void delete(Integer id) {
        countryDao.delete(id);
    }
}
