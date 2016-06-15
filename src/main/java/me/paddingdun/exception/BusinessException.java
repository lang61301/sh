package me.paddingdun.exception;

/**
 * 
 * @author paddingdun
 *
 * 2016年6月15日
 * @since 1.0
 * @version 1.0
 */
public class BusinessException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 错误码;
	 */
	private int errorCode;

	/**
	 * @param message
	 */
	public BusinessException(String message) {
		this(IErrorCode.UNKNOW_EXCEPTION, message);
	}
	
	public BusinessException(int errorCode, String message){
		super(message);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
}
