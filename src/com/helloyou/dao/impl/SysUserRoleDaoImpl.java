package com.helloyou.dao.impl;

import org.springframework.stereotype.Repository;

import com.helloyou.dao.SysUserRoleDao;
import com.helloyou.model.SysUserRole;

@Repository("SysUserRoleDao")
public class SysUserRoleDaoImpl extends DaoImpl<SysUserRole> implements SysUserRoleDao{

	@Override
	protected Class<SysUserRole> getType() {
		// TODO Auto-generated method stub
		return SysUserRole.class;
	}

}
