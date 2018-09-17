package com.entity;

import java.util.Map;

public class Photo {
	private Integer code;

    private String message;

    private Map<String, Object> result;

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getResult() {
        return this.result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }
    private static Photo Photo;
    /**
     * 返回结果
     * @param code
     * @param message
     * @param token
     * @param map
     * @return
     */
    public static Photo result(int code, String message, Map<String, Object> map){
    	Photo = new Photo();
    	Photo.setCode(code);
    	Photo.setMessage(message);
    	Photo.setResult(map);
        return Photo;
    }

    public static Photo result(int code, String message){
    	Photo = new Photo();
    	Photo.setCode(code);
    	Photo.setMessage(message);
        return Photo;
    }

    public Photo() {}
}
