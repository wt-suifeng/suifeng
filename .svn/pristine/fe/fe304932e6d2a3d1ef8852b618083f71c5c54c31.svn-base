package com.qfedu.lvyou.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qfedu.lvyou.model.Employee;
import com.qfedu.lvyou.service.IEmployeeService;

@Controller
@RequestMapping("/ly/employee")
public class EmployeeController {

	@Resource
	private IEmployeeService employeeService;
	
	@RequestMapping("/list")
	public ModelAndView getList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("employee/list");
		List<Employee> employees = employeeService.getEmployees();
		mav.addObject("employees", employees);
		return mav;
	}
}
