package me.paddingdun.exception;

/**
 * 业务异常, 用来提供给用户友好的提示;
 * @author paddingdun
 *
 * 2015年11月2日
 */
public class BusinessException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * -9000:无法分类异常;
	 */
	private static final Integer ERROR_CODE_NOCLASS = -9000; 
	
	/**
	 * 异常编号;
	 */
	private Integer errorCode;
	
	/**
	 * 附加信息,可以null;
	 */
	private Object attachment;
	
	public BusinessException(String message){
		this(ERROR_CODE_NOCLASS, message);
	}
	
	public BusinessException(String message, Object attachment){
		this(ERROR_CODE_NOCLASS, message, null, attachment);
	}
	
	public BusinessException(Integer errorCode, String message){
		this(errorCode, message, null, null);
	}
	
	public BusinessException(Integer errorCode, String message, Object attachment){
		this(errorCode, message, null, attachment);
	}
	
	public BusinessException(Integer errorCode, String message, Throwable cause, Object attachment){
		super(message, cause);
		this.errorCode = errorCode;
		this.attachment = attachment;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public Object getAttachment() {
		return attachment;
	}

	public void setAttachment(Object attachment) {
		this.attachment = attachment;
	}
	
	public static void main(String[] args) {
		BusinessException ce = new BusinessException("错误");
		
		System.out.println(ce instanceof Throwable);
	}
}
