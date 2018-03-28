package com.qfedu.lvyou.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ly_site")
public class Site {
	
	@Id
	@Column(length = 50)
	private String id;
	
	// 名称
	@Column(length = 50)
	private String name;
	
	// 位置信息
	@Column(length = 50)
	private String place;
	
	// 描述
	@Column(length = 200)
	private String description;
	
	// 图片
	@Column(length = 200)
	private String siteImage;
	
	// 是否开放
	@Column(length = 1)
	private String open;

	/**
	 * 
	 */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="scene_id")
	private Scene scene;
	
	@OneToMany(mappedBy="site", fetch=FetchType.LAZY)
	private List<Comment> comments;
	
	@OneToMany(mappedBy="site")
	private List<Advice> advices;
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Advice> getAdvices() {
		return advices;
	}

	public void setAdvices(List<Advice> advices) {
		this.advices = advices;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSiteImage() {
		return siteImage;
	}

	public void setSiteImage(String siteImage) {
		this.siteImage = siteImage;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}
}
