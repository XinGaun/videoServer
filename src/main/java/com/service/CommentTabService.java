package com.service;

import java.util.HashMap;
import java.util.List;

public interface CommentTabService {
	
	public String addCommentTabMap(HashMap<String,Object> comment);
	
//	public int addCommentTabEntity(CommentTab comment);
	
	public String queryCommentTab(HashMap<String,Object> hashMap);
	
	public String updateCommentTab(HashMap<String,Object> hashMap);

	public String deleteCommentTab(List<String> datalist);
}
