package ru.myfirstwebsite.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.myfirstwebsite.aspect.LoggingAspect;

import javax.sql.DataSource;

@Configuration
@ComponentScan("ru.myfirstwebsite")
@EnableAspectJAutoProxy
@Import({
        PersistenceConfig.class
})
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


}
