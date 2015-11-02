/**
 * 
 */
package me.paddingdun.util;

import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author paddingdun
 * 加密算法, 安全工具类;
 * 2015年11月2日
 */
public class SecurityHelper {
	
	/**
	 * SecurityHelper 日志变量;
	 */
	private final static Logger logger = LoggerFactory.getLogger(SecurityHelper.class);


	public static String md5Encode(String str) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");

        byte[] byteArray = str.getBytes("UTF-8");
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
	
	public static void main(String[] args) throws Exception{
		System.out.println(md5Encode("admin"));
	}
}
