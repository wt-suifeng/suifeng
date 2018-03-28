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

import com.qfedu.lvyou.model.Scene;
import com.qfedu.lvyou.service.ISceneService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class TestSceneService {
	
	private final static Logger LOG = LogManager.getLogger(TestSceneService.class);
	
	@Resource
	private ISceneService sceneService;
	
	@Test
	@Transactional
	@Rollback(true)
	public void test01() {
		Scene scene = sceneService.getSceneById("sc-jpa-1");
		System.out.println("System.out.println   :"+scene.getName());
		LOG.info("LOG.info   :"+scene.getName());
	}

}
