package com.helloyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helloyou.dao.StaffLevelDao;
import com.helloyou.model.StaffLevel;
import com.helloyou.service.StaffLevelService;

@Service("StaffLevelService")
public class StaffLevelServiceImpl implements StaffLevelService{
	
	@Autowired
	private StaffLevelDao staffLevelDao;

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		StaffLevel level=new StaffLevel();
		level.setId(id);
		staffLevelDao.delete(level);
	}

	@Override
	public StaffLevel get(Long id) {
		// TODO Auto-generated method stub
		return staffLevelDao.get(id);
	}

	@Override
	public Long create(StaffLevel obj) {
		// TODO Auto-generated method stub
		return staffLevelDao.create(obj);
	}

	@Override
	public void update(StaffLevel obj) {
		// TODO Auto-generated method stub
		staffLevelDao.update(obj);
	}

	@Override
	public void saveOrUpdate(StaffLevel obj) {
		// TODO Auto-generated method stub
		staffLevelDao.saveOrUpdate(obj);
	}

	@Override
	public List<StaffLevel> getAll() {
		// TODO Auto-generated method stub
		return staffLevelDao.getAll();
	}

}
