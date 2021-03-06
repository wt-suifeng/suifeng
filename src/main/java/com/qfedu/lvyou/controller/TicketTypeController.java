package com.qfedu.lvyou.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qfedu.lvyou.model.TicketType;
import com.qfedu.lvyou.service.ITicketTypeService;

/**
 * 售票类型的Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/ly/tickettype")
public class TicketTypeController {

	@Resource
	private ITicketTypeService ticketTypeService;
	
	@RequestMapping("/list")
	public ModelAndView getList() {
		ModelAndView mav = new ModelAndView();
		List<TicketType> ticketTypes = ticketTypeService.getAllTicketType();
		mav.setViewName("tickettype/list");
		mav.addObject("ticketTypes", ticketTypes);
		return mav;
	}
}
