package com.service;

import java.util.List;

import com.entity.RoleRightDomain;
import com.util.PaginationBean;
import com.util.ResponseInfo;

public interface IRoleRightService
{

	public int addRoleRight(RoleRightDomain RoleRightDomain);

	public int deleteRoleRight(RoleRightDomain RoleRightDomain);

	public ResponseInfo modifyRoleRight(RoleRightDomain RoleRightDomain);

	public List<RoleRightDomain> queryListRoleRight(RoleRightDomain RoleRightDomain,PaginationBean page);

	public RoleRightDomain searchSingleRoleRight(RoleRightDomain RoleRightDomain);

	public int  queryRoleRightCount(RoleRightDomain RoleRightDomain);
}
