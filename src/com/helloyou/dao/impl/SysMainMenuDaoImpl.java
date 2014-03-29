package com.helloyou.dao.impl;

import com.helloyou.model.SysMainMenu;
import org.springframework.stereotype.Repository;
import com.helloyou.dao.SysMainMenuDao;


@Repository("SysMainMenuDao")
public class SysMainMenuDaoImpl extends DaoImpl<SysMainMenu> implements SysMainMenuDao{

	@Override
	protected Class<SysMainMenu> getType() {
		// TODO Auto-generated method stub
		return SysMainMenu.class;
	}

}
