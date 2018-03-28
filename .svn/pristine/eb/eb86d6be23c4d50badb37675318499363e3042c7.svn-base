package com.qfedu.lvyou.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="sys_menu")
public class Menu {

	@Id
	@Column(length=50)
	private String id;
	
	@Column(length = 20)
	private String name;
	
	@Column(length = 30)
	private String no;
	
	@Column(length=200)
	private String icon;
	
	@Column(length=200)
	private String url;
	
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Menu parent;

	@OneToMany(mappedBy="parent")
	private List<Menu> children;
	
	@ManyToMany(mappedBy="menus")
	private List<Role> roles;
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
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

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}
	
	/**
	 * @param menus
	 * @return
	 */
	public boolean isIn (List<Menu> menus) {
		for (Menu m : menus) {
			if (this.getId().equals(m.getId())) {
				return true;
			}
		}
		return false;
	}
}
