package project.services;

import java.util.List;

import project.entity.User;

public interface UserService {

    User getUser(Long uid);

    User getUser(String name);

    List<User> getUsers();

    void save(User user);

    void delete(Long uid);
}
