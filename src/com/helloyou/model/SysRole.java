package com.helloyou.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="t_sys_role")
public class SysRole extends Po{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8120295732028080910L;
	private String name;
	private String detail;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}
