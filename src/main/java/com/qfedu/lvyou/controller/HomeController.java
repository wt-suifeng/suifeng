package com.qfedu.lvyou.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qfedu.lvyou.WoException;
import com.qfedu.lvyou.service.IAuthenticationService;
import com.qfedu.lvyou.service.IMenuService;

@Controller
@RequestMapping("/")
public class HomeController {

	private final static String VIEW_LOGIN = "login";
	private final static String VIEW_MAIN = "main";
	
	// /index
	@RequestMapping("/index")
	public ModelAndView goHome(String currentTopId, String currentSubId, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView ();
		Map<String, Object> userData =  (Map<String, Object>) request.getSession().getAttribute("userData");
		if (userData == null) {
			mav.setViewName(VIEW_LOGIN);
			return mav;
		}
		mav.setViewName(VIEW_MAIN);
		Map<String, Object> menuData = menuService.getMenuData(currentTopId, currentSubId, userData.get("role").toString());
		mav.addAllObjects(menuData);
		return mav;
	}
	
	@Resource
	private IAuthenticationService authenticationService;

	@Resource
	private IMenuService menuService;
	
	// /index
	@RequestMapping("/authenticate")
	public ModelAndView authenticate (String user, String password, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		try {
			// 验证用户名和密码，并返回用户对象
			Map<String,Object> userData = authenticationService.authenticate(user, password);
			// 将用户设置到session中
			request.getSession().setAttribute("userData", userData);
			// 构造ModelAndView，设置视图名字
			mav.setViewName(VIEW_MAIN);
			// 获取菜单数据，并设置到ModelAndView中
			Map<String, Object> menuData = menuService.getMenuData(null, null, userData.get("role").toString());
			mav.addAllObjects(menuData);
			return mav;
		} catch (WoException e) {
			e.printStackTrace();
			// 构造ModelAndView，设置异常消息
			mav.addObject("error", e.getMessage());
			// 设置视图名称
			// 在springmvc-servlet.xml中配置的视图解析器中，定义了前缀和后缀，与下面的视图名称一起组成jsp的地址全路径
			mav.setViewName(VIEW_LOGIN);
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("error", "登录失败！");
			// 在springmvc-servlet.xml中配置的视图解析器中，定义了前缀和后缀，与下面的视图名称一起组成jsp的地址全路径
			mav.setViewName(VIEW_LOGIN);
			return mav;
		}
	}

}
