package com.helloyou.dao.impl;

import org.springframework.stereotype.Repository;

import com.helloyou.dao.SysSubMenuDao;
import com.helloyou.model.SysSubMenu;

@Repository("SysSubMenuDao")
public class SysSubMenuDaoImpl extends DaoImpl<SysSubMenu> implements SysSubMenuDao{

	@Override
	protected Class<SysSubMenu> getType() {
		// TODO Auto-generated method stub
		return SysSubMenu.class;
	}

}
