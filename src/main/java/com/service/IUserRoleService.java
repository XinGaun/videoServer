package com.service;

import java.util.List;

import com.entity.UserRoleDomain;
import com.util.PaginationBean;

public interface IUserRoleService
{

	public int addUserRole(UserRoleDomain UserRoleDomain);

	public int deleteUserRole(UserRoleDomain UserRoleDomain);

	public int modifyUserRole(UserRoleDomain UserRoleDomain);

	public List<UserRoleDomain> queryListUserRole(UserRoleDomain UserRoleDomain,PaginationBean page);

	public UserRoleDomain searchSingleUserRole(UserRoleDomain UserRoleDomain);

	public int  queryUserRoleCount(UserRoleDomain UserRoleDomain);
}
