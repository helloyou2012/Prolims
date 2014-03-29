package com.helloyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helloyou.dao.StaffDao;
import com.helloyou.model.Staff;
import com.helloyou.service.StaffService;
import com.helloyou.util.Paginator;


@Service("StaffService")
public class StaffServiceImpl implements StaffService{

	@Autowired
	private StaffDao staffDao;
	
	@Override
	public void delete(Long id) {
		Staff g=new Staff();
		g.setId(id);
		staffDao.delete(g);
	}

	@Override
	public Staff get(Long id) {
		return staffDao.get(id);
	}

	@Override
	public Long create(Staff obj) {
		return staffDao.create(obj);
	}

	@Override
	public void update(Staff obj) {
		staffDao.update(obj);
	}

	@Override
	public void saveOrUpdate(Staff obj) {
		staffDao.saveOrUpdate(obj);
	}

	@Override
	public List<Staff> getAll() {
		return staffDao.getAll();
	}

	@Override
	public List<Staff> getAll(Paginator paginator) {
		return staffDao.getAll(paginator);
	}

	@Override
	public Staff findByNameAndPasswd(String name, String passwd) {
		// TODO Auto-generated method stub
		return staffDao.findByNameAndPasswd(name, passwd);
	}

	@Override
	public List<Staff> getAll(Paginator paginator, int sort_col,
			String sort_dir, String search_text) {
		return staffDao.getAll(paginator, sort_col, sort_dir, search_text);
	}

}
