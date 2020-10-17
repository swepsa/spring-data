package project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Many;

import project.entity.User;

public interface UserDao extends GenericDao<Long, User> {

    final String findByName = "SELECT u.id AS user_id, u.name AS user_name FROM users u WHERE u.name = #{name}";
    final String findAll = "SELECT u.id AS user_id, u.name AS user_name FROM users u";
    final String deleteUserRoles = "DELETE FROM users_roles WHERE user_id = #{id}";
    final String addRole = "INSERT INTO users_roles (user_id, role_id) VALUES (#{uid},#{rid})";

    @Select(findByName)
    @Results(value = { @Result(property = "id", column = "user_id"), @Result(property = "name", column = "user_name"),
            @Result(property = "roles", javaType = List.class, column = "user_id", many = @Many(select = "project.dao.RoleDao.findUsersRoles")) })
    User findByName(String name);

    @Select(findAll)
    @Results(value = {@Result(property = "id", column = "user_id"), @Result(property = "name", column = "user_name"),
            @Result(property = "roles", javaType = List.class, column = "user_id", many = @Many(select = "project.dao.RoleDao.findUsersRoles"))})
    List<User> findAll();

    @Delete(deleteUserRoles)
    void deleteUserRoles(@Param("id") Long uid);

    @Insert(addRole)
    void addRole(@Param("uid") Long uid, @Param("rid") Long rid);
}
