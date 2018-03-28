package com.qfedu.lvyou.service.impl;

import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.qfedu.lvyou.dao.ITicketTypeDao;
import com.qfedu.lvyou.model.TicketType;
import com.qfedu.lvyou.service.ITicketTypeService;

@Service
@Transactional
public class TicketTypeService implements ITicketTypeService {

	@Resource
	private ITicketTypeDao ticketTypeDao;
	
	@Override
	public List<TicketType> getAllTicketType() {
		return ticketTypeDao.getAllTicketType();
	}

}
