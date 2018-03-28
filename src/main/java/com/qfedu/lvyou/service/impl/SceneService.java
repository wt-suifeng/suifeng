package com.qfedu.lvyou.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.qfedu.lvyou.dao.ISceneDao;
import com.qfedu.lvyou.model.Scene;
import com.qfedu.lvyou.service.ISceneService;

@Service
@Transactional
public class SceneService implements ISceneService {

	@Resource
	private ISceneDao sceneDao;
	
	@Override
	public List<Scene> getScenes() {
		return sceneDao.getScenes();
	}

	@Override
	public Scene getSceneById(String sceneId) {
		return sceneDao.getSceneById(sceneId);
	}
	
}
















