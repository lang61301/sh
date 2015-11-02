package me.paddingdun.dao.generic.hibernate;

import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate3.HibernateOperations;

import me.paddingdun.data.paging.IDataCollection;

/**
 * hibernate 泛型接口;
 * @author paddingdun
 *
 * @param <T>
 * 2015年10月28日
 */
public interface IHibernateGenericDao extends HibernateOperations {

	<A> List<A> findObjects(String hql);
	
	<A> List<A> findObjects(String hql, Map<String, Object> paramAndValue);
	
	List<Map<String, Object>> query(String hql);
	
	List<Map<String, Object>> query(String hql, Map<String, Object> paramAndValue);
	
	<A> IDataCollection<A> queryPaging(String hql, Map<String, Object> paramAndValue, int page, int pageSize);
	
	<A> IDataCollection<A> queryPaging(boolean flag, String hql, Map<String, Object> paramAndValue, int page, int pageSize);
	
	
	
	List<Map<String, Object>> queryNativeSql(String sql);
	
	List<Map<String, Object>> queryNativeSql(String sql, Map<String, Object> paramAndValue);
	
	IDataCollection<Map<String, Object>> queryPagingNativeSql(String sql, Map<String, Object> paramAndValue, int page, int pageSize);
	
	
	Number executeScale(String hql, Map<String, Object> paramAndValue);
	
	Number executeNativeScale(String sql, Map<String, Object> paramAndValue);
	
	
	int executeUpdate(String hql);
	
	int executeUpdate(String hql, Map<String, Object> paramAndValue);
	
	
	
	int executeUpdateNative(String sql);
	
	int executeUpdateNative(String sql, Map<String, Object> paramAndValue);
	
}
