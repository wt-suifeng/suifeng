package com.qfedu.lvyou.test;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qfedu.lvyou.dao.IMenuDao;
import com.qfedu.lvyou.dao.IUserDao;
import com.qfedu.lvyou.model.Menu;
import com.qfedu.lvyou.model.User;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class) // 表示整合JUnit4进行测试
@ContextConfiguration(locations = { "classpath:applicationContext.xml" }) // 加载spring配置文件
public class TestMenuDao {

	@Resource
	private IMenuDao menuDao;

	@Resource
	private IUserDao userDao;
	
	@Test
	@Transactional
	@Rollback(value = true)
	public void test01() {
		// 获取所有顶级菜单列表，并打印所有菜单的名称
		List<Menu> topMenus = menuDao.getTopMenus();
		for (Menu menu : topMenus) {
			System.out.println(menu.getName());
		}
		// 获取ID为1的子菜单的列表，并打印所有菜单名称
		List<Menu> subMenus = menuDao.getSubMenusByParent("1");
		for (Menu menu1 : subMenus) {
			System.out.println(menu1.getName());
		}
	}
	
	@Test
	@Transactional
	@Rollback(value = true)
	public void test02() {
		User u = userDao.getUserByLoginName("admin");
		Assert.assertEquals("1", u.getId());
	}
}
