package com.helloyou.service;

import java.util.List;

import com.helloyou.model.OutStore;
import com.helloyou.util.Paginator;

public interface OutStoreService {
	
	void delete(Long id);
	OutStore get(Long id);
	Long create(OutStore obj);
	void update(OutStore obj);
	void saveOrUpdate(OutStore obj);
	List<OutStore> getAll();
	List<OutStore> getAll(Paginator paginator);
	List<OutStore> getAll(Paginator paginator,int sort_col, String sort_dir, String search_text);
}
