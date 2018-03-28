package com.qfedu.lvyou.service;

import java.util.List;
import java.util.Map;

import com.qfedu.lvyou.model.Role;

public interface IRoleService {

	/**
	 * @return
	 */
	List<Role> getRoles();

	/**
	 * @param roleId
	 * @return
	 */
	Role getRoleById(String roleId);
	
	Map<String, Object> getRoleAndMenus (String roleId);

	/**
	 * @param roleId
	 * @param menus
	 */
	void relateMenus(String roleId, String[] menus);
}
