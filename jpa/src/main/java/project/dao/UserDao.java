package project.dao;

import java.util.List;

import project.entity.User;

public interface UserDao extends GenericDao<Long, User> {

    User findByName(String name);

    List<User> findAll();

    void deleteUserRoles(Long uid);

    void addRole(Long uid, Long rid);
}
