package me.paddingdun.data.paging;

import java.io.Serializable;

/**
 * paging 对象;
 * @author paddingdun
 *
 * 2015年10月28日
 */
public class Paging implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer page = 1;
	private Integer pageSize = 10;
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
}
