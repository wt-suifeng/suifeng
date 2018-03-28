package com.qfedu.lvyou.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qfedu.lvyou.dao.IGuestDao;
import com.qfedu.lvyou.model.Guest;
@Repository
public class GuestDao implements IGuestDao {
	
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List<Guest> getGuests() {
		// TODO Auto-generated method stub
		String hql = "from Guest g order by g.id";
		return sessionFactory.getCurrentSession().createQuery(hql, Guest.class).getResultList();
	}

	@Override
	public void createGuest(Guest guest) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().persist(guest);
	}

	@Override
	public void updateGuest(Guest guest) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().merge(guest);
	}

	@Override
	public void deleteGuest(Guest guest) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(guest);
	}

	@Override
	public Guest getGuestById(String guestId) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Guest.class, guestId);
	}

}
