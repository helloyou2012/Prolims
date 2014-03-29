package com.helloyou.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.helloyou.dao.OutStoreDao;
import com.helloyou.model.GoodsType;
import com.helloyou.model.OutStore;
import com.helloyou.util.Paginator;


@Repository("OutStoreDao")
public class OutStoreDaoImpl extends DaoImpl<OutStore> implements OutStoreDao{

	@Override
	public List<OutStore> getAll(Paginator paginator, GoodsType type) {
		DetachedCriteria dc=DetachedCriteria.forClass(getType(),"outstore");
		dc.add(Restrictions.eq("outstore.goods.type", type));
		dc.addOrder(Order.desc("outstore.id"));
		return find(dc, paginator);
	}

	@Override
	protected Class<OutStore> getType() {
		// TODO Auto-generated method stub
		return OutStore.class;
	}

	@Override
	public List<OutStore> getAll(Paginator paginator, int sort_col,
			String sort_dir, String search_text) {
		DetachedCriteria dc=DetachedCriteria.forClass(getType(),"outstore");
		String[] sort_cols={"id", "goods", "staff", "number", "pick_name", "pick_phone", "time"};
		if(sort_dir.equals("desc")){
			dc.addOrder(Order.desc("outstore."+sort_cols[sort_col]));
		}else{
			dc.addOrder(Order.asc("outstore."+sort_cols[sort_col]));
		}
		
		if(search_text!=null&&search_text.length()>0){
			dc.add(Restrictions.like("outstore.goods.name", "%"+search_text+"%"));
		}
		
		return find(dc, paginator);
	}

}
