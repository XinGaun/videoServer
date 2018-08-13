package com.dao;

import java.util.List;

import com.entity.RoleDomain;

public interface RoleDAO
{

	public int addRole(RoleDomain RoleDomain);

	public int deleteRole(RoleDomain RoleDomain);

	public int modifyRole(RoleDomain RoleDomain);

	public List<RoleDomain> queryListRole(RoleDomain RoleDomain);
	

	public RoleDomain searchSingleRole(RoleDomain RoleDomain);

	public int queryRoleCount(RoleDomain RoleDomain);
}
