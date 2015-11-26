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

	Integer LOGIN_USER_EMPTY 			= 1000;
	Integer LOGIN_PASSWORD_EMPTY		= 1001;
	Integer LOGIN_USER_NOT_EXIST		= 1002;
	Integer LOGIN_PASSWORD_ERROR		= 1003;
	Integer LOGIN_CODE_EMPTY			= 1004;
	Integer LOGIN_CODE_TIMEOUT			= 1005;
	Integer LOGIN_CODE_ERROR			= 1006;
	Integer LOGIN_CODE_UNGEN			= 1007;
	Integer LOGIN_UNKNOW				= 1099;
}
