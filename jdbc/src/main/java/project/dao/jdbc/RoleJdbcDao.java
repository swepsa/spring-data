package project.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

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
    public void create(Role role) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        getJdbcTemplate().update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement("INSERT INTO roles (name) VALUES (?)",
                        Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, role.getName());
                return ps;
            }
        }, keyHolder);

        role.setId(keyHolder.getKey().longValue());
    }

    @Override
    public Role read(Long id) {
        return getJdbcTemplate().queryForObject("SELECT * FROM roles WHERE id = ?", rowMapper, id);
    }

    @Override
    public void update(Role role) {
        getJdbcTemplate().update("UPDATE roles SET name = ? WHERE id = ?", role.getName(), role.getId());
    }

    @Override
    public void delete(Long id) {
        getJdbcTemplate().queryForObject("DELETE FROM roles WHERE id = ?", rowMapper, id);
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
