package com.qfedu.lvyou.service;

import java.util.List;

import com.qfedu.lvyou.model.PageBean;
import com.qfedu.lvyou.model.User;

public interface IUserService {
	
	public void autenticate (String user, String password);

	/**
	 * @return
	 */
	public List<User> getUsers();

	/**
	 * @param user
	 */
	public void createUser(User user);

	/**
	 * @param loginName
	 * @param woPageSize 
	 * @param woPageStart 
	 * @return
	 */
	public PageBean<User> getUsersByLoginName(String loginName, Long woPageStart, Long woPageSize);

	/**
	 * @param userId
	 * @return
	 */
	public User getUserById(String userId);

	/**
	 * @param user
	 */
	public void updateUser(User user);

	/**
	 * @param ids
	 */
	public void deleteUsers(String[] ids);

	/**
	 * @param users
	 */
	public void importUsers(List<User> users);
	
}
