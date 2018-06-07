package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Param;

import com.entity.CommentTab;

public interface CommentTabDao {

	public int addCommentTabMap(HashMap<String,Object> comment);
	
	public int addCommentTabEntity(CommentTab comment);
	
	public ArrayList<HashMap<String,Object>> queryCommentTab(HashMap<String,Object> hashMap);
	
	public int queryCount(HashMap<String,Object> hashMap);
	
	public int updateCommentTab(HashMap<String,Object> hashMap);

	public int deleteCommentTab(@Param(value="comment_id") int comment_id);
}
