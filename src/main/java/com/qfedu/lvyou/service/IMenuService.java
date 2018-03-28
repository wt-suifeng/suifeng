package com.qfedu.lvyou.service;

import java.util.List;
import java.util.Map;

import com.qfedu.lvyou.model.Menu;

public interface IMenuService {

	/**
	 * 通过当前顶级菜单ID和当前子菜单ID获取所有主页面需要的菜单数据
	 * @param currentTopId 当前顶级菜单ID
	 * @param currentSubId currentTopId下的当前子菜单ID
	 * @return
	 */
	public Map<String, Object> getMenuData (String currentTopId, String currentSubId, List<Menu> menus);

	public Map<String, Object> getMenuData (String currentTopId, String currentSubId, String roleId);

	
	/**
	 * @return
	 */
	public List<Menu> getAllMenus();

	/**
	 * @param menu
	 */
	public void createMenu(Menu menu);

	/**
	 * @param menuId
	 * @return
	 */
	public Menu getMenuById(String menuId);

	/**
	 * @param name
	 * @return
	 */
	public List<Menu> getMenusByName(String name);

	/**
	 * @param menu
	 */
	public void updateMenu(Menu menu);

	/**
	 * @param menuId
	 */
	public void deleteMenu(String menuId);
}
