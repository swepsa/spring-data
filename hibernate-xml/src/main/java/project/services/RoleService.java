package project.services;

import project.entity.Role;

import java.util.List;

public interface RoleService {

    Role getRole(Long rid);

    List<Role> getUsersRoles(Long uid);

    List<Role> getRoles();

}
