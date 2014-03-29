package com.helloyou.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="t_sys_main_department")
public class SysMainDepartment extends Po{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5616647321270924615L;
	private String name_zh;
	private String name_en;
	
	public String getName_zh() {
		return name_zh;
	}
	public void setName_zh(String name_zh) {
		this.name_zh = name_zh;
	}
	public String getName_en() {
		return name_en;
	}
	public void setName_en(String name_en) {
		this.name_en = name_en;
	}
	
	
}
