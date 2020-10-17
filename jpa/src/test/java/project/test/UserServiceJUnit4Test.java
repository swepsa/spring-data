package project.test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import project.entity.User;
import project.services.UserService;

public class UserServiceJUnit4Test extends BaseJUnit4Test {

    private static final Long USER_ID = 1L;
    private static final String USER_NAME = "user";

    @Autowired
    private UserService service;

    @Test
    public void getUserByUSER_ID() {
        assertNotNull(service.getUser(USER_ID));
    }

    @Test
    public void getUserByUSER_NAME() {
        assertNotNull(service.getUser(USER_NAME));
    }

    @Test
    public void getAllUsers() {
        assertNotNull(service.getUsers());
    }

    @Test
    public void saveUser() {
        User expectedUser = service.getUser(USER_NAME);
        service.save(expectedUser);
        User actualUser = service.getUser(USER_NAME);
        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void createUser() {
        final String TestNameUser="Test JUnit"; 
        User user = new User();
        user.setName(TestNameUser);
        service.save(user);
        User actualUser = service.getUser(TestNameUser);
        assertEquals(user, actualUser);
    }

    @Test
    public void deleteUser() {
        service.delete(USER_ID);
        User user = service.getUser(USER_ID);
        assertNull(user);
    }
}
