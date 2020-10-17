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

import project.dao.RoleDao;
import project.entity.Role;

@RunWith(EasyMockRunner.class)
public class RoleServiceImplTest {

    private static final long USER_ID = 1L;

    @Mock
    private RoleDao roleDao;

    @TestSubject
    private RoleService service = new RoleServiceImpl();

    @Test
    public void getRole_FindByUSER_ID() {
        Role expectedRole = new Role();
        expect(roleDao.find(USER_ID)).andReturn(expectedRole);
        replay(roleDao);

        Role actualRole = service.getRole(USER_ID);
        Assert.assertEquals(expectedRole, actualRole);
        verify(roleDao);
    }

    @Test
    public void getUsersRoles_FindUsersRolesByUSER_ID() {
        List<Role> expectedRoles = new ArrayList<>();
        expect(roleDao.findUsersRoles(USER_ID)).andReturn(expectedRoles);
        replay(roleDao);

        List<Role> actualRoles = service.getUsersRoles(USER_ID);
        Assert.assertEquals(expectedRoles, actualRoles);
        verify(roleDao);
    }

    @Test
    public void getRoles_FindAllRoles() {
        List<Role> expectedRoles = new ArrayList<>();
        expect(roleDao.findRoles()).andReturn(expectedRoles);
        replay(roleDao);

        List<Role> actualRoles = service.getRoles();
        Assert.assertEquals(expectedRoles, actualRoles);
        verify(roleDao);
    }

}
