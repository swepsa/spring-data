package project.services;

import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.*;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import project.dao.UserDao;
import project.entity.User;

@RunWith(EasyMockRunner.class)
public class UserServiceImplTest {

    private static final String USER_NAME = "user";
    private static final long USER_ID = 1L;

    @Mock
    private UserDao userDao;

    @TestSubject
    private UserService service = new UserServiceImpl();

    @Test
    public void getUser_ReadByUSER_ID() {
        User expectedUser = new User();
        expect(userDao.read(USER_ID)).andReturn(expectedUser);
        replay(userDao);

        User actualUser = service.getUser(USER_ID);
        Assert.assertEquals(expectedUser, actualUser);
        verify(userDao);
    }

    @Test
    public void getUserByName_FindByNameByUSER_NAME() {
        User expectedUser = new User();
        expect(userDao.findByName(USER_NAME)).andReturn(expectedUser);
        replay(userDao);

        User actualUser = service.getUser(USER_NAME);
        Assert.assertEquals(expectedUser, actualUser);
        verify(userDao);
    }

    @Test
    public void getUsers_FindAll() {
        List<User> expectedUsers = new ArrayList<User>();
        expect(userDao.findAll()).andReturn(expectedUsers);
        replay(userDao);

        List<User> actualUsers = service.getUsers();
        Assert.assertEquals(expectedUsers, actualUsers);
        verify(userDao);
    }

}
