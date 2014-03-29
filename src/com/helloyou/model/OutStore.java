package com.helloyou.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="tb_out_store")
public class OutStore extends Po {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3549888491510200915L;
	
	//出库物品
	private Goods goods;
	//办理人员
	private Staff staff;
	//数量
	private int number;
	//提货人
	private String pick_name;
	//提货人联系电话
	private String pick_phone;
	
	@ManyToOne
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	@ManyToOne
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPick_name() {
		return pick_name;
	}
	public void setPick_name(String pick_name) {
		this.pick_name = pick_name;
	}
	public String getPick_phone() {
		return pick_phone;
	}
	public void setPick_phone(String pick_phone) {
		this.pick_phone = pick_phone;
	}
	
	

}
