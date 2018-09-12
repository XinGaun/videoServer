package com.util;

import java.io.IOException;
import java.util.HashMap;

import com.alibaba.fastjson.JSON;
import com.util.BytesToHexFun;
import com.util.EncryptByRSA;
import com.util.HttpReqs;

public class Authentication {
	/**
	 * 
	 * @param TAG 第三方标识符
	 * @param pivStr 私钥字符串
	 * @param port 请求地址
	 * @param hashMap 请求参数
	 * @param str 验证串
	 * @return
	 * @throws IOException
	 */
	public static String HttpPostAuthentication(String TAG,String pivStr,String port,HashMap<String,Object> hashMap,String str) throws IOException {
		//1）根据需要调用的接口，生成如下验证串（所有字母大写）：:third-接口名称-当前日期 
		byte[] strbyte = EncryptByRSA.strToByteArray(str);
		//2)将验证串通过RSA私钥加密
		byte[] result =EncryptByRSA.encryptByRSA1(pivStr,strbyte);
		//3)将加密结果转换为hex字符串（A-F字母大写），作为ThirdPartyToken字段的值。
		String resuStr = BytesToHexFun.bytesToHexFun1(result);
		//4)HTTP post 请求
		//System.out.println(resuStr);
		//System.out.println(port);
		//System.out.println(JSON.toJSONString(hashMap));
		//System.out.println(resuStr);

		String httpResult = HttpReqs.httpRequest(port,"POST",JSON.toJSONString(hashMap),resuStr);
		return httpResult; 		
	}
}
