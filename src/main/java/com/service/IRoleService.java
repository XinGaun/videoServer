package com.service;

import java.util.List;

import com.entity.RoleDomain;
import com.util.PaginationBean;
import com.util.ResponseInfo;

public interface IRoleService
{

	public ResponseInfo addRole(RoleDomain RoleDomain);

	public int deleteRole(RoleDomain RoleDomain);

	public int modifyRole(RoleDomain RoleDomain);

	public List<RoleDomain> queryListRole(RoleDomain RoleDomain,PaginationBean page);

	public RoleDomain searchSingleRole(RoleDomain RoleDomain);

	public int  queryRoleCount(RoleDomain RoleDomain);
}
