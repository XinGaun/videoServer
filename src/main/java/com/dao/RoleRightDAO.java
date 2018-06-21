package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.entity.RoleRightDomain;

public interface RoleRightDAO
{


	public int addRoleRight(RoleRightDomain RoleRightDomain);

	public int deleteRoleRight(RoleRightDomain RoleRightDomain);

	public int modifyRoleRight(RoleRightDomain RoleRightDomain);

	public List<RoleRightDomain> queryListRoleRight(RoleRightDomain RoleRightDomain);

	public RoleRightDomain searchSingleRoleRight(RoleRightDomain RoleRightDomain);

	public int queryRoleRightCount(RoleRightDomain RoleRightDomain);

	public List<Map<String, String>> queryUserRole(@Param("teacher_id")String teacher_id);
}
