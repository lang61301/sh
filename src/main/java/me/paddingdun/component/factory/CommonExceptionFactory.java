/**
 * 
 */
package me.paddingdun.component.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.paddingdun.component.MessageHolder;
import me.paddingdun.exception.CommonException;

/**
 * 异常工厂类;
 * @author paddingdun
 *
 * 2015年11月3日
 */
public class CommonExceptionFactory {
	
	/**
	 * CommonExceptionFactory 日志变量;
	 */
	private final static Logger logger = LoggerFactory.getLogger(CommonExceptionFactory.class);

	
	/**
	 * 创建异常;
	 * @param errorCode
	 * @param message
	 * @return
	 */
	public static CommonException createCommonException(String errorCode, String message){
		if (logger.isDebugEnabled()) {
			logger.debug(String.format("CommonExceptionFactory.createCommonException:errorCode[%s], message[%s]", errorCode, message));
		}
		CommonException exception = new CommonException(errorCode, message);
		return exception;
	}
	
	/**
	 * 根据国际化code创建异常;
	 * @param errorCode
	 * @param messageCode
	 * @return
	 */
	public static CommonException createCommonException2(String errorCode, String messageCode){
		return createCommonException2(errorCode, messageCode, new Object[0]);
	}
	
	/**
	 * 根据国际化code创建异常;
	 * @param errorCode
	 * @param messageCode
	 * @param obj
	 * @return
	 */
	public static CommonException createCommonException2(String errorCode, String messageCode, Object[] obj){
		if (logger.isDebugEnabled()) {
			logger.debug(String.format("CommonExceptionFactory.createCommonException2:errorCode[%s], messgeCode[%s]", errorCode, messageCode));
		}
		String message = MessageHolder.getMessage(messageCode, obj);
		return createCommonException(errorCode, message);
	}

}
