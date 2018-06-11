package com.dao;

import java.util.List;

import com.entity.RoleRightDomain;

public interface RoleRightDAO
{


	public int addRoleRight(RoleRightDomain RoleRightDomain);

	public int deleteRoleRight(RoleRightDomain RoleRightDomain);

	public int modifyRoleRight(RoleRightDomain RoleRightDomain);

	public List<RoleRightDomain> queryListRoleRight(RoleRightDomain RoleRightDomain);

	public RoleRightDomain searchSingleRoleRight(RoleRightDomain RoleRightDomain);

	public int queryRoleRightCount(RoleRightDomain RoleRightDomain);
}
