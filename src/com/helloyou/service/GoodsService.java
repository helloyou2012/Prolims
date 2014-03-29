package com.helloyou.service;

import java.util.List;

import com.helloyou.model.Goods;
import com.helloyou.util.Paginator;

public interface GoodsService {
	
	void delete(Long id);
	Goods get(Long id);
	Long create(Goods obj);
	void update(Goods obj);
	void saveOrUpdate(Goods obj);
	List<Goods> getAll();
	List<Goods> getAll(Paginator paginator);
	List<Goods> getAll(Paginator paginator,int sort_col, String sort_dir, String search_text);
	
}
