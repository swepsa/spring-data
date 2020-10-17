package project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface GenericDao<ID, T> extends Dao<T> {

    final String read = "SELECT u.id AS user_id, u.name AS user_name FROM users u WHERE u.id = #{id}";
    final String create = "INSERT INTO users (name) VALUES (#{name})";
    final String update = "UPDATE users SET name = #{name} WHERE id = #{id}";
    final String delete = "DELETE FROM users WHERE id=#{id}";

    @Insert(create)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void create(T obj);

    @Select(read)
    @Results(value = { @Result(property = "id", column = "user_id"), @Result(property = "name", column = "user_name"),
            @Result(property = "roles", javaType = List.class, column = "user_id", 
                many = @Many(select = "project.dao.RoleDao.findUsersRoles")) })
    T read(ID id);

    @Update(update)
    void update(T obj);

    @Delete(delete)
    void delete(@Param("id") ID id);
}
