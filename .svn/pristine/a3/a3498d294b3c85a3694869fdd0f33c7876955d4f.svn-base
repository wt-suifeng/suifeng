package com.qfedu.lvyou.test;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qfedu.lvyou.model.Guest;
import com.qfedu.lvyou.service.IGuestService;

@RunWith(SpringJUnit4ClassRunner.class) // 表示整合JUnit4进行测试
@ContextConfiguration(locations = { "classpath:applicationContext.xml" }) // 加载spring配置文件
public class TestGuestService {
	
	@Resource
	private IGuestService guestService;
	
	@Test
	@Transactional
	@Rollback(false)
	public void test01 () {
		Guest guest = new Guest();
		guest.setId("guest01");
		guest.setName("张三");
		guest.setMobile("18983345656");
		guestService.createGuest(guest);
		
		guest = new Guest();
		guest.setId("guest02");
		guest.setName("李四");
		guest.setMobile("17898755656");
		guestService.createGuest(guest);
		
		guest = new Guest();
		guest.setId("guest03");
		guest.setName("王五");
		guest.setMobile("15398753490");
		guestService.createGuest(guest);
	}
}
