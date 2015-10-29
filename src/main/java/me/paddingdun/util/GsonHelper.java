/**
 * 
 */
package me.paddingdun.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Gson 辅助类;
 * @author paddingdun
 *
 * 2015年10月28日
 */
public class GsonHelper {

	
	public static Gson gson(){
		return gson(false);
	}
	
	public static Gson gson(boolean exposeAnnotationOnly){
		GsonBuilder gb = new GsonBuilder();
		gb.setDateFormat(DateHelper.DATE_FMT_DEFAULT);
		if(exposeAnnotationOnly){
			gb.excludeFieldsWithoutExposeAnnotation();
		}
		return gb.create();
	}
}
