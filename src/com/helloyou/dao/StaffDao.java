package com.helloyou.dao;

import java.util.List;

import com.helloyou.model.Staff;
import com.helloyou.util.Paginator;

public interface StaffDao extends Dao<Staff>{
	List<Staff> findByName(String name);
	Staff findByNameAndPasswd(String name,String passwd);
	List<Staff> getAll(Paginator paginator,int sort_col, String sort_dir, String search_text);
}
