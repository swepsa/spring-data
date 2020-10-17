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
        return dao.read(rid);
    }

    @Override
    public List<Role> getUsersRoles(Long uid) {
        return dao.findUsersRoles(uid);
    }

    @Override
    public List<Role> getRoles() {
        return dao.findRoles();
    }

    @Override
    public void save(Role role) {
        if (role.getId() == null) {
            dao.create(role);
        } else {
            dao.update(role);
        }
    }

    @Override
    public void delete(Role role) {
        dao.delete(role.getId());
    }

}
