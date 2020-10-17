package project.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import project.dao.RoleDao;

import project.entity.Role;

public class RoleJdbcDao extends JdbcDaoSupport implements RoleDao {

    private RowMapper<Role> rowMapper = new RowMapper<Role>() {
        @Override
        public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
            Role role = new Role();
            role.setId(rs.getLong("id"));
            role.setName(rs.getString("name"));
            return role;
        }
    };

    @Override
    public Role find(Long id) {
        return getJdbcTemplate().queryForObject("SELECT * FROM roles WHERE id = ?", rowMapper, id);
    }

    @Override
    public List<Role> findUsersRoles(Long uid) {
        return getJdbcTemplate().query(
                "SELECT * FROM roles where id IN (SELECT role_id FROM users_roles WHERE user_id = ?)", rowMapper, uid);
    }

    @Override
    public List<Role> findRoles() {
        return getJdbcTemplate().query("SELECT * FROM roles", rowMapper);
    }

}
