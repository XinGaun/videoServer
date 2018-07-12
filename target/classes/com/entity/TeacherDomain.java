package com.entity;

import com.util.PaginationBean;

public class TeacherDomain
{
	private String teacher_id;
	private String teacher_name;
	private String teacher_phone;
	private String teacher_pwd;
	private String teacher_introduce;
	private String teacher_imgurl;
	private String teacher_status;
	private String teacher_date;
	private String teacher_mail;


	public String getTeacher_id()
	{
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id)
	{
		this.teacher_id = teacher_id ; 
	}

	public String getTeacher_name()
	{
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name)
	{
		this.teacher_name = teacher_name ; 
	}

	public String getTeacher_phone()
	{
		return teacher_phone;
	}

	public void setTeacher_phone(String teacher_phone)
	{
		this.teacher_phone = teacher_phone ; 
	}

	public String getTeacher_pwd()
	{
		return teacher_pwd;
	}

	public void setTeacher_pwd(String teacher_pwd)
	{
		this.teacher_pwd = teacher_pwd ; 
	}

	public String getTeacher_introduce()
	{
		return teacher_introduce;
	}

	public void setTeacher_introduce(String teacher_introduce)
	{
		this.teacher_introduce = teacher_introduce ; 
	}

	public String getTeacher_imgurl()
	{
		return teacher_imgurl;
	}

	public void setTeacher_imgurl(String teacher_imgurl)
	{
		this.teacher_imgurl = teacher_imgurl ; 
	}

	public String getTeacher_status()
	{
		return teacher_status;
	}

	public void setTeacher_status(String teacher_status)
	{
		this.teacher_status = teacher_status ; 
	}

	public String getTeacher_date()
	{
		return teacher_date;
	}

	public void setTeacher_date(String teacher_date)
	{
		this.teacher_date = teacher_date ; 
	}

	public String getTeacher_mail()
	{
		return teacher_mail;
	}

	public void setTeacher_mail(String teacher_mail)
	{
		this.teacher_mail = teacher_mail ; 
	}
	private PaginationBean page = null;
	public PaginationBean getPage() {return page;}
	public void setPage(PaginationBean page) { this.page = page;}
}
