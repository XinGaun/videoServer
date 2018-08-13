package com.service;

import java.util.List;

import com.entity.UserDomain;
import com.util.PaginationBean;

public interface IUserService
{

	public int addUser(UserDomain UserDomain);

	public int deleteUser(UserDomain UserDomain);

	public int modifyUser(UserDomain UserDomain);

	public List<UserDomain> queryListUser(UserDomain UserDomain,PaginationBean page);

	public UserDomain searchSingleUser(UserDomain UserDomain);

	public int  queryUserCount(UserDomain UserDomain);
}
