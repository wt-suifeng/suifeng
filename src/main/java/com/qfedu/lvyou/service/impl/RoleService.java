package com.qfedu.lvyou.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.qfedu.lvyou.dao.IMenuDao;
import com.qfedu.lvyou.dao.IRoleDao;
import com.qfedu.lvyou.model.Menu;
import com.qfedu.lvyou.model.Role;
import com.qfedu.lvyou.service.IRoleService;

@Service
@Transactional
public class RoleService implements IRoleService {

	@Resource
	private IRoleDao roleDao;
	
	@Override
	public List<Role> getRoles() {
		return roleDao.getRoles();
	}

	@Override
	public Role getRoleById(String roleId) {
		return roleDao.getRoleById(roleId);
	}

	@Override
	public Map<String, Object> getRoleAndMenus(String roleId) {
		Map<String, Object> data = new HashMap<String, Object>();
		Role r = this.getRoleById(roleId);
		data.put("role", r);
		List<Menu> menus = new ArrayList<Menu>();
		menus.addAll(r.getMenus());
		data.put("relatedMenus", menus);
		return data;
	}

	@Resource
	private IMenuDao menuDao;
	
	@Override
	public void relateMenus(String roleId, String[] menus) {
		List<Menu> menuList = new ArrayList<Menu>();
		for (int i = 0; i < menus.length; i ++) {
			menuList.add(menuDao.getMenuById(menus[i]));
		}
		Role role = roleDao.getRoleById(roleId);
		role.setMenus(menuList);
		roleDao.updateRole(role);
	}
}
