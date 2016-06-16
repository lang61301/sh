/**
 * 
 */
package me.paddingdun.data.paging;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 分页对象;
 * @author paddingdun
 *
 * 2015年11月16日
 */
public class Paging implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	
	/**
	 * datatables 查询参数;
	 */
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
