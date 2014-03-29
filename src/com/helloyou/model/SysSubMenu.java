package com.helloyou.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_sys_sub_menu")
public class SysSubMenu extends Po{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6385902135501452601L;
	
	private String name;
	private String url;
	private Boolean is_save;
	private Boolean is_view;
	private Boolean is_delete;
	private SysMainMenu main_menu;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Boolean getIs_save() {
		return is_save;
	}
	public void setIs_save(Boolean is_save) {
		this.is_save = is_save;
	}
	public Boolean getIs_view() {
		return is_view;
	}
	public void setIs_view(Boolean is_view) {
		this.is_view = is_view;
	}
	public Boolean getIs_delete() {
		return is_delete;
	}
	public void setIs_delete(Boolean is_delete) {
		this.is_delete = is_delete;
	}
	@ManyToOne
	public SysMainMenu getMain_menu() {
		return main_menu;
	}
	public void setMain_menu(SysMainMenu main_menu) {
		this.main_menu = main_menu;
	}
	
	
}
