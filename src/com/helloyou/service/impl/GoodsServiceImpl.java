package com.helloyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helloyou.dao.GoodsDao;
import com.helloyou.model.Goods;
import com.helloyou.service.GoodsService;
import com.helloyou.util.Paginator;


@Service("GoodsService")
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private GoodsDao goodsDao;
	
	@Override
	public void delete(Long id) {
		Goods g=new Goods();
		g.setId(id);
		goodsDao.delete(g);
	}

	@Override
	public Goods get(Long id) {
		return goodsDao.get(id);
	}

	@Override
	public Long create(Goods obj) {
		return goodsDao.create(obj);
	}

	@Override
	public void update(Goods obj) {
		goodsDao.update(obj);
	}

	@Override
	public void saveOrUpdate(Goods obj) {
		goodsDao.saveOrUpdate(obj);
	}

	@Override
	public List<Goods> getAll() {
		return goodsDao.getAll();
	}

	@Override
	public List<Goods> getAll(Paginator paginator) {
		return goodsDao.getAll(paginator);
	}

	@Override
	public List<Goods> getAll(Paginator paginator, int sort_col,
			String sort_dir, String search_text) {
		return goodsDao.getAll(paginator, sort_col, sort_dir, search_text);
	}

}
