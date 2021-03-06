package com.qfedu.lvyou.service;

import java.util.List;

import com.qfedu.lvyou.model.TicketType;

/**
 * 售票类型service业务逻辑处理
 * @author Administrator
 *
 */
public interface ITicketTypeService {

	/**
	 * 获取所有售票类型
	 * @return
	 */
	public abstract List<TicketType> getAllTicketType();

}
