package com.qfedu.lvyou.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qfedu.lvyou.dao.ISiteDao;
import com.qfedu.lvyou.model.Site;

@Repository
public class SiteDao implements ISiteDao {

	@Resource
	private SessionFactory sessionFactory;
	
	public void createSite(Site site){
		sessionFactory.getCurrentSession().persist(site);
	}
	
	public Site getSiteById(String siteId){
		return sessionFactory.getCurrentSession().get(Site.class, siteId);
	}
	
	public void updateSite(Site site){
		sessionFactory.getCurrentSession().merge(site);
	}

	@Override
	public List<Site> getSites() {
		String hql="from Site s1";
		return sessionFactory.getCurrentSession().createQuery(hql,Site.class).getResultList();
	}

}
