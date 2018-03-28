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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class TestGuestDao {
	
	@Resource
	private IGuestService guestService;
	
	@Test
	@Transactional
	@Rollback(false)
	public void test01() {
		Guest guest = new Guest();
		guest.setId("guest01");
		guest.setName("张三");
		guest.setMobile("12345678901");
		guestService.createGuest(guest);
		
		guest = new Guest();
		guest.setId("guest02");
		guest.setName("李四");
		guest.setMobile("12345678902");
		guestService.createGuest(guest);
		
		guest  = new Guest();
		guest.setId("guest03");
		guest.setName("王五");
		guest.setMobile("12345678903");
		guestService.createGuest(guest);
	}
}
