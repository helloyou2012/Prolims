package com.helloyou.model;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="tb_department")
public class Department extends Po {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7648686781739469663L;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
