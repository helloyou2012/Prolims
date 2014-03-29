package com.helloyou.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.helloyou.dao.SyslogDao;
import com.helloyou.model.Staff;
import com.helloyou.model.Syslog;
import com.helloyou.util.Paginator;


@Repository("SyslogDao")
public class SyslogDaoImpl extends DaoImpl<Syslog> implements SyslogDao{

	@Override
	public List<Syslog> getAll(Paginator paginator, Staff staff) {
		DetachedCriteria dc=DetachedCriteria.forClass(getType(),"syslog");
		dc.add(Restrictions.eq("syslog.staff", staff));
		dc.addOrder(Order.desc("syslog.id"));
		return find(dc, paginator);
	}

	@Override
	protected Class<Syslog> getType() {
		// TODO Auto-generated method stub
		return Syslog.class;
	}

	@Override
	public List<Syslog> getAll(Paginator paginator, int sort_col,
			String sort_dir, String search_text) {
		DetachedCriteria dc=DetachedCriteria.forClass(getType(),"syslog");
		String[] sort_cols={"id", "time", "level", "staff", "remark"};
		if(sort_dir.equals("desc")){
			dc.addOrder(Order.desc("syslog."+sort_cols[sort_col]));
		}else{
			dc.addOrder(Order.asc("syslog."+sort_cols[sort_col]));
		}
		
		if(search_text!=null&&search_text.length()>0){
			dc.add(Restrictions.like("syslog.remark", "%"+search_text+"%"));
		}
		
		return find(dc, paginator);
	}

}
