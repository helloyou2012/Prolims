package com.helloyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helloyou.dao.GoodsTypeDao;
import com.helloyou.model.GoodsType;
import com.helloyou.service.GoodsTypeService;
import com.helloyou.util.Paginator;


@Service("GoodsTypeService")
public class GoodsTypeServiceImpl implements GoodsTypeService{

	@Autowired
	private GoodsTypeDao goodsTypeDao;
	
	@Override
	public void delete(Long id) {
		GoodsType g=new GoodsType();
		g.setId(id);
		goodsTypeDao.delete(g);
	}

	@Override
	public GoodsType get(Long id) {
		return goodsTypeDao.get(id);
	}

	@Override
	public Long create(GoodsType obj) {
		return goodsTypeDao.create(obj);
	}

	@Override
	public void update(GoodsType obj) {
		goodsTypeDao.update(obj);
	}

	@Override
	public void saveOrUpdate(GoodsType obj) {
		goodsTypeDao.saveOrUpdate(obj);
	}

	@Override
	public List<GoodsType> getAll() {
		return goodsTypeDao.getAll();
	}

	@Override
	public List<GoodsType> getAll(Paginator paginator) {
		return goodsTypeDao.getAll(paginator);
	}

}
