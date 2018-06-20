package com.service.serviceImpl;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.sun.mail.util.MailSSLSocketFactory;
@SuppressWarnings("unchecked")
@Service
public class QQemailService {
	private static String userAddr="2316125104@qq.com";//发送的邮箱地址
	private static String userSecurity="fqyaynkjmglyebgi";//授权码
	/**
	 * 
	 * @param email 邮箱地址
	 * @param title	邮件标题
	 * @param text	邮件内容
	 * @throws MessagingException
	 * @throws GeneralSecurityException
	 */
	public static String emit(String data) throws MessagingException, GeneralSecurityException {
		HashMap<String,Object> map = JSON.parseObject(data,HashMap.class);
		String title=map.get("title").toString();
		String text =map.get("text").toString();
		String email =map.get("email").toString();
		
		Properties props = new Properties();

		// 开启debug调试
		props.setProperty("mail.debug", "true");
		// 发送服务器需要身份验证
		props.setProperty("mail.smtp.auth", "true");
		// 设置邮件服务器主机名
		props.setProperty("mail.host", "smtp.qq.com");
		// 发送邮件协议名称
		props.setProperty("mail.transport.protocol", "smtp");

		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.socketFactory", sf);

		Session session = Session.getInstance(props);

		Message msg = new MimeMessage(session);
		msg.setSubject(title);
		msg.setText(text);
		msg.setFrom(new InternetAddress(userAddr));

		Transport transport = session.getTransport();
		transport.connect("smtp.qq.com", userAddr, userSecurity);

		transport.sendMessage(msg, new Address[] { new InternetAddress(email) });
		transport.close();
		return JSON.toJSONString("success");

	}
}
