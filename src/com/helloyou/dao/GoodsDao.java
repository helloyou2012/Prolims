package com.helloyou.dao;

import java.util.List;

import com.helloyou.model.Goods;
import com.helloyou.model.GoodsType;
import com.helloyou.model.Staff;
import com.helloyou.util.Paginator;

public interface GoodsDao extends Dao<Goods>{
	List<Goods> getAll(Paginator paginator,GoodsType type);
	List<Goods> getAll(Paginator paginator,int sort_col, String sort_dir, String search_text);
	List<Goods> getAll(Paginator paginator, GoodsType type, Staff staff);
	List<Goods> getAll(Paginator paginator, List<GoodsType> type);
}
