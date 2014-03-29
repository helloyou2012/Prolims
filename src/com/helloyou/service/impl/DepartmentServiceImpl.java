package com.helloyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helloyou.dao.DepartmentDao;
import com.helloyou.model.Department;
import com.helloyou.service.DepartmentService;
import com.helloyou.util.Paginator;


@Service("DepartmentService")
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentDao departmentDao;
	
	@Override
	public void delete(Long id) {
		Department department=new Department();
		department.setId(id);
		departmentDao.delete(department);
	}

	@Override
	public Department get(Long id) {
		return departmentDao.get(id);
	}

	@Override
	public Long create(Department obj) {
		return departmentDao.create(obj);
	}

	@Override
	public void update(Department obj) {
		departmentDao.update(obj);
	}

	@Override
	public void saveOrUpdate(Department obj) {
		departmentDao.saveOrUpdate(obj);
	}

	@Override
	public List<Department> getAll() {
		return departmentDao.getAll();
	}

	@Override
	public List<Department> getAll(Paginator paginator) {
		return departmentDao.getAll(paginator);
	}

	@Override
	public List<Department> getAll(Paginator paginator, int sort_col,
			String sort_dir, String search_text) {
		return departmentDao.getAll(paginator, sort_col, sort_dir, search_text);
	}

}
