package com.qfedu.lvyou.test;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qfedu.lvyou.dao.ISceneDao;
import com.qfedu.lvyou.model.Employee;
import com.qfedu.lvyou.model.Scene;
import com.qfedu.lvyou.service.IEmployeeService;

@RunWith(SpringJUnit4ClassRunner.class) // 表示整合JUnit4进行测试
@ContextConfiguration(locations = { "classpath:applicationContext.xml" }) // 加载spring配置文件
public class TestEmployeeService {

	@Resource
	private ISceneDao sceneDao;
	
	@Resource
	private IEmployeeService employeeService;
	
	@Test
	@Transactional
	@Rollback(false)
	public void test01() {
		Scene scene = sceneDao.getSceneById("sc1");
		Employee emp = new Employee();
		emp.setId("emp01");
		emp.setName("侯大");
		emp.setMobile("13209847564");
		emp.setScene(scene);
		employeeService.createEmployee(emp);
		
		emp = new Employee();
		emp.setId("emp02");
		emp.setName("侯二");
		emp.setMobile("13790037564");
		emp.setScene(scene);
		employeeService.createEmployee(emp);
	}
}
