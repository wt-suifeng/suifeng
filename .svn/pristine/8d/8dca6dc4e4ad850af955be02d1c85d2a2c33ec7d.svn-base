package com.qfedu.lvyou.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qfedu.lvyou.dao.IAdviceDao;
import com.qfedu.lvyou.model.Advice;

@Repository
public class AdviceDao implements IAdviceDao {

	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public List<Advice> getAdvices() {
		
		String hql = "from Advice a order by a.id";
		
		return sessionFactory.getCurrentSession().createQuery(hql, Advice.class).getResultList();
	}

}
