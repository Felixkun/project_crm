package com.itheima.crm.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.UUID;

public class MyStringUtils {

	/**
	 * ���MD5���ܺ�����
	 * @param value ����
	 * @return ����
	 */
	public static String getMD5Value(String value){
		try {
			//1.���jdk�ṩ����ϢժҪ�㷨������
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			//2.���ܵĽ����10����
			byte[] md5ValueByteArray = messageDigest.digest(value.getBytes());
			//3.��10����ת��Ϊ16����
			BigInteger bigInteger = new BigInteger(1, md5ValueByteArray);
			
			return bigInteger.toString(16);
		} catch (Exception e) {
			 throw new RuntimeException(e);
		}
	}
	
	
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
}
