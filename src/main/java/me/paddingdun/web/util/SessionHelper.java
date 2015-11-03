/**
 * 
 */
package me.paddingdun.web.util;

import static me.paddingdun.web.util.IAppConstant.USER_SESSION_KEY;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import me.paddingdun.web.login.LoginUser;

/**
 * @author paddingdun
 * session 工具类
 * 2015年11月2日
 */
public class SessionHelper {
	/**
	 * SessionHelper 日志变量;
	 */
	private final static Logger logger = Logger.getLogger(SessionHelper.class);



	public static LoginUser loginUser(HttpServletRequest request){
		return loginUser(request.getSession());
	}
	
	public static LoginUser loginUser(HttpSession session){
		LoginUser loginUser = (LoginUser)attr(session, USER_SESSION_KEY);
		return loginUser;
	}
	
	public static void attr(HttpServletRequest request, String key, Object obj){
		request.setAttribute(key, obj);
	}
	
	public static void attr(HttpSession session, String key, Object obj){
		session.setAttribute(key, obj);
	}
	
	public static Object attr(HttpServletRequest request, String key){
		return request.getAttribute(key);
	}
	
	public static Object attr(HttpSession session, String key){
		return session.getAttribute(key);
	}
	
	public static void removeAttr(HttpServletRequest request, String key){
		request.removeAttribute(key);
	}
	
	public static void removeAttr(HttpSession session, String key){
		session.removeAttribute(key);
	}
}
