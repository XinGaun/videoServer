package com.util;

import java.util.List;

public class PageHelper<T> {
	
	private Integer limit;
	private Integer page;
	private Integer total;
	private List<T> data;
	
	public PageHelper() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageHelper(List<T> data) {
		super();
		this.data = data;
	}
	public PageHelper(Integer limit, Integer page, Integer total) {
		super();
		this.limit = limit;
		this.page = page;
		this.total = total;
	}
	public PageHelper(Integer limit, Integer page, Integer total, List<T> data) {
		super();
		this.limit = limit;
		this.page = page;
		this.total = total;
		this.data = data;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "PageHelper [limit=" + limit + ", page=" + page + ", total=" + total + ", data=" + data + "]";
	}
	

}
