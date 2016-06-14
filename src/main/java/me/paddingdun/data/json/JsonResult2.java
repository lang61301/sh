package me.paddingdun.data.json;

import java.io.Serializable;

/**
 * 
 * @author paddingdun
 *
 * @param <T>
 * 2016年1月19日
 */
public class JsonResult2<T> implements Serializable {

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
