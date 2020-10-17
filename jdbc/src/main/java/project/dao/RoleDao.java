package project.dao;

import java.util.List;

import project.entity.Role;

public interface RoleDao extends GenericDao<Long, Role> {

    List<Role> findUsersRoles(Long uid);

    List<Role> findRoles();

}
