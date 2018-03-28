package com.qfedu.lvyou.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ly_employee")
public class Employee {
	
	/**
	 * ID
	 */
	@Id
	@Column(length=50)
	private String id;
	
	/**
	 * 员工姓名
	 */
	@Column(length=20)
	private String name;
	
	/**
	 * 性别
	 */
	@Column(length=2)
	private String sex;

	/**
	 * 工号
	 */
	@Column(length=50)
	private String no;
	
	/**
	 * 头像
	 */
	@Column(length=200)
	private String headImage;
	
	/**
	 * 电话
	 */
	@Column(length=50)
	private String mobile;
	
	/**
	 * 出生日期
	 */
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;

	/**
	 * 身份证
	 */
	@Column(length=50)
	private String idCard;
	
	/**职务
	 * 1：主管  2：副主管
	 * 3：普通员工 4：售票员
	 */
	@Column(length=2)
	private String position;

	@OneToMany(mappedBy="employee")
	private List<TicketRecord> ticketRecords;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="scene_id")
	private Scene scene;

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

	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public List<TicketRecord> getTicketRecords() {
		return ticketRecords;
	}

	public void setTicketRecords(List<TicketRecord> ticketRecords) {
		this.ticketRecords = ticketRecords;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
}