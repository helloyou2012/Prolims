package com.helloyou.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_sys_user_info")
public class SysUserInfo extends Po{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7224253075110874791L;
	
	private String username;
	private String password;
	private String name;
	private String email;
	private String phone;
	private int age;
	private int sex;
	private Date birthday;
	private Boolean activaty;
	
	private SysSubDepartment department;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Boolean getActivaty() {
		return activaty;
	}
	public void setActivaty(Boolean activaty) {
		this.activaty = activaty;
	}
	@ManyToOne
	public SysSubDepartment getDepartment() {
		return department;
	}
	public void setDepartment(SysSubDepartment department) {
		this.department = department;
	}
	
}
