package com.qfedu.lvyou.controller;

import java.util.List;

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
import com.qfedu.lvyou.service.IMenuService;

@Controller
@RequestMapping("/sys/menu")
public class MenuController {

	private final static Logger LOG = LogManager.getLogger(MenuController.class);
	
	@Resource
	private IMenuService menuService;

	@RequestMapping("/list")
	public ModelAndView getList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("menu/list");
		List<Menu> menus = menuService.getAllMenus();
		mav.addObject("menus", menus);
		return mav;
	}
	
	@RequestMapping("/search")
	public ModelAndView searchMenus (String name) {
		ModelAndView mav = new ModelAndView ();
		mav.setViewName("menu/search");
		List<Menu> menus = menuService.getMenusByName (name);
		mav.addObject("menus", menus);
		return mav;
	}

	@RequestMapping("/loadCreateForm")
	public String loadCreateForm() {
		return "menu/createForm";
	}
	
	@ResponseBody
	@RequestMapping("/create")
	public Object createTopMenu (Menu menu) {
		try {
			menuService.createMenu(menu);
			return WoResultCode.getSuccess();
		} catch (WoException e) {
			e.printStackTrace();
			System.out.println();
			return e.getCode();
		} catch (Exception e) {
			return WoResultCode.getUnknown().setMsg("创建顶级菜单失败！");
		}
	}
	
	@RequestMapping("/loadCreateChildForm")
	public ModelAndView loadChildForm (String parentId) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("menu/createChildForm");
		Menu m = menuService.getMenuById (parentId);
		mav.addObject("parentMenu", m);
		return mav;
	}
	
	@RequestMapping("/loadUpdateForm")
	public ModelAndView loadUpdateForm (String menuId) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("menu/updateForm");
		Menu m = menuService.getMenuById(menuId);
		mav.addObject("menu", m);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public Object updateMenu (Menu menu) {
		try {
			menuService.updateMenu(menu);
			return WoResultCode.getSuccess();
		} catch (WoException e) {
			LOG.error(e.getMessage(), e);
			return e.getCode();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return WoResultCode.getUnknown().setMsg("修改菜单信息失败！");
		}
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public Object deleteMenu (String menuId) {
		try {
			menuService.deleteMenu (menuId);
			return WoResultCode.getSuccess();
		} catch (WoException e) {
			LOG.error(e.getMessage(), e);
			return e.getCode();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return WoResultCode.getUnknown().setMsg("删除菜单失败！");
		}
	}
}
