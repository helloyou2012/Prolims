package com.helloyou.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_sys_role_menu")
public class SysRoleMenu extends Po{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5165096236261143245L;
	
	private SysRole role;
	private SysSubMenu menu;
	
	@OneToOne
	public SysRole getRole() {
		return role;
	}
	public void setRole(SysRole role) {
		this.role = role;
	}
	@OneToOne
	public SysSubMenu getMenu() {
		return menu;
	}
	public void setMenu(SysSubMenu menu) {
		this.menu = menu;
	}
	
	
	
}
