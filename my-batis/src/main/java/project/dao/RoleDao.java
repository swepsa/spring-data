package project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;

import project.entity.Role;

public interface RoleDao extends Dao<Role> {

    final String read = "SELECT id AS role_id,  name AS role_name FROM roles WHERE id = #{id}";
    final String findUsersRoles = "SELECT id AS role_id,  name AS role_name FROM roles WHERE id = #{id}";
    final String findRoles = "SELECT id AS role_id, name AS role_name FROM roles";

    @Select(read)
    @Results(value = { @Result(property = "id", column = "role_id"), @Result(property = "name", column = "role_name") })
    Role find(Long rid);

    @Select(findUsersRoles)
    @Results(value = { @Result(property = "id", column = "role_id"), @Result(property = "name", column = "role_name") })
    List<Role> findUsersRoles(Long uid);

    @Select(findRoles)
    @Results(value = { @Result(property = "id", column = "role_id"), @Result(property = "name", column = "role_name") })
    List<Role> findRoles();

}
