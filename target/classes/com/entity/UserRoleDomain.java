package com.entity;

import com.util.PaginationBean;

public class UserRoleDomain
{
	private String id;
	private String user_id;
	private String role_id;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id ; 
	}

	public String getUser_id()
	{
		return user_id;
	}

	public void setUser_id(String user_id)
	{
		this.user_id = user_id ; 
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
