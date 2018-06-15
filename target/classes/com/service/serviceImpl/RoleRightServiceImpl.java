package com.service.serviceImpl;

import java.util.List;

import org.eclipse.jetty.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.RoleRightDAO;
import com.entity.RoleRightDomain;
import com.service.IRoleRightService;
import com.util.PaginationBean;
import com.util.ResponseInfo;

@Service
public class RoleRightServiceImpl implements IRoleRightService
{
	@Autowired
	public RoleRightDAO RoleRightDAO;

	public void setRoleRightDAO(RoleRightDAO RoleRightDAO)
	{
		this.RoleRightDAO = RoleRightDAO;
	}

	public int addRoleRight(RoleRightDomain RoleRightDomain)
	{
		return RoleRightDAO.addRoleRight(RoleRightDomain);
	}

	public int deleteRoleRight(RoleRightDomain RoleRightDomain)
	{
		return RoleRightDAO.deleteRoleRight(RoleRightDomain);
	}
	
	@Transactional
	public ResponseInfo modifyRoleRight(RoleRightDomain RoleRightDomain)
	{	
		ResponseInfo responseInfo = new ResponseInfo(1, "修改角色权限成功!");
		//先删除所有该角色的权限
		RoleRightDomain param = null;
		param = new RoleRightDomain();
		if (StringUtil.isBlank(RoleRightDomain.getRole_id())) {
			responseInfo.setRetCode(0).setRetMsg("数据错误,接收角色编号为空!");
			return responseInfo;
		}
		param.setRole_id(RoleRightDomain.getRole_id());
		int oparteStatus = deleteRoleRight(param);
		String[] rights = RoleRightDomain.getRight_id().split(",");
		for (int i = 0; i < rights.length; i++) {
			param.setRight_id(rights[i]);
			addRoleRight(param);
		}
		return responseInfo;
	}

	public List<RoleRightDomain> queryListRoleRight(RoleRightDomain RoleRightDomain,PaginationBean page)
	{
		if( page != null )
		{
			page.setTotalRows(queryRoleRightCount(RoleRightDomain));
			page.repaginate();
			
			RoleRightDomain.setPage(page);
		}
		return RoleRightDAO.queryListRoleRight(RoleRightDomain);
	}

	public RoleRightDomain searchSingleRoleRight(RoleRightDomain RoleRightDomain)
	{
		List<RoleRightDomain> list = queryListRoleRight(RoleRightDomain,null);
		if(list == null || list.isEmpty() || list.size()<1)
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}

	public int  queryRoleRightCount(RoleRightDomain RoleRightDomain)
	{
		return RoleRightDAO.queryRoleRightCount(RoleRightDomain);
	}
}
