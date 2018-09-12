package com.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

import javax.crypto.Cipher;

import sun.misc.BASE64Decoder;

public class EncryptByRSA {
	/**
	 * 使用RSA私钥加密数据
	 * 
	 * @param pubKeyInByte
	 *            打包的byte[]形式私钥
	 * @param data
	 *            要加密的数据
	 * @return 加密数据
	 */
	public static byte[] encryptByRSA1(String privKeyInByte, byte[] data) {
		try {
			//PKCS8EncodedKeySpec priv_spec = new PKCS8EncodedKeySpec(
			//		privKeyInByte);
			KeyFactory mykeyFactory = KeyFactory.getInstance("RSA");
			PrivateKey privKey = getPrivateKey(privKeyInByte); //mykeyFactory.generatePrivate(priv_spec);
			Cipher cipher = Cipher.getInstance(mykeyFactory.getAlgorithm());
			cipher.init(Cipher.ENCRYPT_MODE, privKey);
			return cipher.doFinal(data);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}

	}
	//String 转换为 PrivateKey对象
	@SuppressWarnings("restriction")
	public static PrivateKey getPrivateKey(String key) throws Exception {
		byte[] keyBytes;
		keyBytes = (new BASE64Decoder()).decodeBuffer(key);
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
		return privateKey;
	}
	//读取私钥文件
	@SuppressWarnings("unused")
	private static String readFileToString(String filepath) throws IOException  {
		StringBuilder sb = new StringBuilder();
		String s ="";
		BufferedReader br = new BufferedReader(new FileReader(filepath));

		while( (s = br.readLine()) != null) {
			sb.append(s + "\n");
		}

		br.close();
		String str = sb.toString();


		return str;
	}
	//字符串转Byte[]
	public static byte[] strToByteArray(String str) {
		if (str == null) {
			return null;
		}
		byte[] byteArray = str.getBytes();
		return byteArray;
	}
}
