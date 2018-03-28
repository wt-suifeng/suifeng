package com.qfedu.lvyou.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qfedu.lvyou.dao.ISceneDao;
import com.qfedu.lvyou.model.Scene;
@Repository
public class SceneDao implements ISceneDao {

	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public void createScene(Scene scene) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().persist(scene);
	}

	@Override
	public Scene getSceneById(String sceneId) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Scene.class, sceneId);
	}

	@Override
	public void updateScene(Scene scene) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().merge(scene);
	}

	@Override
	public List<Scene> getScenes() {
		String hql ="from Scene s";
		return sessionFactory.getCurrentSession().createQuery(hql, Scene.class)
				.getResultList();
	}
}
