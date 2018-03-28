package com.qfedu.lvyou.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.qfedu.lvyou.model.Site;

public interface ISiteService {

	List<Site> getSites(HttpServletRequest request);

}
