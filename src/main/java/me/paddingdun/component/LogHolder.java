/**
 * 
 */
package me.paddingdun.component;

import org.apache.log4j.Logger;

import me.paddingdun.component.log.log4j.ILogConstant;
import me.paddingdun.component.log.log4j.Log;
import me.paddingdun.data.SysLog;

/**
 * @author paddingdun
 *
 * 2015年11月3日
 */
public class LogHolder {

	/**
	 * LogHolder 日志变量;
	 */
	private final static Logger logger = Logger.getLogger(ILogConstant.CATEGORY_NAME);

	
	public static void saveOpLog(String message, Integer status){
		SysLog log = new SysLog();
		log.setLogMessage(message);
		log.setStatus(status);
		logger.fatal(log);
	}
	
	public static void saveOpLog(String message){
		saveOpLog(message, ILogConstant.LOG_STATUS_SUCCESS);
	}
	
	public static void saveFailOpLog(String message){
		saveOpLog(message, ILogConstant.LOG_STATUS_FAIL);
	}
	
	public static void saveOpLog(Log log){
		logger.fatal(log);
	}

}
