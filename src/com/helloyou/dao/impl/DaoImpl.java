package com.helloyou.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.helloyou.dao.Dao;
import com.helloyou.model.Po;
import com.helloyou.util.Paginator;

public abstract class DaoImpl<T extends Po> implements Dao<T> {

	@Autowired
	protected HibernateTemplate hibernateTemplate;

	protected abstract Class<T> getType();

	@Override
	public Long create(T t) {
		t.setTime(new Date());
		return (Long) hibernateTemplate.save(t);
	}

	@Override
	public void delete(T t) {
		hibernateTemplate.delete(t);
	}

	@Override
	public void update(T t) {
		hibernateTemplate.update(t);
	}
	
	@Override
	public void saveOrUpdate(T t) {
		t.setTime(new Date());
		hibernateTemplate.saveOrUpdate(t);
	}

	@Override
	public T get(Long id) {
		return hibernateTemplate.get(getType(), id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(getType());
		criteria.addOrder(Order.desc("id"));
		return hibernateTemplate.findByCriteria(criteria);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(String order) {
		DetachedCriteria criteria = DetachedCriteria.forClass(getType());
		criteria.addOrder(Order.desc(order));
		return hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public List<T> getAll(Paginator paginator) {
		DetachedCriteria criteria = DetachedCriteria.forClass(getType());
		criteria.addOrder(Order.desc("id"));
		return find(criteria, paginator);
	}
	
	public List<T> getAll(Paginator paginator,String sort_item, Boolean desc, String search_item,String search_text){
		DetachedCriteria dc=DetachedCriteria.forClass(getType());
		if(desc){
			dc.addOrder(Order.desc(sort_item));
		}else{
			dc.addOrder(Order.asc(sort_item));
		}
		
		if(search_text!=null&&search_text.length()>0){
			dc.add(Restrictions.like(search_item, "%"+search_text+"%"));
		}
		
		return find(dc, paginator);
	}

	@SuppressWarnings("unchecked")
	protected List<T> find(DetachedCriteria criteria) {
		return hibernateTemplate.findByCriteria(criteria);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected List<T> find(final DetachedCriteria criteria,
			final Paginator paginator) {
		return hibernateTemplate.executeFind(new HibernateCallback() {
			@Override
			public List<T> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria executableCriteria = criteria
						.getExecutableCriteria(session);
				ScrollableResults scrollableResults = executableCriteria
						.scroll();
				scrollableResults.last();
				paginator.setTotal(scrollableResults.getRowNumber() + 1);
				scrollableResults.close();
				executableCriteria.setFirstResult(paginator.getFirstResult());
				executableCriteria.setMaxResults(paginator.getPageSize());
				return executableCriteria.list();
			}
		});
	}

	@SuppressWarnings("unchecked")
	protected List<T> find(DetachedCriteria criteria, int firstResult,
			int maxResults) {
		return hibernateTemplate.findByCriteria(criteria, firstResult,
				maxResults);
	}

	@SuppressWarnings("unchecked")
	protected List<T> find(String queryString) {
		return hibernateTemplate.find(queryString);
	}

	@SuppressWarnings("unchecked")
	protected List<T> find(String queryString, Object[] values) {
		return hibernateTemplate.find(queryString, values);
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> find(String queryString, Object values) {
		return hibernateTemplate.find(queryString, values);
	}

}
