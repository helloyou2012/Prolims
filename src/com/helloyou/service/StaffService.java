package com.helloyou.service;

import java.util.List;

import com.helloyou.model.Staff;
import com.helloyou.util.Paginator;

public interface StaffService {
	
	void delete(Long id);
	Staff get(Long id);
	Long create(Staff obj);
	void update(Staff obj);
	void saveOrUpdate(Staff obj);
	List<Staff> getAll();
	List<Staff> getAll(Paginator paginator);
	
	Staff findByNameAndPasswd(String name,String passwd);
	List<Staff> getAll(Paginator paginator,int sort_col, String sort_dir, String search_text);
	
}
