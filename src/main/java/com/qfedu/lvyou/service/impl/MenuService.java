package com.qfedu.lvyou.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.qfedu.lvyou.WoException;
import com.qfedu.lvyou.WoResultCode;
import com.qfedu.lvyou.dao.IMenuDao;
import com.qfedu.lvyou.dao.IRoleDao;
import com.qfedu.lvyou.model.Menu;
import com.qfedu.lvyou.model.Role;
import com.qfedu.lvyou.service.IMenuService;

@Service
@Transactional
public class MenuService implements IMenuService {

	@Resource // @Autowired
	private IMenuDao menuDao;

	private final static WoResultCode NO_TOP = new WoResultCode(1000, "没有顶级菜单！");

	private final static WoResultCode NO_MENU = new WoResultCode(1001, "ID为[%s]的菜单未找到！");

	private Menu getMenu(List<Menu> menus, String menuId) {
		for (Menu menu : menus) {
			if (menuId.equals(menu.getId())) {
				return menu;
			}
		}
		return null;
	}
	
	/**
	 * 从menus查找顶级菜单
	 * @param menus 角色权限的菜单
	 * @return
	 */
	private List<Menu> getTopMenus(List<Menu> menus){
		List<Menu> list = new ArrayList<>();
		for(Menu m:menus) {
			if(m.getParent()==null) {
				list.add(m);
			}
		}
		return list;
	}
	
	/**
	 * 从menus根据顶级菜单的Id查找子菜单
	 * @param parentId 顶级菜单Id
	 * @param menus 角色权限的菜单
	 * @return
	 */
	private List<Menu> getSubMenusByParent(String parentId,List<Menu> menus){
		List<Menu> list = new ArrayList<>();
		for(Menu m:menus) {
			if(m.getParent()!=null && m.getParent().getId().equals(parentId)) {
				list.add(m);
			}
		}
		return list;
	}

	@Resource
	private IRoleDao roleDao; 
	
	@Override
	public Map<String, Object> getMenuData(String currentTopId, String currentSubId, List<Menu> menus) {
		List<Menu> topMenus = this.getTopMenus(menus);
		if (topMenus.size() == 0) {
			throw new WoException(NO_TOP);
		}
		// 获取当前顶级菜单
		Menu currentTopMenu = null;
		// 获取currentTopMenu下面的所有子菜单
		List<Menu> subMenus = null;
		// 根据currentSubId和subMenus获取当前子菜单
		Menu currentSubMenu = null;
		// 当顶级菜单ID为空时
		if (StringUtils.isEmpty(currentTopId)) {
			// 当前顶级菜单为顶级菜单中的第一个
			currentTopMenu = topMenus.get(0);
			// 获取当前顶级菜单下所有子菜单
			subMenus = menuDao.getSubMenusByParent(currentTopMenu.getId());
			if (subMenus.size() > 0) {
				// 当前子菜单为子菜单列表中第一个
				currentSubMenu = subMenus.get(0);
			}
		} else {// 当顶级菜单ID不为空时
			// 通过currentTopId在topMenus中获取currentTopMenu
			currentTopMenu = this.getMenu(topMenus, currentTopId);
			if (currentTopMenu == null) {
				throw new WoException(NO_MENU, currentTopId);
			}
			// 通过currentTopMenu的id获取subMenus
			subMenus = this.getSubMenusByParent(currentTopMenu.getId(),menus);
			// 通过currentSubId从subMenus中获取currentSubMenu
			if (subMenus.size() > 0) {
				if (StringUtils.isEmpty(currentSubId)) {
					currentSubMenu = subMenus.get(0);
				} else {
					currentSubMenu = this.getMenu(subMenus, currentSubId);
				}
			}
		}
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("topMenus", topMenus);
		data.put("currentTopMenu", currentTopMenu);
		data.put("subMenus", subMenus);
		if (currentSubMenu != null) {
			data.put("currentSubMenu", currentSubMenu);
		}
		return data;
	}
	
	@Override
	public Map<String, Object> getMenuData(String currentTopId, String currentSubId, String roleId) {
		Role role = roleDao.getRoleById(roleId);
		if(role.isAdmin()) {
			return getMenuData(currentTopId, currentSubId);
		}
		return getMenuData(currentTopId, currentSubId, roleDao.getRoleById(roleId).getMenus());
	}


	private Map<String, Object> getMenuData(String currentTopId, String currentSubId) {
		return getMenuData(currentTopId, currentSubId, getAllMenus());
	}

	@Override
	public List<Menu> getAllMenus() {
		return menuDao.getAllMenus();
	}

	@Override
	public void createMenu(Menu menu) {
		menuDao.createMenu(menu);
	}

	@Override
	public Menu getMenuById(String menuId) {
		return menuDao.getMenuById(menuId);
	}

	@Override
	public List<Menu> getMenusByName(String name) {
		if (StringUtils.isEmpty(name)) {
			return this.getAllMenus();
		}
		return menuDao.getMenusByName(name);
	}

	@Override
	public void updateMenu(Menu menu) {
		if (menu.getParent() != null && "".equals(menu.getParent().getId())) {
			menu.setParent(null);
		}
		menuDao.updateMenu(menu);
	}

	private final static WoResultCode CHILD = new WoResultCode(1002, "该菜单下已经有子菜单，无法删除！");

	@Override
	public void deleteMenu(String menuId) {
		Menu m = menuDao.getMenuById(menuId);
		if (m.getChildren() != null && m.getChildren().size() > 0) {
			throw new WoException(CHILD);
		}
		menuDao.deleteMenu(m);
	}


}
