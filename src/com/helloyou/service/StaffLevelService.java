package com.helloyou.service;

import java.util.List;

import com.helloyou.model.StaffLevel;

public interface StaffLevelService {
	void delete(Long id);
	StaffLevel get(Long id);
	Long create(StaffLevel obj);
	void update(StaffLevel obj);
	void saveOrUpdate(StaffLevel obj);
	List<StaffLevel> getAll();
}
