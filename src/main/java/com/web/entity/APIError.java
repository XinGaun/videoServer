package com.web.entity;

import java.io.IOException;

public class APIError {
	private String errorCode = "0";
	private String errorMsg;
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	public APIError() {}
	
	public APIError(Exception e) {
		if(e instanceof IOException) errorCode = "2";
		else errorCode = "1";
		
		if(e instanceof NullPointerException) errorMsg = "something is missing.";
		else errorMsg = e.getMessage();
	}
	
}
