package com.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.RoleDAO;
import com.dao.RoleRightDAO;
import com.entity.RoleDomain;
import com.entity.RoleRightDomain;
import com.service.IRoleService;
import com.util.PaginationBean;
import com.util.ResponseInfo;

@Service
public class RoleServiceImpl implements IRoleService
{
	@Autowired
	public RoleDAO RoleDAO;
	@Autowired
	private RoleRightDAO roleRightDAO;

	public void setRoleDAO(RoleDAO RoleDAO)
	{
		this.RoleDAO = RoleDAO;
	}

	public ResponseInfo addRole(RoleDomain RoleDomain)
	{
		ResponseInfo responseInfo = new ResponseInfo(1, "添加角色成功!");
		int addStatus = RoleDAO.addRole(RoleDomain);
		if(addStatus == 0){
			responseInfo.setRetCode(0).setRetMsg("添加角色信息失败!");
		}
		return responseInfo;
	}

	@Transactional
	public int deleteRole(RoleDomain RoleDomain)
	{
		//删除角色需要删除角色对应的权限
		RoleRightDomain param = new RoleRightDomain();
		param.setRole_id(RoleDomain.getRole_id());
		roleRightDAO.deleteRoleRight(param);
		
		return RoleDAO.deleteRole(RoleDomain);
	}

	public int modifyRole(RoleDomain RoleDomain)
	{
		return RoleDAO.modifyRole(RoleDomain);
	}

	public List<RoleDomain> queryListRole(RoleDomain RoleDomain,PaginationBean page)
	{
		if( page != null )
		{
			page.setTotalRows(queryRoleCount(RoleDomain));
			page.repaginate();
			
			RoleDomain.setPage(page);
		}
		return RoleDAO.queryListRole(RoleDomain);
	}

	public RoleDomain searchSingleRole(RoleDomain RoleDomain)
	{
		List<RoleDomain> list = queryListRole(RoleDomain,null);
		if(list == null || list.isEmpty() || list.size()<1)
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}

	public int  queryRoleCount(RoleDomain RoleDomain)
	{
		return RoleDAO.queryRoleCount(RoleDomain);
	}
}
