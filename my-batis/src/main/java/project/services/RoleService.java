package project.services;

import java.util.List;

import project.entity.Role;

public interface RoleService {

    Role getRole(Long rid);

    List<Role> getUsersRoles(Long uid);

    List<Role> getRoles();

}
