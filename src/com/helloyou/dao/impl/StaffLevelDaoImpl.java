package com.helloyou.dao.impl;

import org.springframework.stereotype.Repository;

import com.helloyou.dao.StaffLevelDao;
import com.helloyou.model.StaffLevel;

@Repository("StaffLevelDao")
public class StaffLevelDaoImpl extends DaoImpl<StaffLevel> implements StaffLevelDao{

	@Override
	protected Class<StaffLevel> getType() {
		// TODO Auto-generated method stub
		return StaffLevel.class;
	}

}
