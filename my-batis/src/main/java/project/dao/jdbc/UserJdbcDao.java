package project.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import project.dao.UserDao;
import project.entity.Role;
import project.entity.User;

public class UserJdbcDao extends JdbcDaoSupport implements UserDao {

    private RowMapper<Role> roleRowMapper = new RowMapper<Role>() {
        @Override
        public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
            Role role = new Role();
            role.setId(rs.getLong("role_id"));
            role.setName(rs.getString("role_name"));
            return role;
        }
    };

    private RowMapper<User> rowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            return user;
        }
    };

    private ResultSetExtractor<User> extractor = new ResultSetExtractor<User>() {
        @Override
        public User extractData(ResultSet rs) throws SQLException, DataAccessException {
            User user = null;
            while (rs.next()) {
                if (user == null) {
                    user = rowMapper.mapRow(rs, 0);
                }
                user.setRoles(new ArrayList<Role>());
                user.getRoles().add(roleRowMapper.mapRow(rs, 0));
            }
            return user;
        }
    };

    private ResultSetExtractor<List<User>> usersExtractor = new ResultSetExtractor<List<User>>() {

        @Override
        public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
            User user = null;
            List<User> users = new ArrayList<User>();
            while (rs.next()) {
                User userTemp = rowMapper.mapRow(rs, 0);
                userTemp.setRoles(new ArrayList<Role>());
                if (user == null) {
                    user = userTemp;
                }

                if (!user.getName().equals(userTemp.getName())) {
                    users.add(user);
                    user = userTemp;
                }
                user.getRoles().add(roleRowMapper.mapRow(rs, 0));
            }
            users.add(user);
            return users;
        }
    };

    @Override
    public void create(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        getJdbcTemplate().update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement("INSERT INTO users (name) VALUES (?)",
                        Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, user.getName());
                return ps;
            }
        }, keyHolder);
        user.setId(keyHolder.getKey().longValue());
    }

    @Override
    public User read(Long id) {
        try {
            return getJdbcTemplate().query(
                    "SELECT u.id AS id, u.name AS name, r.id AS role_id, r.name AS role_name FROM users u JOIN users_roles ur ON ur.user_id = u.id JOIN roles r ON r.id = ur.role_id WHERE u.id = ?",
                    extractor, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void update(User user) {
        getJdbcTemplate().update("UPDATE users SET name = ? WHERE id = ?", user.getName(), user.getId());
    }

    @Override
    public void delete(Long uid) {
        getJdbcTemplate().update("DELETE FROM users WHERE id = ?", uid);
    }

    @Override
    public User findByName(String name) {
        try {
            return getJdbcTemplate().query(
                    "SELECT u.id AS id, u.name AS name, r.id AS role_id, r.name AS role_name FROM users u JOIN users_roles ur ON ur.user_id = u.id JOIN roles r ON r.id = ur.role_id WHERE u.name= ?",
                    extractor, name);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        return getJdbcTemplate().query(
                "SELECT u.id AS id, u.name AS name, r.id AS role_id, r.name AS role_name FROM users u JOIN users_roles ur ON ur.user_id = u.id JOIN roles r ON r.id = ur.role_id",
                usersExtractor);
    }

    @Override
    public void deleteUserRoles(Long uid) {
        getJdbcTemplate().update("DELETE FROM users_roles WHERE user_id = ?", uid);
    }

    @Override
    public void addRole(Long uid, Long rid) {
        getJdbcTemplate().update("INSERT INTO users_roles (user_id, role_id) VALUES (?,?)", uid, rid);
    }
}
