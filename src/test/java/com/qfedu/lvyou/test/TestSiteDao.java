package com.qfedu.lvyou.test;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qfedu.lvyou.dao.ISceneDao;
import com.qfedu.lvyou.dao.ISiteDao;
import com.qfedu.lvyou.model.Scene;
import com.qfedu.lvyou.model.Site;

@RunWith(SpringJUnit4ClassRunner.class) // 表示整合JUnit4进行测试
@ContextConfiguration(locations = { "classpath:applicationContext.xml" }) // 加载spring配置文件
public class TestSiteDao {
	
	@Resource
	private ISceneDao sceneDao;
	
	@Resource
	private ISiteDao siteDao;
	
	@Test
	@Transactional
	@Rollback(false)
	public void test01() {
		Scene sc = new Scene ();
		sc.setId("sc1");
		sc.setName("峨眉山");
		sceneDao.createScene(sc);
		Site site = new Site();
		site.setId("site1");
		site.setName("长寿寺");
		site.setScene(sc);
		siteDao.createSite(site);
	}
	
	private final static Logger LOG = LogManager.getLogger(TestSiteDao.class);
	
	@Test
	@Transactional
	@Rollback(false)
	public void test02() {
		LOG.info("start...");
		Site site = siteDao.getSiteById("site1");
		LOG.info("site:" + site.getName());
	}

}
