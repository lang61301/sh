/**
 * 
 */
package me.paddingdun.exception;

/**
 * @author paddingdun
 *
 * 2015年11月26日
 */
public interface IErrorCode {

	Integer SUCCESS = 0;
	Integer UNKNOW_EXCEPTION = -9999;
	Integer NETWORK_EXCEPTION = -3;
	Integer JSON_EXCEPTION = -2;
	Integer TIME_OUT = -1;
	Integer TOKEN_EXPIRED = 17;
	
	/**
	 * session超时;
	 */
	Integer SESSION_TIMEOUT = -9998;
	
	/**
	 * 无系统访问权限;
	 */
	Integer NO_SYS_ACCESS_AUTHORIZATION = -1000;

}
