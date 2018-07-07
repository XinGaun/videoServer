package com.service.serviceImpl;


import java.util.List;

import org.eclipse.jetty.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TeacherDAO;
import com.entity.TeacherDomain;
import com.service.ITeacherService;
import com.util.DateUtil;
import com.util.MD5;
import com.util.PaginationBean;
import com.util.ResponseInfo;

@Service
public class TeacherServiceImpl implements ITeacherService
{
	@Autowired
	private TeacherDAO TeacherDAO;

	public void setTeacherDAO(TeacherDAO TeacherDAO)
	{
		this.TeacherDAO = TeacherDAO;
	}

	public ResponseInfo addTeacher(TeacherDomain TeacherDomain)
	{
		ResponseInfo responseInfo = new ResponseInfo(1, "添加教师信息成功!");
		if (StringUtil.isBlank(TeacherDomain.getTeacher_phone())) {
			responseInfo.setRetCode(0).setRetMsg("数据有误,手机号不能为空!");
			return responseInfo;
		}
		TeacherDomain.setTeacher_date(DateUtil.getCurDateStr(DateUtil.YYYY_MM_DD_SS));
		TeacherDomain.setTeacher_pwd(MD5.md5(TeacherDomain.getTeacher_pwd()));
		int addStatus = TeacherDAO.addTeacher(TeacherDomain);
		if (addStatus != 1) {
			responseInfo.setRetCode(0).setRetMsg("系统有误,添加教师信息失败!");
		}
		return responseInfo;
	}

	public int deleteTeacher(TeacherDomain TeacherDomain)
	{
		return TeacherDAO.deleteTeacher(TeacherDomain);
	}

	public int modifyTeacher(TeacherDomain TeacherDomain)
	{
		return TeacherDAO.modifyTeacher(TeacherDomain);
	}

	public List<TeacherDomain> queryListTeacher(TeacherDomain TeacherDomain,PaginationBean page)
	{
		if( page != null )
		{
			page.setTotalRows(queryTeacherCount(TeacherDomain));
			page.repaginate();
			
			TeacherDomain.setPage(page);
		}
		return TeacherDAO.queryListTeacher(TeacherDomain);
	}

	public TeacherDomain searchSingleTeacher(TeacherDomain TeacherDomain)
	{	
		List<TeacherDomain> list = queryListTeacher(TeacherDomain,null);
		if(list == null || list.isEmpty() || list.size()<1)
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}

	public int  queryTeacherCount(TeacherDomain TeacherDomain)
	{
		return TeacherDAO.queryTeacherCount(TeacherDomain);
	}

}
