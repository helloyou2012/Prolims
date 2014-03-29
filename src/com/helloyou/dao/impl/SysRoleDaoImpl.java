package com.helloyou.dao.impl;

import com.helloyou.model.SysRole;
import org.springframework.stereotype.Repository;
import com.helloyou.dao.SysRoleDao;


@Repository("SysRoleDao")
public class SysRoleDaoImpl extends DaoImpl<SysRole> implements SysRoleDao{

	@Override
	protected Class<SysRole> getType() {
		// TODO Auto-generated method stub
		return SysRole.class;
	}

}
