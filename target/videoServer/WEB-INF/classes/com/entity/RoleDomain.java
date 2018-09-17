package com.entity;

import com.util.PaginationBean;

public class RoleDomain
{
	private String role_id;
	private String role_name;
	private String role_introduce;
	private String role_status;

	public String getRole_id()
	{
		return role_id;
	}

	public void setRole_id(String role_id)
	{
		this.role_id = role_id ; 
	}

	public String getRole_name()
	{
		return role_name;
	}

	public void setRole_name(String role_name)
	{
		this.role_name = role_name ; 
	}

	public String getRole_introduce()
	{
		return role_introduce;
	}

	public void setRole_introduce(String role_introduce)
	{
		this.role_introduce = role_introduce ; 
	}

	public String getRole_status()
	{
		return role_status;
	}

	public void setRole_status(String role_status)
	{
		this.role_status = role_status ; 
	}
	private PaginationBean page = null;
	public PaginationBean getPage() {return page;}
	public void setPage(PaginationBean page) { this.page = page;}
}
