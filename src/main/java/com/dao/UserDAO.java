package com.dao;

import java.util.List;

import com.entity.RightDomain;
import com.entity.UserDomain;

public interface UserDAO
{

	public int addUser(UserDomain UserDomain);

	public int deleteUser(UserDomain UserDomain);

	public int modifyUser(UserDomain UserDomain);

	public List<UserDomain> queryListUser(UserDomain UserDomain);

	public int queryUserCount(UserDomain UserDomain);
	
	public List<RightDomain> queryUserRight(String userId);
}
