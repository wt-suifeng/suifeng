package com.qfedu.lvyou.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qfedu.lvyou.WoException;
import com.qfedu.lvyou.WoResultCode;
import com.qfedu.lvyou.model.Menu;
import com.qfedu.lvyou.model.Role;
import com.qfedu.lvyou.service.IMenuService;
import com.qfedu.lvyou.service.IRoleService;

@Controller
@RequestMapping ("/sys/role")
public class RoleController {

	@Resource
	private IRoleService roleService;
	
	@Resource
	private IMenuService menuService;
	
	@RequestMapping("/list")
	public ModelAndView getList () {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("role/list");
		List<Role> roles = roleService.getRoles ();
		mav.addObject("roles", roles);
		return mav;
	}
	
	@RequestMapping("/loadRelatedMenuList")
	public ModelAndView loadRelatedMenuList(String roleId) {
		ModelAndView mav = new ModelAndView();
		// 设置视图名称，解析为jsp路径
		mav.setViewName("role/relatedMenuList");
		// 获取角色及关联菜单数据map对象
		Map<String, Object> roleAndMenus = roleService.getRoleAndMenus(roleId);
		// 获取所有菜单数据
		List<Menu> menus = menuService.getAllMenus();
		// 设置共享域对象
		mav.addAllObjects(roleAndMenus);
		mav.addObject("menus", menus);
		return mav;
	}
	
	private final static Logger LOG = LogManager.getLogger(RoleController.class);
	
	@ResponseBody
	@RequestMapping("/relateMenus")
	public Object relateMenus (String roleId, String menuIds) {
		try {
			String [] menus = menuIds.split(",");
			roleService.relateMenus(roleId, menus);
			return WoResultCode.getSuccess();
		} catch (WoException e) {
			LOG.error(e.getMessage(), e);
			return e.getCode();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return WoResultCode.getUnknown().setMsg("关联菜单失败！");
		}
	}
}
