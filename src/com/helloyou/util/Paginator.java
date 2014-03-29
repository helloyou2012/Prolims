package com.helloyou.util;


/**
 * 分页
 * 
 * @author DIDI
 *
 */
public interface Paginator {

	int getFirst();

	int getLast();

	int getCurrent();

	int getPrevious();

	int getNext();

	int getFirstResult();

	int getPageSize();

	long getTotal();

	void setTotal(long total);

}