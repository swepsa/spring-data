package com;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import project.entity.Role;
import project.services.RoleService;

class RoleServiceTests {

    ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/config.xml");
    RoleService service = ctx.getBean(RoleService.class);

    @Test
    void getRole() {
        Role role = service.getRole(1L);
        assert (role != null);
    }

    @Test
    void getUsersRoles() {
        Collection<Role> roles = service.getUsersRoles(1L);
        assert (roles != null);
    }

    @Test
    void getRoles() {
        Collection<Role> roles = service.getRoles();
        assert (roles != null);
    }

}
