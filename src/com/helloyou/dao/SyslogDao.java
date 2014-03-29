package com.helloyou.dao;

import java.util.List;

import com.helloyou.model.Staff;
import com.helloyou.model.Syslog;
import com.helloyou.util.Paginator;

public interface SyslogDao extends Dao<Syslog>{
	List<Syslog> getAll(Paginator paginator, Staff staff);
	List<Syslog> getAll(Paginator paginator,int sort_col, String sort_dir, String search_text);
}
