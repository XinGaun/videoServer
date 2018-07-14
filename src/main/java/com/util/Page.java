package com.util;

import java.util.HashMap;

public class Page {
	public static HashMap<String,Object> page(HashMap<String,Object> hashMap){
		if(hashMap!=null){
			if(hashMap.get("page")==null||Integer.parseInt(hashMap.get("page").toString())==0){
				hashMap.put("page",9);
			}
			if(hashMap.get("nums")==null){
				hashMap.put("nums",0);
			}
			return hashMap;
		}else{
			HashMap<String,Object> hashmap=new HashMap<String,Object>();
			hashmap.put("page",9);
			hashmap.put("nums",0);
			return hashmap;
		}
	}
}
