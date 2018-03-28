package com.qfedu.lvyou.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.qfedu.lvyou.dao.IGuestDao;
import com.qfedu.lvyou.dao.IUserDao;
import com.qfedu.lvyou.model.Guest;
import com.qfedu.lvyou.model.User;
import com.qfedu.lvyou.service.IGuestService;
@Service
@Transactional
public class GuestService implements IGuestService {
	
	@Resource
	private IGuestDao guestDao;

	@Override
	public List<Guest> getGuests() {
		return guestDao.getGuests();
	}
	
	@Resource
	private IUserDao userDao;

	@Override
	public void createGuest(Guest guest) {
		User u = userDao.getUserByLoginName(guest.getMobile());
		if(u==null) {
			u = new User();
			u.setId(UUID.randomUUID().toString());
			u.setLoginName(guest.getMobile());
			userDao.createUser(u);
		}
		guest.setUser(u);
		guestDao.createGuest(guest);
	}
	
	
}
