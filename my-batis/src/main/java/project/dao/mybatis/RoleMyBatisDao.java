package project.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import project.dao.RoleDao;
import project.entity.Role;

public class RoleMyBatisDao extends SqlSessionDaoSupport implements RoleDao{

    @Override
    public Role find(Long rid) {
        return getSqlSession().selectOne("Role.read", rid);
    }

    @Override
    public List<Role> findUsersRoles(Long uid) {
        return getSqlSession().selectList("Role.findUsersRoles", uid);
    }

    @Override
    public List<Role> findRoles() {
        return getSqlSession().selectList("Role.findAll");
    }

}
