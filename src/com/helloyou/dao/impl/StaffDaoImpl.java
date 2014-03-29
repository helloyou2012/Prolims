package com.helloyou.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.helloyou.dao.StaffDao;
import com.helloyou.model.Staff;
import com.helloyou.util.Paginator;


@Repository("StaffDao")
public class StaffDaoImpl extends DaoImpl<Staff> implements StaffDao{

	@Override
	public List<Staff> findByName(String name) {
		DetachedCriteria dc=DetachedCriteria.forClass(getType(),"staff");
		dc.add(Restrictions.eq("staff.username", name));
		List<Staff> us= find(dc);
		if(us!=null &&!us.isEmpty())
			return us;
		else
			return null;
	}

	@Override
	public Staff findByNameAndPasswd(String name, String passwd) {
		DetachedCriteria dc=DetachedCriteria.forClass(getType(),"staff");
		dc.add(Restrictions.eq("staff.username", name));
		dc.add(Restrictions.eq("staff.password", passwd));
		List<Staff> us= find(dc);
		if(us!=null &&!us.isEmpty())
			return us.get(0);
		else
			return null;
	}

	@Override
	protected Class<Staff> getType() {
		// TODO Auto-generated method stub
		return Staff.class;
	}

	@Override
	public List<Staff> getAll(Paginator paginator, int sort_col,
			String sort_dir, String search_text) {
		DetachedCriteria dc=DetachedCriteria.forClass(getType(),"staff");
		String[] sort_cols={"id", "username", "sex", "department", "level", "time"};
		if(sort_dir.equals("desc")){
			dc.addOrder(Order.desc("staff."+sort_cols[sort_col]));
		}else{
			dc.addOrder(Order.asc("staff."+sort_cols[sort_col]));
		}
		
		if(search_text!=null&&search_text.length()>0){
			dc.add(Restrictions.like("staff.username", "%"+search_text+"%"));
		}
		
		return find(dc, paginator);
	}

}
