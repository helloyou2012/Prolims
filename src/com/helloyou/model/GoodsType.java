package com.helloyou.model;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="tb_goods_type")
public class GoodsType extends Po {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1206886266519550756L;
	
	private String name;
	private String remark="";
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
