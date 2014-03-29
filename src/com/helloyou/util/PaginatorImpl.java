package com.helloyou.util;



public class PaginatorImpl implements Paginator {

	private long total;
	private int current;
	private int pageSize;

	public PaginatorImpl(int current, int pageSize) {
		super();
		this.current = current;
		this.pageSize = pageSize;
	}

	public int getFirst() {
		return 1;
	}

	public int getLast() {
		return (int) ((total - 1) / pageSize + 1);
	}

	public int getCurrent() {
		if (current < getFirst()) {
			return getFirst();
		} else{
			return current;
		}
	}

	public int getPrevious() {
		if (getCurrent() - 1 < getFirst()) {
			return getFirst();
		} else {
			return getCurrent() - 1;
		}
	}

	public int getNext() {
		if (getCurrent() + 1 > getLast()) {
			return getLast();
		} else {
			return getCurrent() + 1;
		}
	}

	public int getFirstResult() {
		return (getCurrent() - 1) * pageSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

}
