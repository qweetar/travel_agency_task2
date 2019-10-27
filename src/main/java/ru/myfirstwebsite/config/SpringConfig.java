package ru.myfirstwebsite.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.myfirstwebsite.aspect.LoggingAspect;
import ru.myfirstwebsite.dao.*;
import ru.myfirstwebsite.dao.impl.*;
import ru.myfirstwebsite.service.*;
import ru.myfirstwebsite.service.impl.*;

import javax.sql.DataSource;

@Configuration
@EnableAspectJAutoProxy
@Import(DatabaseConfig.class)
public class SpringConfig {

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate getNameParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public LoggingAspect getLoggingAspect() {
        return new LoggingAspect();
    }

//  @Bean(initMethod = "migrate")
//  Flyway flyway() {
//    Flyway flyway = Flyway.configure().dataSource(dataSource).load();
//    flyway.migrate();
//    return flyway;
//}

    @Bean
    public UserDao getUserDao() {
        return new UserDaoImpl(getNameParameterJdbcTemplate());
    }

    @Bean
    public CountryDao getCountryDao() {
        return new CountryDaoImpl(getNameParameterJdbcTemplate());
    }

    @Bean
    public HotelDao getHotelDao() {
        return new HotelDaoImpl(getNameParameterJdbcTemplate());
    }

    @Bean
    public ReviewDao getReviewDao() {
        return new ReviewDaoImpl(getNameParameterJdbcTemplate());
    }

    @Bean
    public TourDao getTourDao() {
        return new TourDaoImpl(getNameParameterJdbcTemplate());
    }


    @Bean
    public UserService getUserService() {
        return new UserServiceImpl();
    }

    @Bean
    public CountryService getCountryService() {
        return new CountryServiceImpl();
    }

    @Bean
    public HotelService getHotelService() {
        return new HotelServiceImpl();
    }

    @Bean
    public ReviewService getReviewService() {
        return new ReviewServiceImpl();
    }

    @Bean
    public TourService getTourService() {
        return new TourServiceImpl();
    }

}
