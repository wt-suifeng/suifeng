package com.qfedu.lvyou.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qfedu.lvyou.model.Advice;
import com.qfedu.lvyou.service.IAdviceService;

@Controller
@RequestMapping ("/ly/advice")
public class AdviceController {

	@Resource
	private IAdviceService adviceService;
	
	
	@RequestMapping("/list")
	public ModelAndView getList () {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("advice/list");
		List<Advice> advices = adviceService.getAdvices ();
		mav.addObject("advices", advices);
		return mav;
	}
	
}
