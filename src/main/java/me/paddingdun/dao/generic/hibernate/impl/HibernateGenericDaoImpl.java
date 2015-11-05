package me.paddingdun.dao.generic.hibernate.impl;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.dialect.Dialect;
import org.hibernate.impl.SessionImpl;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import me.paddingdun.dao.generic.hibernate.IHibernateGenericDao;
import me.paddingdun.data.paging.IDataCollection;
import me.paddingdun.data.paging.impl.DefaultListDataCollection;

/**
 * hibernate dao 泛型默认实现;
 * 
 * @author paddingdun
 *
 * @param <T>
 *            2015年10月28日
 */
public abstract class HibernateGenericDaoImpl extends HibernateTemplate implements IHibernateGenericDao {
	
	public <A> List<A> findObjects(String hql){
		return findObjects(hql, null);
	}
	
	public <A> List<A> findObjects(String hql, Map<String, Object> paramAndValue){
		Query query = getSession ().createQuery (hql);
		setQueryParameters (query, paramAndValue);
        return query.list();
	}

	public List<Map<String, Object>> query(String hql) {
		return query(hql, null);
	}

	public List<Map<String, Object>> query(String hql, Map<String, Object> paramAndValue) {
		// TODO Auto-generated method stub
		Query query = getSession ().createQuery (hql);
		setQueryParameters (query, paramAndValue);
        return query.list();
	}
	
	public <A> IDataCollection<A> queryPaging(String hql, Map<String, Object> paramAndValue, int page, int pageSize) {
		return this.queryPaging(false, hql, paramAndValue, page, pageSize);
	}

	public <A> IDataCollection<A> queryPaging(boolean flag, String hql, Map<String, Object> paramAndValue, int page, int pageSize) {
		// TODO Auto-generated method stub
		int p = hql.toLowerCase ().indexOf (" from ");
        int p2 = hql.toLowerCase ().indexOf (" order by ");
        String s;
        if (p2 < 0)
            s = "SELECT COUNT(*) FROM " + hql.substring (p + " from ".length ());
        else
            s = "SELECT COUNT(*) FROM " + hql.substring (p + " from ".length (), p2);
        Query query = getSession ().createQuery (s);
        setQueryParameters (query, paramAndValue);
        Matcher m = GROUP_BY.matcher (s);
        List list = query.list ();
        int count;
        if (flag)
            count = list.size ()  > 0 ? ((Number) list.get (0)).intValue () : 0;
        else
            count = m.find () ? list.size () :
                list.size ()  > 0 ? ((Number) list.get (0)).intValue () : 0;
        DefaultListDataCollection<A> c = new DefaultListDataCollection<A> ();
        c.setTotal (count);
        if (count == 0) return c;

        query = getSession ().createQuery (hql);
        setQueryParameters (query, paramAndValue);
        query.setFirstResult ((page - 1) * pageSize);
        query.setMaxResults (pageSize);
        c.setData (query.list ());
        return c;
	}

	public List<Map<String, Object>> queryNativeSql(String sql) {
		// TODO Auto-generated method stub
		SQLQuery query = getSession ().createSQLQuery (sql);
        ResultTransformer rtf = Transformers.ALIAS_TO_ENTITY_MAP;
        query.setResultTransformer (rtf);
        return query.list();
	}

	public List<Map<String, Object>> queryNativeSql(String sql, Map<String, Object> paramAndValue) {
		// TODO Auto-generated method stub
		SQLQuery query = getSession ().createSQLQuery (sql);
        ResultTransformer rtf = Transformers.ALIAS_TO_ENTITY_MAP;
        query.setResultTransformer (rtf);
        setQueryParameters (query, paramAndValue);
        return query.list();
	}

	public IDataCollection<Map<String, Object>> queryPagingNativeSql(String sql, Map<String, Object> paramAndValue,
			int page, int pageSize) {
		DefaultListDataCollection<Map<String, Object>> dc = new DefaultListDataCollection<Map<String, Object>> ();
        dc.setPage (page);
        dc.setPageSize (pageSize);
        String count_sql = "SELECT COUNT(*) FROM (" + sql + ")";
        
        Dialect dialect = ((SessionImpl)this.getSession()).getFactory().getDialect();
        String dbType = dialect.getClass ().getName ().toLowerCase ();
        if (dbType.contains ("postgres")) {
            count_sql += " as _count";
        }

        int count = executeNativeScale (count_sql, paramAndValue).intValue ();
        dc.setTotal(count);
        if (count == 0) return dc;
        SQLQuery query = getSession ().createSQLQuery (sql);

        int start = (page - 1) * pageSize;
        query.setFirstResult (start);
        query.setMaxResults (pageSize);
        ResultTransformer rtf = Transformers.ALIAS_TO_ENTITY_MAP;
        query.setResultTransformer (rtf);
        setQueryParameters (query, paramAndValue);
        List list = query.list ();
        dc.setData (list);
        return dc;
	}

