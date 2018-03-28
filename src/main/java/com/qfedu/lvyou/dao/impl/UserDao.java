package com.qfedu.lvyou.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qfedu.lvyou.dao.IUserDao;
import com.qfedu.lvyou.model.User;

@Repository
public class UserDao implements IUserDao {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void authenticate(String user, String password) {
		String hql = "from User u where u.loginName= :loginName and u.password = :password";
		List<User> users = sessionFactory.getCurrentSession().createQuery(hql, User.class)
				.setParameter("loginName", user).setParameter("password", password).getResultList();
		if (users.size() != 1) {
			throw new RuntimeException("用户验证失败！");
		}
	}

	@Override
	public User getUserByLoginName(String loginName) {
		String hql = "from User u where u.loginName=:loginName";
		return sessionFactory.getCurrentSession().createQuery(hql, User.class).setParameter("loginName", loginName)
				.uniqueResult();
	}

	@Override
	public List<User> getUsers() {
		String hql = "from User u order by id";
		return sessionFactory.getCurrentSession().createQuery(hql, User.class).getResultList();
	}

	@Override
	public void createUser(User user) {
		sessionFactory.getCurrentSession().persist(user);
	}

	@Override
	public User getUserById(String userId) {
		return sessionFactory.getCurrentSession().get(User.class, userId);
	}

	@Override
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().merge(user);
	}

	@Override
	public void deleteUserById(String id) {
		User u = this.getUserById(id);
		sessionFactory.getCurrentSession().delete(u);
	}

	@Override
	public List<User> getUsersByLoginName(String loginName, Long woPageStart, Long woPageSize) {
		String hql = "from User u where u.loginName like :loginName order by u.createTime";
		return sessionFactory.getCurrentSession().createQuery(hql, User.class)
				.setParameter("loginName", "%" + loginName + "%")
				.setFirstResult(woPageStart.intValue()).setMaxResults(woPageSize.intValue()).getResultList();
	}

	@Override
	public Long getUsersTotalByLoginName(String loginName) {
		String hql = "select count(*) from User u where u.loginName like :loginName";
		return (Long)sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter("loginName", "%" + loginName + "%").uniqueResult();
	}
}
