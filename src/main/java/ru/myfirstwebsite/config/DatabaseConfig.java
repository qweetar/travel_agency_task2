package ru.myfirstwebsite.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:database.properties")
public class DatabaseConfig {

    @Autowired
    private Environment properties;

  @Bean(value = "dataSource")
  @Scope("singleton")
  public DataSource getDataSource() {
    HikariConfig hikariConfig = new HikariConfig();
    hikariConfig.setDriverClassName(properties.getProperty("driverName"));
    hikariConfig.setJdbcUrl(properties.getProperty("url"));
    hikariConfig.setUsername(properties.getProperty("login"));
    hikariConfig.setPassword(properties.getProperty("password"));

    hikariConfig.setMaximumPoolSize(5);
//    hikariConfig.setConnectionTestQuery("SELECT 1");
    hikariConfig.setPoolName("springHikariCP");

    hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
    hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "250");
    hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
    hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");

    HikariDataSource dataSource = new HikariDataSource(hikariConfig);
    return dataSource;
  }

//    @Bean(value = "dataSource")
//    @Scope("singleton")
//    public DataSource getDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(properties.getProperty("driverName"));
//        dataSource.setPassword(properties.getProperty("password"));
//        dataSource.setUrl(properties.getProperty("url"));
//        dataSource.setUsername(properties.getProperty("login"));
//        return dataSource;
//    }

//    @Bean(destroyMethod = "close")
//    public DataSource dataSource(){
//        HikariConfig hikariConfig = new HikariConfig();
//        hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
//        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/spring-test");
//        hikariConfig.setUsername("root");
//        hikariConfig.setPassword("admin");
//
//        hikariConfig.setMaximumPoolSize(5);
//        hikariConfig.setConnectionTestQuery("SELECT 1");
//        hikariConfig.setPoolName("springHikariCP");
//
//        hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
//        hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "250");
//        hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
//        hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");
//
//        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
//
//        return dataSource;
//    }
}
