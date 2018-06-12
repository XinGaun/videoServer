package com.service;

import java.util.List;

import com.entity.RightDomain;
import com.util.PaginationBean;

public interface IRightService
{

	public int addRight(RightDomain RightDomain);

	public int deleteRight(RightDomain RightDomain);

	public int modifyRight(RightDomain RightDomain);

	public List<RightDomain> queryListRight(RightDomain RightDomain,PaginationBean page);

	public RightDomain searchSingleRight(RightDomain RightDomain);

	public int  queryRightCount(RightDomain RightDomain);
}
