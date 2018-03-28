package com.qfedu.lvyou.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qfedu.lvyou.dao.IRoleDao;
import com.qfedu.lvyou.model.Role;

@Repository
public class RoleDao implements IRoleDao {

	@Resource // @Autowired
	private SessionFactory sessionFactory;

	@Override
	public void createRole(Role role) {
		sessionFactory.getCurrentSession().persist(role);
	}

	@Override
	public Role getRoleById(String roleId) {
		return sessionFactory.getCurrentSession().get(Role.class, roleId);
	}

	@Override
	public void updateRole(Role role) {
		sessionFactory.getCurrentSession().merge(role);
	}

	@Override
	public List<Role> getRoles() {
		String hql = "from Role r";
		return sessionFactory.getCurrentSession().createQuery(hql, Role.class).getResultList();
	}
}
