package com.helloyou.dao.impl;

import org.springframework.stereotype.Repository;

import com.helloyou.dao.SysSubDepartmentDao;
import com.helloyou.model.SysSubDepartment;

@Repository("SysSubDepartmentDao")
public class SysSubDepartmentDaoImpl extends DaoImpl<SysSubDepartment> implements SysSubDepartmentDao{

	@Override
	protected Class<SysSubDepartment> getType() {
		// TODO Auto-generated method stub
		return SysSubDepartment.class;
	}

}
