package project.services;

import java.util.List;

import project.dao.UserDao;
import project.entity.Role;
import project.entity.User;

public class UserServiceImpl implements UserService {

    private UserDao dao;

    private RoleService roleService;

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    public void setUserDao(final UserDao dao) {
        this.dao = dao;
    }

    @Override
    public User getUser(final Long uid) {
        User user = dao.read(uid);
        return user;
    }

    @Override
    public User getUser(final String name) {
        User user = dao.findByName(name);
        return user;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = dao.findAll();
        return users;
    }

    @Override
    public void save(final User user) {
        for (Role role : user.getRoles()) {
            roleService.save(role);
        }

        if (user.getId() == null) {
            dao.create(user);
        } else {
            dao.update(user);
        }
    }

    @Override
    public void delete(User user) {
        dao.delete(user.getId());
    }

}
