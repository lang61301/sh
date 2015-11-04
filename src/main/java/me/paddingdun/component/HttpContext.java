/**
 * 
 */
package me.paddingdun.component;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 当前web上下文环境;
 * @author paddingdun
 *
 * 2015年11月3日
 */
public class HttpContext {

	/**
	 * 基于web.xml中
	 * 	<listener>  
     *  	<listener-class>org.springframework.web.context.request.RequestContextListener</listener-class>  
	 *  </listener>
	 *  获取当前线程的request;  
	 * @return
	 */
	public static HttpServletRequest getRequest(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		return request;
	}
}