	public Number executeScale(String hql, Map<String, Object> paramAndValue) {
		// TODO Auto-generated method stub
		Query query = getSession ().createQuery(hql);
        setQueryParameters (query, paramAndValue);
        List list = query.list ();
        return list.size () == 0 ? 0 : (Number) list.get (0);
	}

	public Number executeNativeScale(String sql, Map<String, Object> paramAndValue) {
		Query query = getSession ().createSQLQuery (sql);
        setQueryParameters (query, paramAndValue);
        List list = query.list ();
        return list.size () == 0 ? 0 : (Number) list.get (0);
	}

	public int executeUpdate(String hql) {
		// TODO Auto-generated method stub
		Query query = getSession ().createQuery(hql);
		return query.executeUpdate();
	}

	public int executeUpdate(String hql, Map<String, Object> paramAndValue) {
		// TODO Auto-generated method stub
		Query query = getSession ().createQuery(hql);
		setQueryParameters (query, paramAndValue);
		return query.executeUpdate();
	}

	public int executeUpdateNative(String sql) {
		// TODO Auto-generated method stub
		Query query = getSession ().createSQLQuery(sql);
		return query.executeUpdate();
	}

	public int executeUpdateNative(String sql, Map<String, Object> paramAndValue) {
		// TODO Auto-generated method stub
		Query query = getSession ().createSQLQuery(sql);
		setQueryParameters (query, paramAndValue);
		return query.executeUpdate();
	}

	
	protected static final Pattern GROUP_BY = Pattern.compile("\\s+GROUP\\s+BY\\s+",
			Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);

	protected Query buildQuery(final String hql, int page, int pageSize, Map<String, Object> map) {
		Query query = this.execute(new HibernateCallback<Query>() {

			public Query doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				return session.createQuery(hql);
			}
		});

		setQueryParameters(query, map);

		if (page != -1 && pageSize != -1) {
			int first = (page - 1) * pageSize;
			query.setFirstResult(first);
			query.setMaxResults(pageSize);
		}
		return query;
	}

	protected int getCount(final String hql, Map<String, Object> map) {
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT count(*) FROM (").append(hql).append(") AS t");

		Query query = this.execute(new HibernateCallback<Query>() {

			public Query doInHibernate(Session session) throws HibernateException, SQLException {
				return session.createQuery(hql);
			}
		});
		setQueryParameters(query, map);

		List list = query.list();

		Matcher m = GROUP_BY.matcher(builder);
		return m.find() ? list.size() : list.size() > 1 ? list.size() : ((Number) list.get(0)).intValue();
	}

	protected void setQueryParameters(Query query, Map<String, Object> map) {
		if(map != null && !map.isEmpty())
			for (String name : map.keySet()) {
				Object value = map.get(name);
				if (isArray(value)) {
					Object[] array = toArray(value);
					query.setParameterList(name, array);
				} else if (value instanceof Collection) {
					query.setParameterList(name, (Collection) value);
				} else
					query.setParameter(name, map.get(name));
			}
	}

	private boolean isArray(Object o) {
		if (o == null)
			return false;
		Class<?> c = o.getClass();
		return c.isArray();
	}

	private Object[] toArray(Object o) {
		if (!isArray(o))
			return new Object[] { o };
		if (o instanceof long[]) {
			long[] arr = (long[]) o;
			Long[] ret = new Long[arr.length];
			for (int i = 0; i < arr.length; i++)
				ret[i] = arr[i];
			return ret;
		}
		if (o instanceof int[]) {
			int[] arr = (int[]) o;
			Integer[] ret = new Integer[arr.length];
			for (int i = 0; i < arr.length; i++)
				ret[i] = arr[i];
			return ret;
		}
		if (o instanceof byte[]) {
			byte[] arr = (byte[]) o;
			Byte[] ret = new Byte[arr.length];
			for (int i = 0; i < arr.length; i++)
				ret[i] = arr[i];
			return ret;
		}
		if (o instanceof short[]) {
			short[] arr = (short[]) o;
			Short[] ret = new Short[arr.length];
			for (int i = 0; i < arr.length; i++)
				ret[i] = arr[i];
			return ret;
		}
		if (o instanceof char[]) {
			char[] arr = (char[]) o;
			Character[] ret = new Character[arr.length];
			for (int i = 0; i < arr.length; i++)
				ret[i] = arr[i];
			return ret;
		}
		if (o instanceof boolean[]) {
			boolean[] arr = (boolean[]) o;
			Boolean[] ret = new Boolean[arr.length];
			for (int i = 0; i < arr.length; i++)
				ret[i] = arr[i];
			return ret;
		}
		if (o instanceof float[]) {
			float[] arr = (float[]) o;
			Float[] ret = new Float[arr.length];
			for (int i = 0; i < arr.length; i++)
				ret[i] = arr[i];
			return ret;
		}
		if (o instanceof double[]) {
			double[] arr = (double[]) o;
			Double[] ret = new Double[arr.length];
			for (int i = 0; i < arr.length; i++)
				ret[i] = arr[i];
			return ret;
		}
		return (Object[]) o;
	}

	

}
