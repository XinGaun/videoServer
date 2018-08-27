package com.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.RightDAO;
import com.entity.RightDomain;
import com.service.IRightService;
import com.util.PaginationBean;

@Service
public class RightServiceImpl implements IRightService
{
	@Autowired
	public RightDAO RightDAO;

	public void setRightDAO(RightDAO RightDAO)
	{
		this.RightDAO = RightDAO;
	}

	public int addRight(RightDomain RightDomain)
	{
		return RightDAO.addRight(RightDomain);
	}

	public int deleteRight(RightDomain RightDomain)
	{
		return RightDAO.deleteRight(RightDomain);
	}

	public int modifyRight(RightDomain RightDomain)
	{
		return RightDAO.modifyRight(RightDomain);
	}

	public List<RightDomain> queryListRight(RightDomain RightDomain,PaginationBean page)
	{
		if( page != null )
		{
			page.setTotalRows(queryRightCount(RightDomain));
			page.repaginate();
			
			RightDomain.setPage(page);
		}
		return RightDAO.queryListRight(RightDomain);
	}

	public RightDomain searchSingleRight(RightDomain RightDomain)
	{
		List<RightDomain> list = queryListRight(RightDomain,null);
		if(list == null || list.isEmpty() || list.size()<1)
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}

	public int  queryRightCount(RightDomain RightDomain)
	{
		return RightDAO.queryRightCount(RightDomain);
	}
}
