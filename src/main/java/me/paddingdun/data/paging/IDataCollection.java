package me.paddingdun.data.paging;

import java.util.List;

/**
 * 分页接口;
 * @author paddingdun
 *
 * 2015年10月28日
 */
public interface IDataCollection<T> {

	/**
	 * 当前第几页;
	 * @return
	 */
	Integer getPage();
	
	/**
	 * 每页行数;
	 * @return
	 */
	Integer getPageSize();
	
	/**
	 * 总记录数;
	 * @return
	 */
	Integer getTotal();
	
	/**
	 * 分页记录;
	 * @return
	 */
	List<T> getData();
}
