package com.qfedu.lvyou.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sys_role")
public class Role {

	@Id
	@Column(length = 50)
	private String id;

	@Column(length = 20)
	private String name;

	@Column(length = 100)
	private String description;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "sys_role_menu", 
		joinColumns = { @JoinColumn(name = "role_id") }, 
		inverseJoinColumns = {@JoinColumn(name = "menu_id") })
	private List<Menu> menus;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	
	public final static String ADMIN = "admin";
	public final static String EMPLOYEE = "employee";
	public final static String GUEST = "guest";
	
	public Boolean isAdmin() {
		return "admin".equals(this.id);
	}
}
