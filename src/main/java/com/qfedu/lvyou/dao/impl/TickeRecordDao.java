package com.qfedu.lvyou.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qfedu.lvyou.dao.ITicketRecordDao;
import com.qfedu.lvyou.model.TicketRecord;
@Repository
public class TickeRecordDao implements ITicketRecordDao {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List<TicketRecord> getAllTicketRecords() {
		String hql = "from TicketRecord tr order by tr.id";
		List<TicketRecord> list = sessionFactory.getCurrentSession().createQuery(hql, TicketRecord.class)
		.getResultList();
		return list;
	}
	
}
