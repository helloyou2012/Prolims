package com.helloyou.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="tb_syslog")
public class Syslog extends Po {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3291754997041389987L;
	public static final String GREEN="一般";
	public static final String YELLOW="警戒";
	public static final String RED="高危";
	
	//操作的用户
	private Staff staff;
	//操作记录
	private String remark;
	private String level;
	
	@ManyToOne
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	

}
