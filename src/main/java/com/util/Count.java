package com.util;

import java.util.ArrayList;
import java.util.HashMap;

public class Count {
	public static ArrayList<HashMap<String,Object>> count(ArrayList<HashMap<String,Object>> list,int count,HashMap<String,Object> hashMap){
		if(count>0){
			int page = Integer.parseInt(hashMap.get("page").toString());
			int counts = count/page;
			if(counts==0){
				counts =counts+1;
			}
			if(count%page>0&&count>page){
				counts =counts+1;
			}
			hashMap.put("count",counts);
			list.add(hashMap);
		}else{
			list.add(hashMap);
		}
		return list;
	}
	
	public static HashMap<String,Object> counts(ArrayList<HashMap<String,Object>> list,int count,HashMap<String,Object> hashMap,int code,String msg){
		HashMap<String,Object> restMap = new HashMap<String,Object>();
		if(count>0) {
			int page = Integer.parseInt(hashMap.get("page").toString());
			int counts = count/page;
			if(counts==0){
				counts =counts+1;
			}
			if(count%page>0&&count>page){
				counts =counts+1;
			}
			restMap.put("total",counts);
			restMap.put("list",list);
		}else{
			restMap.put("list",list);
		}
		restMap.put("code",code);
		restMap.put("msg",msg);
		restMap.put("parameter",hashMap);
		return restMap;
	};
}
