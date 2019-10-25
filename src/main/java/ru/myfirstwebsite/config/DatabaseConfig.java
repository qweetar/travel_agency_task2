package ru.myfirstwebsite.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

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

}
