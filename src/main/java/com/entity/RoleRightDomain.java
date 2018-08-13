package com.entity;

import com.util.PaginationBean;

public class RoleRightDomain
{
	private String right_id;
	private String role_id;

	public String getRight_id()
	{
		return right_id;
	}

	public void setRight_id(String right_id)
	{
		this.right_id = right_id ; 
	}

	public String getRole_id()
	{
		return role_id;
	}

	public void setRole_id(String role_id)
	{
		this.role_id = role_id ; 
	}
	private PaginationBean page = null;
	public PaginationBean getPage() {return page;}
	public void setPage(PaginationBean page) { this.page = page;}
}
