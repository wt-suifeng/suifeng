package com.qfedu.lvyou.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ly_scene")
public class Scene {
	// id
	@Id
	@Column(length = 50)
	private String id;
	
	// 名称
	@Column(length = 20)
	private String name;
	
	// 紧急联系电话
	@Column(length = 20)
	private String telephone;
	
	// 位置信息
	@Column(length = 50)
	private String address;
	
	// 描述
	@Column(length = 50)
	private String description;

	// 图片
	@Column(length = 50)
	private String img;
	
	// 是否对外开放 1-开放,2-不开放
	@Column(length = 2)
	private String open;

	@OneToMany(mappedBy="scene")
	private List<Employee> employees;

	/**
	 * 
	 */
	@OneToMany(mappedBy="scene")
	private List<Site> sites;
	
	@OneToMany(mappedBy="scene")
	private List<TicketType> TicketTypes;

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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Site> getSites() {
		return sites;
	}

	public void setSites(List<Site> sites) {
		this.sites = sites;
	}

	public List<TicketType> getTicketTypes() {
		return TicketTypes;
	}

	public void setTicketTypes(List<TicketType> ticketTypes) {
		TicketTypes = ticketTypes;
	}
}
