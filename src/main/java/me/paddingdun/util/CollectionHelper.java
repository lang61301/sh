/**
 * 
 */
package me.paddingdun.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

import com.google.gson.annotations.SerializedName;

import me.paddingdun.data.paging.IDataCollection;
import me.paddingdun.data.paging.impl.DefaultListDataCollection;

/**
 * @author paddingdun
 *
 * 2015年12月16日
 */
public class CollectionHelper {

	/**
	 * 将对象转成map; key:value{propertyName:propertyValue}
	 * @param t
	 * @return
	 */
	public static <T> void object2Map(T t, Map<String, Object> result){
		if(t != null){
			PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(t);
			for (int i = 0; i < pds.length; i++) {
				PropertyDescriptor pd = pds[i];
				String pName = pd.getName();
				try {
					result.put(pName, PropertyUtils.getProperty(t, pName));
				} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static <T> IDataCollection<Map<String, Object>> object2Map(IDataCollection<T> t){
		DefaultListDataCollection<Map<String, Object>> result = new DefaultListDataCollection<Map<String, Object>>();
		if(t != null){
			result.setLength(t.getLength());
			result.setStart(t.getStart());
			result.setTotal(t.getTotal());
			List<Map<String, Object>> empty = Collections.emptyList();
			
			List<T> data = t.getData();
			if(data.isEmpty()){
				result.setData(empty);
			}else{
				Field[] fs = t.getData().get(0).getClass().getDeclaredFields();
				List<Map<String, Object>> tmp = new ArrayList<Map<String, Object>>();
				for (T t1 : data) {
					Map<String, Object> m = new LinkedHashMap<String, Object>();
					for (Field f : fs) {
						SerializedName sn = f.getAnnotation(SerializedName.class);
						if(sn != null)
							try {
								f.setAccessible(true);
								m.put(f.getName(), f.get(t1));
							} catch (Exception e) {
								e.printStackTrace();
							} 
					}
					tmp.add(m);
				}
				result.setData(tmp);
			}
		}
		return result;
	}
	
	/**
	 * 复制非空属性的值;
	 * @param src 源目标;
	 * @param dest 目的目标;
	 */
	public static void copyNonNullProperty(Object src, Object dest){
		if(src == null
				|| dest == null)
			return;
		PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(src);
		for (int i = 0; i < pds.length; i++) {
			PropertyDescriptor pd = pds[i];
			String pName = pd.getName();
			try {
				Object value = PropertyUtils.getProperty(src, pName);
				if(value != null){
					PropertyUtils.setProperty(dest, pName, value);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
