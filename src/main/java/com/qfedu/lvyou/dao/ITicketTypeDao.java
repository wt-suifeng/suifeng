package com.qfedu.lvyou.dao;

import java.util.List;

import com.qfedu.lvyou.model.TicketType;

/**
 * 售票类型访问数据接口
 * @author Administrator
 *
 */
public interface ITicketTypeDao {

	/**
	 * 获取所有售票类型
	 * @return
	 */
	public abstract List<TicketType> getAllTicketType();

}
