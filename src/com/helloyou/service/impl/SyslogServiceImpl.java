package com.helloyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helloyou.dao.SyslogDao;
import com.helloyou.model.Staff;
import com.helloyou.model.Syslog;
import com.helloyou.service.SyslogService;
import com.helloyou.util.Paginator;

@Service("SyslogService")
public class SyslogServiceImpl implements SyslogService{

	@Autowired
	private SyslogDao syslogDao;
	
	@Override
	public void delete(Long id) {
		Syslog g=new Syslog();
		g.setId(id);
		syslogDao.delete(g);
	}

	@Override
	public Syslog get(Long id) {
		return syslogDao.get(id);
	}

	@Override
	public Long create(Syslog obj) {
		return syslogDao.create(obj);
	}

	@Override
	public void update(Syslog obj) {
		syslogDao.update(obj);
	}

	@Override
	public void saveOrUpdate(Syslog obj) {
		syslogDao.saveOrUpdate(obj);
	}

	@Override
	public List<Syslog> getAll() {
		return syslogDao.getAll();
	}

	@Override
	public List<Syslog> getAll(Paginator paginator) {
		return syslogDao.getAll(paginator);
	}

	@Override
	public List<Syslog> getAll(Paginator paginator, int sort_col,
			String sort_dir, String search_text) {
		return syslogDao.getAll(paginator, sort_col, sort_dir, search_text);
	}

	@Override
	public Long create(String level, Staff staff, String remark) {
		Syslog syslog=new Syslog();
		syslog.setLevel(level);
		syslog.setStaff(staff);
		syslog.setRemark(remark);
		return syslogDao.create(syslog);
	}

}
