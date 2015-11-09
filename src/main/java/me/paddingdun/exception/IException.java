/**
 * 
 */
package me.paddingdun.exception;

/**
 * 异常常量;
 * @author paddingdun
 *
 * 2015年11月2日
 */
public interface IException {

	String LOGIN_USER_EMPTY 		= "1000";
	String LOGIN_PASSWORD_EMPTY		= "1001";
	String LOGIN_USER_NOT_EXIST		= "1002";
	String LOGIN_PASSWORD_ERROR		= "1003";
	String LOGIN_CODE_EMPTY			= "1004";
	String LOGIN_CODE_TIMEOUT		= "1005";
	String LOGIN_CODE_ERROR			= "1006";
	String LOGIN_CODE_UNGEN			= "1007";
	String LOGIN_UNKNOW				= "1099";
}
