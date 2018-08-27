package com.entity;

import com.util.PaginationBean;

public class RightDomain
{
	private String right_id;
	private String right_name;
	private String right_introduce;
	private String right_status;

	public String getRight_id()
	{
		return right_id;
	}

	public void setRight_id(String right_id)
	{
		this.right_id = right_id ; 
	}

	public String getRight_name()
	{
		return right_name;
	}

	public void setRight_name(String right_name)
	{
		this.right_name = right_name ; 
	}

	public String getRight_introduce()
	{
		return right_introduce;
	}

	public void setRight_introduce(String right_introduce)
	{
		this.right_introduce = right_introduce ; 
	}

	public String getRight_status()
	{
		return right_status;
	}

	public void setRight_status(String right_status)
	{
		this.right_status = right_status ; 
	}
	private PaginationBean page = null;
	public PaginationBean getPage() {return page;}
	public void setPage(PaginationBean page) { this.page = page;}
}
