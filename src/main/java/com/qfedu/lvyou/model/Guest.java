package com.qfedu.lvyou.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "ly_guest")
public class Guest {

	@Id
	@Column(length = 50)
	private String id;
	
	@Column(length = 20)
	private String name;
	
	/**
	 * 性别：1-男；2-女
	 */
	@Column(length = 2)
	private String sex;
	
	/**
	 * 手机号同时也是登录名
	 */
	@Column(length = 50, unique = true)
	private String mobile;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso=ISO.DATE)
	private Date birthday;
	
	@Column (length = 50)
	private String idCard;

	@OneToMany(mappedBy="guest")
	private List<Comment> comments;

	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy="guest")
	private List<Advice> advices;
	
	@OneToMany(mappedBy = "guest")
	private List<TicketRecord> ticketReords;


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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

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

	public List<TicketRecord> getTicketReords() {
		return ticketReords;
	}

	public void setTicketReords(List<TicketRecord> ticketReords) {
		this.ticketReords = ticketReords;
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
}
