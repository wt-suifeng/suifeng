package com.qfedu.lvyou.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.qfedu.lvyou.dao.ISiteDao;
import com.qfedu.lvyou.model.Scene;
import com.qfedu.lvyou.model.Site;
import com.qfedu.lvyou.service.ISceneService;
import com.qfedu.lvyou.service.ISiteService;
@Service
@Transactional
public class SiteService implements ISiteService {
	
	@Resource
	private ISiteDao siteDao;
	
	@Resource
	private ISceneService sceneService;
	
	@Override
	public List<Site> getSites(HttpServletRequest request) {
		/*Map<String, Object> userData = request.getSession().getAttribute("userData");*/
		List<Scene> scenes = (List<Scene>) request.getSession().getAttribute("scenes");
		List<Site> sites = new ArrayList<Site>();
		for(Scene scene:scenes) {
			
		}
		return sites;
	}


}
