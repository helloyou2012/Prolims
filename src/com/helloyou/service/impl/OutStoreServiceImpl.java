package com.helloyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helloyou.dao.OutStoreDao;
import com.helloyou.model.OutStore;
import com.helloyou.service.OutStoreService;
import com.helloyou.util.Paginator;


@Service("OutStoreService")
public class OutStoreServiceImpl implements OutStoreService{

	@Autowired
	private OutStoreDao outStoreDao;
	
	@Override
	public void delete(Long id) {
		OutStore g=new OutStore();
		g.setId(id);
		outStoreDao.delete(g);
	}

	@Override
	public OutStore get(Long id) {
		return outStoreDao.get(id);
	}

	@Override
	public Long create(OutStore obj) {
		return outStoreDao.create(obj);
	}

	@Override
	public void update(OutStore obj) {
		outStoreDao.update(obj);
	}

	@Override
	public void saveOrUpdate(OutStore obj) {
		outStoreDao.saveOrUpdate(obj);
	}

	@Override
	public List<OutStore> getAll() {
		return outStoreDao.getAll();
	}

	@Override
	public List<OutStore> getAll(Paginator paginator) {
		return outStoreDao.getAll(paginator);
	}

	@Override
	public List<OutStore> getAll(Paginator paginator, int sort_col,
			String sort_dir, String search_text) {
		return outStoreDao.getAll(paginator, sort_col, sort_dir, search_text);
	}

}
