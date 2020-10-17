package project.dao;

import java.util.List;

import project.entity.Role;

public interface RoleDao extends Dao<Role> {

    Role find(Long rid);

    List<Role> findUsersRoles(Long uid);

    List<Role> findRoles();
}
