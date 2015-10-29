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
	
	private Integer page;
	private Integer pageSize;
	private Integer total;
	
	private List<T> data;


	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
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
