package com.helloyou.model;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="tb_staff_level")
public class StaffLevel extends Po {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4312608168848093475L;
	
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
