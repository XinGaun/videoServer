package com.util;

import java.io.Serializable;

public class PaginationBean	implements Serializable
{
	public static final int PAGESIZE = 5;
	private static final long serialVersionUID = 416489995091575203L;
	public int totalPages;    //总页�?
	private int currentPage; // 当前�?
	private int pageSize;	//页大�?
	private int totalRows;	//总行�?
	private int startNum;
	private int nextPage;	//下一�?
	private int previousPage; //上一�?
	private int queryRecordSize; //记录大小
	private boolean hasNextPage;  //是否有下�?��
	private boolean hasPreviousPage;//是否有上�?��
	private boolean needToPage = false;
	
	//显示结束位置
	private int endIndex;
	
	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public boolean isNeedToPage() {
		return needToPage;
	}

	public void setNeedToPage(boolean needToPage) {
		this.needToPage = needToPage;
	}

	public PaginationBean()
	{
		this(0, 1, 5);
	}
	
	public PaginationBean(int totalRows)
	{
	  this(totalRows, 1, 5);
	}
	
	public PaginationBean(int totalRows, int currentPage)
	{
	  this(totalRows, currentPage, 5);
	}
	
	public PaginationBean(int totalRows, int currentPage, int pageSize)
	{
	  this.totalPages = 0;
	
	  this.currentPage = 1;
	
	  this.pageSize = 0;
	
	  this.totalRows = 0;
	
	  this.startNum = 0;
	
	  this.nextPage = 0;
	
	  this.previousPage = 0;
	
	  this.queryRecordSize = 0;
	
	  this.hasNextPage = false;
	
	  this.hasPreviousPage = false;
	
	  this.pageSize = pageSize;
	  this.currentPage = currentPage;
	  this.totalRows = totalRows;
	  this.endIndex = pageSize;
	  repaginate();
	}
	
	public void repaginate()
	{
		
		
		
	  if (this.totalRows % this.pageSize == 0)
	  {
	    this.totalPages = (this.totalRows / this.pageSize);
	  }
	  else
	  {
	    this.totalPages = (this.totalRows / this.pageSize + 1);
	  }
	
	  if (this.currentPage >= this.totalPages)
	  {
	    this.hasNextPage = false;
//	    this.currentPage = this.totalPages;
	  }
	  else
	  {
	    this.hasNextPage = true;
	  }
	
	  if (this.currentPage <= 1)
	  {
	    this.hasPreviousPage = false;
	    this.currentPage = 1;
	  }
	  else
	  {
	    this.hasPreviousPage = true;
	  }
	
	  if(this.currentPage <= 1)
		{
			this.startNum = 0;
		}else
		{
			this.startNum = ((this.currentPage - 1) * this.pageSize);
		}
		
		if(this.currentPage > 1 && this.currentPage != this.totalPages)
		{
			/*this.endIndex = this.currentPage * this.pageSize ;*/
			
		}else if(this.currentPage > 1 && this.currentPage == this.totalPages)
		{
			this.startNum = (this.currentPage - 1) * this.pageSize;
//			this.endIndex = this.totalRows;
		}else
		{
//			this.endIndex = this.pageSize ;
		}
	
	  this.nextPage = (this.currentPage + 1);
	
	  if (this.nextPage >= this.totalPages)
	  {
	    this.nextPage = this.totalPages;
	  }
	
	  this.previousPage = (this.currentPage - 1);
	
	  if (this.previousPage <= 1)
	  {
	    this.previousPage = 1;
	  }
	
	  //if (this.queryRecordSize != 0)
	   // return;
	 // this.queryRecordSize = this.pageSize;
	  this.endIndex=this.pageSize;
	  
	}
	

	public boolean isHasNextPage()
	{
	  return this.hasNextPage;
	}
	
	public boolean isHasPreviousPage()
	{
	  return this.hasPreviousPage;
	}
	
	public int getNextPage()
	{
	  return this.nextPage;
	}
	
	public void setNextPage(int nextPage)
	{
	  this.nextPage = nextPage;
	}
	
	public int getPreviousPage()
	{
	  return this.previousPage;
	}
	
	public void setPreviousPage(int previousPage)
	{
	  this.previousPage = previousPage;
	}
	
	public int getCurrentPage()
	{
	  return this.currentPage;
	}
	
	public void setCurrentPage(int currentPage)
	{
	  this.currentPage = currentPage;
	  /*this.startNum = pageSize*(this.currentPage-1)+1;
		this.endIndex = pageSize*(this.currentPage);*/
	}
	
	public int getPageSize()
	{
	  return this.pageSize;
	}
	
	public void setPageSize(int pageSize)
	{
	  this.pageSize = pageSize;
	}
	
	public int getTotalPages()
	{
	  return this.totalPages;
	}
	
	public int getTotalRows()
	{
	  return this.totalRows;
	}
	
	public void setTotalRows(int totalRows)
	{
	  this.totalRows = totalRows;
	}
	
	public void setHasPreviousPage(boolean hasPreviousPage)
	{
	  this.hasPreviousPage = hasPreviousPage;
	}
	
	public int getStartNum()
	{
	  return this.startNum;
	}
	
	public void setStartNum(int startNum)
	{
	  this.startNum = startNum;
	}
	
	public int getQueryRecordSize()
	{
	  return this.queryRecordSize;
	}
	
	public void setQueryRecordSize(int queryRecordSize)
	{
	  this.queryRecordSize = queryRecordSize;
	}
	
	public void setHasNextPage(boolean hasNextPage)
	{
	  this.hasNextPage = hasNextPage;
	}
	
	public void setTotalPages(int totalPages)
	{
	  this.totalPages = totalPages;
	}
}