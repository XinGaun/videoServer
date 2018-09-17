package com.util;

public class UUID {
	/**
	 * 生成随机字符串
	 * @return
	 */
	public static String GetGUID()
	{

		return java.util.UUID.randomUUID().toString().replace("-", "");

	}
	public static void main(String[] args) {
		for(int i=0;i<10;i++) {
			System.out.println(GetGUID());
		}
		
	}
}
