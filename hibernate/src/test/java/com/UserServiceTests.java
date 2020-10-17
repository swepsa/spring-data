package com;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import project.entity.User;
import project.services.UserService;

public class UserServiceTests {

    ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/config.xml");
    UserService service = ctx.getBean(UserService.class);

    @Test
    void getUser() {
        User user = service.getUser(1L);
        assert (user != null);
    }

    @Test
    void getUserByName() {
        User user = service.getUser("user");
        assert (user != null);
    }

    @Test
    void getUsers() {
        List<User> users = service.getUsers();
        assert (users != null);
    }

    @Test
    void save() {
        User user = service.getUser("user");
        assert (user != null);
        service.save(user);
    }

    @Test
    void createAndDelete() {
        User user = new User();
        user.setName("Test JUnit");
        service.save(user);
        service.delete(user);
    }
}
