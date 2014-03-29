package com.helloyou.dao;

import java.util.List;

import com.helloyou.model.GoodsType;
import com.helloyou.model.OutStore;
import com.helloyou.util.Paginator;

public interface OutStoreDao extends Dao<OutStore>{
	List<OutStore> getAll(Paginator paginator,GoodsType type);
	List<OutStore> getAll(Paginator paginator,int sort_col, String sort_dir, String search_text);
}
