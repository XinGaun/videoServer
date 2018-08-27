package com.util;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
/**
 * 结果信息封装
 * @author ice
 *
 */
public class ResponseInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private int retCode;
	private String retMsg;
	private Map<String,? extends Object> retMap;
	private Object retObject;
	private List<? extends Object> listObject;
	private List<Map<String,Object>> listMap;
	
	public ResponseInfo(int retCode, String retMsg) {
		super();
		this.retCode = retCode;
		this.retMsg = retMsg;
	}
	public int getRetCode() {
		return retCode;
	}
	public ResponseInfo setRetCode(int retCode) {
		this.retCode = retCode;
		return this;
	}
	public String getRetMsg() {
		return retMsg;
	}
	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}
	public Object getRetObject() {
		return retObject;
	}
	public void setRetObject(Object retObject) {
		this.retObject = retObject;
	}
	public Map<String, ? extends Object> getRetMap() {
		return retMap;
	}
	public void setRetMap(Map<String, ? extends Object> retMap) {
		this.retMap = retMap;
	}
	public List<? extends Object> getListObject() {
		return listObject;
	}
	public void setListObject(List<? extends Object> listObject) {
		this.listObject = listObject;
	}
	public List<Map<String, Object>> getListMap() {
		return listMap;
	}
	public void setListMap(List<Map<String, Object>> listMap) {
		this.listMap = listMap;
	}
	
}
