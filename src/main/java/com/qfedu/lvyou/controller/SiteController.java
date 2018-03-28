package com.qfedu.lvyou.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qfedu.lvyou.model.Scene;
import com.qfedu.lvyou.model.Site;
import com.qfedu.lvyou.service.ISiteService;

@Controller
@RequestMapping("/ly/site")
public class SiteController {
	@Resource
	private ISiteService siteService;
	
	@RequestMapping("/list")
	public ModelAndView getList(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("site/list");
		List<Site> sites=siteService.getSites(request);
		mav.addObject("sites",sites);
		return mav;
	}
}
