package ru.myfirstwebsite.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import ru.myfirstwebsite.config.SpringConfig;
import ru.myfirstwebsite.config.TestBeanConfig;
import ru.myfirstwebsite.dao.UserDao;
import ru.myfirstwebsite.domain.User;
import ru.myfirstwebsite.service.impl.UserServiceImpl;

import static org.junit.Assert.*;

//@RunWith(MockitoJUnitRunner.class)
//@ContextConfiguration(classes = {TestBeanConfig.class, SpringConfig.class})
//@SpringJUnitConfig
public class UserServiceImplTest {

//  @Qualifier("getUserService")
  @Autowired
  private UserService userService;

  @Mock
  private UserDao userDao;

  @Test
  public void save() {
    User user = new User();

    boolean isUserCreated = userService.save(user);

    assertTrue(isUserCreated);
  }
}