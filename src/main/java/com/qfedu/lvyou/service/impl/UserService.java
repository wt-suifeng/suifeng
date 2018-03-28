package com.qfedu.lvyou.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.qfedu.lvyou.dao.IUserDao;
import com.qfedu.lvyou.model.PageBean;
import com.qfedu.lvyou.model.User;
import com.qfedu.lvyou.service.IUserService;

@Service
@Transactional
public class UserService implements IUserService {

	@Resource
	private IUserDao userDao;
	
	@Override
	public void autenticate(String user, String password) {
		userDao.authenticate(user, password);
//		if (!"admin".equals(user) || !"123456".equals(password)) {
//			throw new RuntimeException ("用户名或者密码不正确！");
//		}
	}

	@Override
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Override
	public void createUser(User user) {
		userDao.createUser(user);
	}

	@Override
	public PageBean<User> getUsersByLoginName(String loginName, Long woPageStart, Long woPageSize) {
		if (loginName == null) {
			// return getUsers();
			loginName = "";
		}
		PageBean<User> pg = new PageBean<User>();
		// 设置分页列表数据
		pg.setList(userDao.getUsersByLoginName(loginName, woPageStart, woPageSize));
		// 设置总数量
		pg.setTotal(userDao.getUsersTotalByLoginName(loginName));
		return pg;
	}

	@Override
	public User getUserById(String userId) {
		return userDao.getUserById(userId);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public void deleteUsers(String[] ids) {
		for (int i = 0; i < ids.length; i ++) {
			userDao.deleteUserById (ids[i]);
		}
	}

	@Override
	public void importUsers(List<User> users) {
		for (User u : users) {
			createUser(u);
		}
	}

}
