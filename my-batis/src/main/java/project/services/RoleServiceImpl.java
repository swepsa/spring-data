package project.services;

import java.util.List;

import project.dao.RoleDao;
import project.entity.Role;

public class RoleServiceImpl implements RoleService {

    private RoleDao dao;

    public void setRoleDao(final RoleDao dao) {
        this.dao = dao;
    }

    @Override
    public Role getRole(Long rid) {
        return dao.find(rid);
    }

    @Override
    public List<Role> getUsersRoles(Long uid) {
        return dao.findUsersRoles(uid);
    }

    @Override
    public List<Role> getRoles() {
        return dao.findRoles();
    }

}
