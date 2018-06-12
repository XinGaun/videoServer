package com.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDAO;
import com.entity.UserDomain;
import com.service.IUserService;
import com.util.PaginationBean;

@Service
public class UserServiceImpl implements IUserService
{
	@Autowired
	public UserDAO UserDAO;

	public void setUserDAO(UserDAO UserDAO)
	{
		this.UserDAO = UserDAO;
	}

	public int addUser(UserDomain UserDomain)
	{
		return UserDAO.addUser(UserDomain);
	}

	public int deleteUser(UserDomain UserDomain)
	{
		return UserDAO.deleteUser(UserDomain);
	}

	public int modifyUser(UserDomain UserDomain)
	{
		return UserDAO.modifyUser(UserDomain);
	}

	public List<UserDomain> queryListUser(UserDomain UserDomain,PaginationBean page)
	{
		if( page != null )
		{
			page.setTotalRows(queryUserCount(UserDomain));
			page.repaginate();
			
			UserDomain.setPage(page);
		}
		return UserDAO.queryListUser(UserDomain);
	}

	public UserDomain searchSingleUser(UserDomain UserDomain)
	{
		List<UserDomain> list = queryListUser(UserDomain,null);
		if(list == null || list.isEmpty() || list.size()<1)
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}

	public int  queryUserCount(UserDomain UserDomain)
	{
		return UserDAO.queryUserCount(UserDomain);
	}
}
