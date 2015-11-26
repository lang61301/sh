/**
 * 
 */
package me.paddingdun.component.factory;


import org.apache.log4j.Logger;

import me.paddingdun.component.MessageHolder;
import me.paddingdun.exception.BusinessException;

/**
 * 异常工厂类;
 * @author paddingdun
 *
 * 2015年11月3日
 */
public class BusinessExceptionFactory {
	
	/**
	 * CommonExceptionFactory 日志变量;
	 */
	private final static Logger logger = Logger.getLogger(BusinessExceptionFactory.class);


	
	/**
	 * 创建异常;
	 * @param errorCode
	 * @param message
	 * @return
	 */
	public static BusinessException createCommonException(Integer errorCode, String message){
		if (logger.isDebugEnabled()) {
			logger.debug(String.format("CommonExceptionFactory.createCommonException:errorCode[%s], message[%s]", errorCode, message));
		}
		BusinessException exception = new BusinessException(errorCode, message);
		return exception;
	}
	
	/**
	 * 根据国际化code创建异常;
	 * @param errorCode
	 * @param messageCode
	 * @return
	 */
	public static BusinessException createCommonException2(Integer errorCode, String messageCode){
		return createCommonException2(errorCode, messageCode, new Object[0]);
	}
	
	/**
	 * 根据国际化code创建异常;
	 * @param errorCode
	 * @param messageCode
	 * @param obj
	 * @return
	 */
	public static BusinessException createCommonException2(Integer errorCode, String messageCode, Object[] obj){
		if (logger.isDebugEnabled()) {
			logger.debug(String.format("CommonExceptionFactory.createCommonException2:errorCode[%s], messgeCode[%s]", errorCode, messageCode));
		}
		String message = MessageHolder.getMessage(messageCode, obj);
		return createCommonException(errorCode, message);
	}

}
