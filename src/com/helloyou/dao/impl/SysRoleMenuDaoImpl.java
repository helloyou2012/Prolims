package com.helloyou.dao.impl;

import org.springframework.stereotype.Repository;

import com.helloyou.dao.SysRoleMenuDao;
import com.helloyou.model.SysRoleMenu;

@Repository("SysRoleMenuDao")
public class SysRoleMenuDaoImpl extends DaoImpl<SysRoleMenu> implements SysRoleMenuDao{

	@Override
	protected Class<SysRoleMenu> getType() {
		// TODO Auto-generated method stub
		return SysRoleMenu.class;
	}

}
