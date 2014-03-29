package com.helloyou.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.helloyou.dao.GoodsDao;
import com.helloyou.model.Goods;
import com.helloyou.model.GoodsType;
import com.helloyou.model.Staff;
import com.helloyou.util.Paginator;


@Repository("GoodsDao")
public class GoodsDaoImpl extends DaoImpl<Goods> implements GoodsDao{

	@Override
	public List<Goods> getAll(Paginator paginator, GoodsType type) {
		DetachedCriteria dc=DetachedCriteria.forClass(getType(),"goods");
		dc.add(Restrictions.eq("goods.type", type));
		dc.addOrder(Order.desc("goods.id"));
		return find(dc, paginator);
	}

	@Override
	public List<Goods> getAll(Paginator paginator, GoodsType type, Staff staff) {
		DetachedCriteria dc=DetachedCriteria.forClass(getType(),"goods");
		if(type!=null)
			dc.add(Restrictions.eq("goods.type", type));
		dc.add(Restrictions.eq("goods.staff", staff));
		dc.addOrder(Order.desc("goods.id"));
		return find(dc, paginator);
	}

	@Override
	public List<Goods> getAll(Paginator paginator, List<GoodsType> type) {
		DetachedCriteria dc=DetachedCriteria.forClass(getType(),"goods");
		dc.add(Restrictions.in("goods.type", type));
		dc.addOrder(Order.desc("goods.id"));
		return find(dc, paginator);
	}

	@Override
	protected Class<Goods> getType() {
		// TODO Auto-generated method stub
		return Goods.class;
	}

	@Override
	public List<Goods> getAll(Paginator paginator, int sort_col,
			String sort_dir, String search_text) {
		DetachedCriteria dc=DetachedCriteria.forClass(getType(),"goods");
		String[] sort_cols={"id", "name", "type", "staff", "number", "time"};
		if(sort_dir.equals("desc")){
			dc.addOrder(Order.desc("goods."+sort_cols[sort_col]));
		}else{
			dc.addOrder(Order.asc("goods."+sort_cols[sort_col]));
		}
		
		if(search_text!=null&&search_text.length()>0){
			dc.add(Restrictions.like("goods.name", "%"+search_text+"%"));
		}
		
		return find(dc, paginator);
	}

}
