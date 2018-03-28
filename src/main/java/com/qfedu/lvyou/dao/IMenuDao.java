package com.qfedu.lvyou.dao;

import java.util.List;

import com.qfedu.lvyou.model.Menu;

public interface IMenuDao {
	
	/**
	 * 获取顶级菜单
	 * @return
	 */
	public List<Menu> getTopMenus ();
	
	/**
	 * 获取parentId下的子菜单
	 * @param parentId
	 * @return
	 */
	public List<Menu> getSubMenusByParent (String parentId);

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
	 * @param m
	 */
	public void deleteMenu(Menu m);
}
