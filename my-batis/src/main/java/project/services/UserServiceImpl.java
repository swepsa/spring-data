package project.services;

import java.util.List;

import project.dao.UserDao;
import project.entity.Role;
import project.entity.User;

public class UserServiceImpl implements UserService {

    private UserDao dao;

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
        if (user.getId() == null) {
            dao.create(user);
        } else {
            dao.update(user);
        }

        Long uid = user.getId();
        dao.deleteUserRoles(uid);

        // add the role to user
        if (user.getRoles() != null) {
            for (Role role : user.getRoles()) {
                dao.addRole(uid, role.getId());
            }
        }

    }

    @Override
    public void delete(User user) {
        Long uid = user.getId();
        dao.deleteUserRoles(uid);
        dao.delete(uid);
    }

}
