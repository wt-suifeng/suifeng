package com.qfedu.lvyou.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.qfedu.lvyou.dao.ITicketRecordDao;
import com.qfedu.lvyou.model.TicketRecord;
import com.qfedu.lvyou.service.ITicketRecordService;
@Service
@Transactional
public class TicketRecordService implements ITicketRecordService {

	@Resource
	private ITicketRecordDao ticketRecordDao;
	@Override
	public List<TicketRecord> getList() {
		return ticketRecordDao.getAllTicketRecords();
	}

}
