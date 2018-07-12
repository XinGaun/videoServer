package com.dao;

import java.util.List;

import com.entity.UserRoleDomain;

public interface UserRoleDAO
{

	public int addUserRole(UserRoleDomain UserRoleDomain);

	public int deleteUserRole(UserRoleDomain UserRoleDomain);

	public int modifyUserRole(UserRoleDomain UserRoleDomain);

	public List<UserRoleDomain> queryListUserRole(UserRoleDomain UserRoleDomain);

	public UserRoleDomain searchSingleUserRole(UserRoleDomain UserRoleDomain);

	public int queryUserRoleCount(UserRoleDomain UserRoleDomain);
}
