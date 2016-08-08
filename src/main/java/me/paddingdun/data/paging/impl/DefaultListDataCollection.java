package me.paddingdun.data.paging.impl;

import java.util.List;

import me.paddingdun.data.paging.IDataCollection;


/**
 * 分页集合默认实现;
 * @author paddingdun
 *
 * 2015年10月28日
 */
public class DefaultListDataCollection<T> implements IDataCollection<T> {
	
	private Integer start;
	private Integer length;
	private Integer total;
	
	private List<T> data;
	private List<T> listproNames;

	
	public List<T> getListproNames() {
		return listproNames;
	}

	public void setListproNames(List<T> listproNames) {
		this.listproNames = listproNames;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
}
