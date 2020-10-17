package project.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import project.dao.UserDao;
import project.entity.User;

public class UserMyBatisDao extends SqlSessionDaoSupport implements UserDao {

    @Override
    public void create(User user) {
        getSqlSession().insert("User.create", user);
    }

    @Override
    public User read(Long id) {
        return getSqlSession().selectOne("User.read", id);
    }

    @Override
    public void update(User user) {
        getSqlSession().update("User.update", user);
    }

    @Override
    public void delete(Long uid) {
        getSqlSession().delete("User.deleteUser", uid);
    }

    @Override
    public User findByName(String name) {
        return getSqlSession().selectOne("User.findByName", name);
    }

    @Override
    public List<User> findAll() {
        return getSqlSession().selectList("User.findAll");
    }

    @Override
    public void deleteUserRoles(Long uid) {
        getSqlSession().delete("User.deleteUsers_roles", uid);
    }

    @Override
    public void addRole(Long uid, Long rid) {
        Map<String, Long> map = new HashMap<>();
        map.put("uid", uid);
        map.put("rid", rid);
        getSqlSession().insert("User.addRole", map);
    }
}
