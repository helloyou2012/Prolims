package com.helloyou.dao;

import java.util.List;

import com.helloyou.model.Department;
import com.helloyou.util.Paginator;

public interface DepartmentDao extends Dao<Department>{
	List<Department> getAll(Paginator paginator,int sort_col, String sort_dir, String search_text);
}
