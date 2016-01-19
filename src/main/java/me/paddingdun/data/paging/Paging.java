package me.paddingdun.data.paging;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

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
	
	/**
	 * datatables 查询参数;
	 */
	private Integer start = 0;
	private Integer length = 10;

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

	private List<Map<ColumnCriterias, String>> columns;
	private List<Map<OrderCriterias, String>> order;
	private Map<SearchCriterias, String> search;

	public List<Map<ColumnCriterias, String>> getColumns() {
		return columns;
	}

	public void setColumns(List<Map<ColumnCriterias, String>> columns) {
		this.columns = columns;
	}

	public List<Map<OrderCriterias, String>> getOrder() {
		return order;
	}

	public void setOrder(List<Map<OrderCriterias, String>> order) {
		this.order = order;
	}

	public Map<SearchCriterias, String> getSearch() {
		return search;
	}

	public void setSearch(Map<SearchCriterias, String> search) {
		this.search = search;
	}
}
