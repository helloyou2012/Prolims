package com.helloyou.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="t_sys_main_menu")
public class SysMainMenu extends Po{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1860551997107939517L;
	
	private String name;
	private int list_order;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getList_order() {
		return list_order;
	}
	public void setList_order(int list_order) {
		this.list_order = list_order;
	}
	
	
}
