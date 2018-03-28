package com.qfedu.lvyou.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qfedu.lvyou.dao.IMenuDao;
import com.qfedu.lvyou.dao.IRoleDao;
import com.qfedu.lvyou.model.Menu;
import com.qfedu.lvyou.model.Role;

@RunWith(SpringJUnit4ClassRunner.class) // 表示整合JUnit4进行测试
@ContextConfiguration(locations = { "classpath:applicationContext.xml" }) // 加载spring配置文件
public class TestRoleDao {
	
	private final static Logger LOG = LogManager.getLogger(TestRoleDao.class);
	
	@Resource
	private IRoleDao roleDao;
	
	@Resource
	private IMenuDao menuDao;
	
	@Test
	@Transactional
	@Rollback(false)
	public void test01 () {
		// 构造菜单列表
		Menu m = menuDao.getMenuById("1");
		List<Menu> list = new ArrayList<Menu>();
		list.add(m);
		// 构造角色
		Role role = new Role ();
		role.setId("role1");
		role.setName("测试角色");
		// 设置关系数据
		role.setMenus(list);
		// 入库
		roleDao.createRole(role);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void test02 () {
		Role role = roleDao.getRoleById("role1");
		// role.setName("测试角色3");
		// roleDao.updateRole(role);
		LOG.info("role:" + role.getName());
		// lazy
		for (Menu m : role.getMenus()) {
			LOG.info("menu:" + m.getName());
		}
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void test03 () {
		Role role = roleDao.getRoleById("role1");
		role.setName("测试角色5");
		roleDao.updateRole(role);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void test04 () {
		// 构造角色
		Role role = new Role ();
		role.setId("role2");
		role.setName("测试2");
		// 设置关系数据
		List<Role> roles = new ArrayList<Role>();
		roles.add(role);
		roleDao.createRole(role);
		// 构造菜单列表
		Menu m = menuDao.getMenuById("1");
		m.setRoles(roles);
		// 入库
		menuDao.updateMenu (m);
	}
}
