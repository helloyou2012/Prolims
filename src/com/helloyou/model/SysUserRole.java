package com.helloyou.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_sys_user_role")
public class SysUserRole extends Po{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3312575783617768608L;
	
	private SysUserInfo user;
	private SysRole role;
	
	@OneToOne
	public SysUserInfo getUser() {
		return user;
	}
	public void setUser(SysUserInfo user) {
		this.user = user;
	}
	@OneToOne
	public SysRole getRole() {
		return role;
	}
	public void setRole(SysRole role) {
		this.role = role;
	}
	
	
}
