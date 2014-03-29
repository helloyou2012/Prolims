package com.helloyou.service;

import java.util.List;

import com.helloyou.model.GoodsType;
import com.helloyou.util.Paginator;

public interface GoodsTypeService {
	
	void delete(Long id);
	GoodsType get(Long id);
	Long create(GoodsType obj);
	void update(GoodsType obj);
	void saveOrUpdate(GoodsType obj);
	List<GoodsType> getAll();
	List<GoodsType> getAll(Paginator paginator);
	
}
