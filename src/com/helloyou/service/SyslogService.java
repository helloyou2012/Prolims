package com.helloyou.service;

import java.util.List;

import com.helloyou.model.Staff;
import com.helloyou.model.Syslog;
import com.helloyou.util.Paginator;

public interface SyslogService {
	
	void delete(Long id);
	Syslog get(Long id);
	Long create(Syslog obj);
	Long create(String level, Staff staff, String remark);
	void update(Syslog obj);
	void saveOrUpdate(Syslog obj);
	List<Syslog> getAll();
	List<Syslog> getAll(Paginator paginator);
	List<Syslog> getAll(Paginator paginator,int sort_col, String sort_dir, String search_text);
}
