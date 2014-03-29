package com.helloyou.service;

import java.util.List;

import com.helloyou.model.Department;
import com.helloyou.util.Paginator;

public interface DepartmentService {
	
	void delete(Long id);
	Department get(Long id);
	Long create(Department obj);
	void update(Department obj);
	void saveOrUpdate(Department obj);
	List<Department> getAll();
	List<Department> getAll(Paginator paginator);
	
	List<Department> getAll(Paginator paginator,int sort_col, String sort_dir, String search_text);

}
