package com.helloyou.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="tb_goods")
public class Goods extends Po {

	/**
	 * 
	 */
	private static final long serialVersionUID = 233604252411164704L;
	
	private String name;
	private GoodsType type;
	private int number;
	private String unit;
	private String remark="";
	private String area;
	private String cupboard;
	private Staff staff;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ManyToOne
	public GoodsType getType() {
		return type;
	}
	public void setType(GoodsType type) {
		this.type = type;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCupboard() {
		return cupboard;
	}
	public void setCupboard(String cupboard) {
		this.cupboard = cupboard;
	}
	@ManyToOne
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}

}
