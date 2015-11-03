/**
 * 
 */
package me.paddingdun.component;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * @author paddingdun
 *
 * 2015年11月3日
 */
@Component
@Lazy(false)
public class MessageHolder {
	
	/**
	 * MessageHolder 日志变量;
	 */
	private final static Logger logger = LoggerFactory.getLogger(MessageHolder.class);
	
	@Autowired
	private MessageSource messageSource;
	
	private static MessageHolder holder;
	
	@PostConstruct
	public void init(){
		holder = this;
	}
	
	/**
	 * 根据code和参数和默认信息获取国际化信息;
	 * @param code
	 * @param obj
	 * @param defaultMessage
	 * @return
	 */
	public static String getMessage(String code, Object[] obj, String defaultMessage){
		Locale locale = RequestContextUtils.getLocale(HttpContext.getRequest());
		return holder.messageSource.getMessage(code, obj, defaultMessage, locale); 
	}
	
	/**
	 * 根据code和参数获取国际化信息;
	 * @param code
	 * @param obj
	 * @return
	 */
	public static String getMessage(String code, Object[] obj){
		return getMessage(code, obj, null); 
	}
	
	/**
	 * 根据code获取国际化信息;
	 * @param code
	 * @return
	 */
	public static String getMessage(String code){
		return getMessage(code, new Object[0]); 
	}


}
