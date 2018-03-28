package com.qfedu.lvyou.service;

import java.util.List;

import com.qfedu.lvyou.model.Scene;

public interface ISceneService {
	public List<Scene> getScenes();

	public Scene getSceneById(String sceneId); 
}	
