package com.helloyou.dao.impl;

import org.springframework.stereotype.Repository;

import com.helloyou.dao.SysUserInfoDao;
import com.helloyou.model.SysUserInfo;

@Repository("SysUserInfoDao")
public class SysUserInfoDaoImpl extends DaoImpl<SysUserInfo> implements SysUserInfoDao{

	@Override
	protected Class<SysUserInfo> getType() {
		// TODO Auto-generated method stub
		return SysUserInfo.class;
	}

}