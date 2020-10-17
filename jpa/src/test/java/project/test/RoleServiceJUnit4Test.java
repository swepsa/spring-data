package project.test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import project.services.RoleService;

public class RoleServiceJUnit4Test extends BaseJUnit4Test {

    private static final Long USER_ID = 1L;
    private static final Long ABSENT_USER_ID = 9999L;

    @Autowired
    private RoleService service;

    @Test
    public void getRole_GetRoleByUSER_ID() {
        assertNotNull(service.getRole(USER_ID));
    }

    @Test
    public void getRole_GetRoleByABSENT_USER_ID() {
        assertNull(service.getRole(ABSENT_USER_ID));
    }

    @Test
    public void getUsersRolesByUSER_ID() {
        assertFalse(service.getUsersRoles(USER_ID).isEmpty());
    }

    @Test
    public void getRoles_GetAllRolesNotNull() {
        assertNotNull(service.getRoles());
    }

    @Test
    public void getRoles_GetAllRolesNotEmpty() {
        assertFalse(service.getRoles().isEmpty());
    }
}
