package com.service;

import java.util.HashMap;

public interface OpinionTabService {
	
	public int addOpinionTab(HashMap<String,Object> hashMap);
	
	public int queryOpinionTab(HashMap<String,Object> hashMap);
	
	public int queryOpinionTabCount(HashMap<String,Object> hashMap);
	
	public int updateOpinionTab(HashMap<String,Object> hashMap);
	
	public int deleteOpinionTab(int order_id);
}
