package me.paddingdun.data.json;

import java.io.Serializable;

import me.paddingdun.exception.IErrorCode;


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

	private Integer status = IErrorCode.SUCCESS;
	
	private String msg;
	
	private T data;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
