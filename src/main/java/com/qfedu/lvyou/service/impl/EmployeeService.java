package com.qfedu.lvyou.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qfedu.lvyou.dao.IEmployeeDao;
import com.qfedu.lvyou.dao.IUserDao;
import com.qfedu.lvyou.model.Employee;
import com.qfedu.lvyou.model.User;
import com.qfedu.lvyou.service.IEmployeeService;

@Service
@Transactional
public class EmployeeService implements IEmployeeService{

	@Resource
	private IEmployeeDao employeeDao;
	
	@Override
	public List<Employee> getEmployees() {
		return employeeDao.getEmployees();
	}

	@Resource
	private IUserDao userDao;
	
	@Override
	public void createEmployee(Employee emp) {
		// 根据手机号码查询用户
		User user = userDao.getUserByLoginName(emp.getMobile());
		// 如果查询不到，则创建用户
		if (user == null) {
			user = new User();
			user.setId(UUID.randomUUID().toString());
			user.setLoginName(emp.getMobile());
			userDao.createUser(user);
		}
		// 设置Employee和User的关联
		emp.setUser(user);
		// 入库
		employeeDao.createEmployee(emp);
	}
}
