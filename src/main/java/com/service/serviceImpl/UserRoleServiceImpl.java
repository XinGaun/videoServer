package com.service.serviceImpl;

import java.util.List;

import com.dao.UserRoleDAO;
import com.entity.UserRoleDomain;
import com.service.IUserRoleService;
import com.util.PaginationBean;

public class UserRoleServiceImpl implements IUserRoleService
{
	public UserRoleDAO UserRoleDAO;

	public void setUserRoleDAO(UserRoleDAO UserRoleDAO)
	{
		this.UserRoleDAO = UserRoleDAO;
	}

	public int addUserRole(UserRoleDomain UserRoleDomain)
	{
		return UserRoleDAO.addUserRole(UserRoleDomain);
	}

	public int deleteUserRole(UserRoleDomain UserRoleDomain)
	{
		return UserRoleDAO.deleteUserRole(UserRoleDomain);
	}

	public int modifyUserRole(UserRoleDomain UserRoleDomain)
	{
		return UserRoleDAO.modifyUserRole(UserRoleDomain);
	}

	public List<UserRoleDomain> queryListUserRole(UserRoleDomain UserRoleDomain,PaginationBean page)
	{
		if( page != null )
		{
			page.setTotalRows(queryUserRoleCount(UserRoleDomain));
			page.repaginate();
			
			UserRoleDomain.setPage(page);
		}
		return UserRoleDAO.queryListUserRole(UserRoleDomain);
	}

	public UserRoleDomain searchSingleUserRole(UserRoleDomain UserRoleDomain)
	{
		List<UserRoleDomain> list = queryListUserRole(UserRoleDomain,null);
		if(list == null || list.isEmpty() || list.size()<1)
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}

	public int  queryUserRoleCount(UserRoleDomain UserRoleDomain)
	{
		return UserRoleDAO.queryUserRoleCount(UserRoleDomain);
	}
}
