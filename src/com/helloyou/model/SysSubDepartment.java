package com.helloyou.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_sys_sub_department")
public class SysSubDepartment extends Po{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5063655243048269791L;
	private String name_zh;
	private String name_en;
	private String phone;
	private int list_order;
	private SysMainDepartment main_department;
	
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getList_order() {
		return list_order;
	}
	public void setList_order(int list_order) {
		this.list_order = list_order;
	}
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
	@ManyToOne
	public SysMainDepartment getMain_department() {
		return main_department;
	}
	public void setMain_department(SysMainDepartment main_department) {
		this.main_department = main_department;
	}
	
	
}
