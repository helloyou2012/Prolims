package com.helloyou.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.helloyou.dao.DepartmentDao;
import com.helloyou.model.Department;
import com.helloyou.util.Paginator;

@Repository("DepartmentDao")
public class DepartmentDaoImpl extends DaoImpl<Department> implements DepartmentDao{

	@Override
	protected Class<Department> getType() {
		// TODO Auto-generated method stub
		return Department.class;
	}

	@Override
	public List<Department> getAll(Paginator paginator, int sort_col,
			String sort_dir, String search_text) {
		DetachedCriteria dc=DetachedCriteria.forClass(getType(),"dept");
		String[] sort_cols={"id", "name","time"};
		if(sort_dir.equals("desc")){
			dc.addOrder(Order.desc("dept."+sort_cols[sort_col]));
		}else{
			dc.addOrder(Order.asc("dept."+sort_cols[sort_col]));
		}
		
		if(search_text!=null&&search_text.length()>0){
			dc.add(Restrictions.like("dept.name", "%"+search_text+"%"));
		}
		
		return find(dc, paginator);
	}

}
