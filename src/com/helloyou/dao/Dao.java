package com.helloyou.dao;

import java.util.List;
import com.helloyou.util.Paginator;

public interface Dao<T> {

	Long create(T t);
	void update(T t);
	void saveOrUpdate(T t);
	void delete(T t);
	T get(Long id);
	List<T> getAll();
	List<T> getAll(String order);
	List<T> getAll(Paginator paginator);
	List<T> getAll(Paginator paginator,String sort_item, Boolean desc, String search_item,String search_text);

}
