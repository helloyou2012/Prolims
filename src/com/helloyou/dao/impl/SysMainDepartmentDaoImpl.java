package com.helloyou.dao.impl;

import com.helloyou.model.SysMainDepartment;
import org.springframework.stereotype.Repository;

import com.helloyou.dao.SysMainDepartmentDao;


@Repository("SysMainDepartmentDao")
public class SysMainDepartmentDaoImpl extends DaoImpl<SysMainDepartment> implements SysMainDepartmentDao{

	@Override
	protected Class<SysMainDepartment> getType() {
		// TODO Auto-generated method stub
		return SysMainDepartment.class;
	}

}
