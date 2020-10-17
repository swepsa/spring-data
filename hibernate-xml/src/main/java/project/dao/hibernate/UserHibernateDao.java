package project.dao.hibernate;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import project.dao.UserDao;
import project.entity.User;

public class UserHibernateDao extends HibernateDaoSupport implements UserDao {

    @Override
    public void create(User obj) {
        getHibernateTemplate().saveOrUpdate(obj);
    }

    @Override
    public User read(Long id) {
        return getHibernateTemplate().get(User.class, id);
    }

    @Override
    public void update(User obj) {
        getHibernateTemplate().update(obj);
    }

    @Override
    public void delete(Long id) {
        getHibernateTemplate().delete(read(id));
    }

    @Override
    public User findByName(String name) {
        @SuppressWarnings("unchecked")
        Query<User> query = currentSession().createNamedQuery("findByName");
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Override
    public List<User> findAll() {
        return getHibernateTemplate().loadAll(User.class);
    }

    @Override
    public void deleteUserRoles(Long uid) {
        return;
    }

    @Override
    public void addRole(Long uid, Long rid) {
        return;
    }

}
