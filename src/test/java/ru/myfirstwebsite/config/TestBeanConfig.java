package ru.myfirstwebsite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.myfirstwebsite.service.UserService;
import ru.myfirstwebsite.service.UserServiceImplTest;
import ru.myfirstwebsite.service.impl.UserServiceImpl;

@ComponentScan(basePackages = "ru.myfirstwebsite")
public class TestBeanConfig {

    }
