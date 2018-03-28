package com.qfedu.lvyou.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qfedu.lvyou.model.TicketRecord;
import com.qfedu.lvyou.service.ITicketRecordService;

@Controller
@RequestMapping("/ly/ticketRecord")
public class TicketRecordController {
	@Resource
	private ITicketRecordService ticketRecordService;
	@RequestMapping("/list")
	public ModelAndView getList() {
		ModelAndView mav = new ModelAndView();
		List<TicketRecord> ticketRecords = ticketRecordService.getList();
		mav.setViewName("ticketRecord/list");
		mav.addObject("ticketRecords",ticketRecords);
		return mav;
	}
}
