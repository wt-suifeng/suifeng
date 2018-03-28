package com.qfedu.lvyou.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qfedu.lvyou.dao.ITicketTypeDao;
import com.qfedu.lvyou.model.TicketType;



@Repository
public class TicketTypeDao implements ITicketTypeDao {

	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public List<TicketType> getAllTicketType() {
		String hql = "from TicketType t order by t.id";
		return sessionFactory.getCurrentSession().createQuery(hql,TicketType.class).getResultList();
	}

}
