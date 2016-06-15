/**
 * 
 */
package me.paddingdun.component;

import org.apache.log4j.Logger;

import me.paddingdun.component.log.log4j.ILog;
import me.paddingdun.component.log.log4j.ILogConstant;

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

	public static void saveOpLog(ILog log){
		logger.fatal(log);
	}

}
