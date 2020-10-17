package project.dao.hibernate;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import project.dao.RoleDao;
import project.entity.Role;

public class RoleHibernateDao extends HibernateDaoSupport implements RoleDao {

    @Override
    public Role find(Long rid) {
        return getHibernateTemplate().get(Role.class, rid);
    }

    @Override
    public List<Role> findUsersRoles(Long uid) {
        @SuppressWarnings("unchecked")
        Query<Role> query = currentSession().createNamedQuery("findUsersRoles");
        query.setParameter("id", uid);
        return query.list();
    }

    @Override
    public List<Role> findRoles() {
        return getHibernateTemplate().loadAll(Role.class);
    }

}
