package com.qfedu.lvyou.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qfedu.lvyou.model.Employee;
import com.qfedu.lvyou.model.Role;
import com.qfedu.lvyou.model.Scene;
import com.qfedu.lvyou.service.ISceneService;

@Controller
@RequestMapping("/ly/scene")

public class SceneController {
	
	@Resource
	private ISceneService sceneService;
	
	@RequestMapping("/list")
	public ModelAndView getScenes(HttpServletRequest request) {
		Map<String, Object> userData = (Map<String, Object>) request.getSession().getAttribute("userData");
		List<Scene> scenes = new ArrayList<>();
		if(Role.EMPLOYEE.equals(userData.get("role"))) {
			Employee employee = (Employee) userData.get("employee");
			//Scene scene = sceneService.getSceneById((employee.getScene().getId()));
			scenes.add(employee.getScene());
		}else {
			scenes = sceneService.getScenes();
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("scene/list");
		mav.addObject("scenes", scenes);
		return mav;
	}
}

















