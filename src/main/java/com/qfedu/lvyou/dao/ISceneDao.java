package com.qfedu.lvyou.dao;

import java.util.List;

import com.qfedu.lvyou.model.Scene;

public interface ISceneDao {

	public void createScene(Scene scene);
	public Scene getSceneById(String sceneId);
	public void updateScene(Scene scene);
	public List<Scene> getScenes();
}
