package com.dao;

import java.util.List;

import com.entity.RightDomain;

public interface RightDAO
{


	public int addRight(RightDomain RightDomain);

	public int deleteRight(RightDomain RightDomain);

	public int modifyRight(RightDomain RightDomain);

	public List<RightDomain> queryListRight(RightDomain RightDomain);

	public RightDomain searchSingleRight(RightDomain RightDomain);

	public int queryRightCount(RightDomain RightDomain);
}
