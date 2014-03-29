package com.helloyou.dao.impl;

import org.springframework.stereotype.Repository;

import com.helloyou.dao.GoodsTypeDao;
import com.helloyou.model.GoodsType;


@Repository("GoodsTypeDao")
public class GoodsTypeDaoImpl extends DaoImpl<GoodsType> implements GoodsTypeDao{

	@Override
	protected Class<GoodsType> getType() {
		// TODO Auto-generated method stub
		return GoodsType.class;
	}

}
