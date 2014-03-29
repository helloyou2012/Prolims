package com.helloyou.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="tb_staff")
public class Staff extends Po {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2136149172463315620L;
	
	//用户名
	private String username;
	//密码
	private String password;
	//邮箱
	private String email;
	//性别
	private String sex;
	//头像
	private String avatar;
	//所在部门
	private Department department;
	//身份等级
	private StaffLevel level;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@ManyToOne
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public void setDepartment(Long dept_id) {
		Department dept=new Department();
		dept.setId(dept_id);
		this.department = dept;
	}
	
	@ManyToOne
	public StaffLevel getLevel() {
		return level;
	}
	public void setLevel(StaffLevel level) {
		this.level = level;
	}
	public void setLevel(Long level_id) {
		StaffLevel l=new StaffLevel();
		l.setId(level_id);
		this.level = l;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
