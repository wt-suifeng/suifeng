package com.qfedu.lvyou.dao;

import java.util.List;

import com.qfedu.lvyou.model.User;

public interface IUserDao {
	
	/**
	 * @param user
	 * @param password
	 */
	public void authenticate (String user, String password);

	/**
	 * 通过登录名获取用户
	 * @param user
	 * @return
	 */
	public User getUserByLoginName(String user);

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
	public List<User> getUsersByLoginName(String loginName, Long woPageStart, Long woPageSize);

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
	 * @param id
	 */
	public void deleteUserById(String id);

	/**
	 * @param loginName
	 * @return
	 */
	public Long getUsersTotalByLoginName(String loginName);
	
}
