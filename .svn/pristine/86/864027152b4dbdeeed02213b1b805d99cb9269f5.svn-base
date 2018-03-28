package com.qfedu.lvyou.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.qfedu.lvyou.dao.IAdviceDao;
import com.qfedu.lvyou.model.Advice;
import com.qfedu.lvyou.service.IAdviceService;
@Service
@Transactional
public class AdviceService implements IAdviceService {

	
	@Resource
	private IAdviceDao adviceDao;
	@Override
	public List<Advice> getAdvices() {
		
		return adviceDao.getAdvices();
	}
	
}
