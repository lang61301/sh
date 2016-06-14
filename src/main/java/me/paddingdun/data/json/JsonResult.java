package me.paddingdun.data.json;

import java.io.Serializable;

/**
 * 返回json结果集;
 * @author paddingdun
 *
 * 2015年10月28日
 */
public class JsonResult<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer status;
	
	private String message;
	
	private T data;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
