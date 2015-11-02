package me.paddingdun.web.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import me.paddingdun.data.json.JsonResult;

/**
 * web工具类;
 * @author admin
 *
 */
public class WebHelper {

	/**
	 * 返回ajax请求;
	 * @param response
	 * @param gson
	 * @param jr
	 * @throws IOException
	 */
	public static void rtnAjax(HttpServletResponse response, Gson gson, JsonResult jr)throws IOException{
		response.reset();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.write(gson.toJson(jr));
		
		out.flush();
		out.close();
	}
	
	/**
	 * 判断是否是ajax请求;
	 * @param request
	 * @return
	 */
	public static boolean isAjaxHttprequest(HttpServletRequest request){
		boolean result = false;
		if ("XMLHttpRequest"
	            .equalsIgnoreCase(request
	                    .getHeader("X-Requested-With"))) {//ajax请求;
			result = true;
		}
		return result;
	}
}
