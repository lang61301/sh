package me.paddingdun.data.paging;

import java.util.List;

/**
 * 分页接口;
 * @author paddingdun
 *
 * 2015年10月28日
 */
public interface IDataCollection<T> {

	Integer getStart();
	
	Integer getLength();
	
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
	
	
	void setData(List<T> data);
	
	List<T> getListproNames();
}
