package me.paddingdun.exception;

/**
 * 异常管理;
 * @author paddingdun
 *
 * 2015年11月2日
 */
public class CommonException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * -9000:无法分类异常;
	 */
	private static final String ERROR_CODE_NOCLASS = "-9000"; 
	
	/**
	 * 异常编号;
	 */
	private String errorCode;
	
	/**
	 * 附加信息,可以null;
	 */
	private Object attachment;
	
	public CommonException(String message){
		this(ERROR_CODE_NOCLASS, message);
	}
	
	public CommonException(String message, Object attachment){
		this(ERROR_CODE_NOCLASS, message, null, attachment);
	}
	
	public CommonException(String errorCode, String message){
		this(errorCode, message, null, null);
	}
	
	public CommonException(String errorCode, String message, Object attachment){
		this(errorCode, message, null, attachment);
	}
	
	public CommonException(String errorCode, String message, Throwable cause, Object attachment){
		super(message, cause);
		this.errorCode = errorCode;
		this.attachment = attachment;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public Object getAttachment() {
		return attachment;
	}

	public void setAttachment(Object attachment) {
		this.attachment = attachment;
	}
	
	public static void main(String[] args) {
		CommonException ce = new CommonException("错误");
		
		System.out.println(ce instanceof Throwable);
	}
}
