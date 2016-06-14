package me.paddingdun.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;

import me.paddingdun.exception.BusinessException;
import me.paddingdun.web.util.SessionHelper;
import me.paddingdun.web.util.WebHelper;

/**
 * 
 * @author paddingdun
 *
 * 2016年6月14日
 * @since 1.0
 * @version 1.0
 */
public abstract class BaseCtrl {
	
	/**
	 * BaseController 日志变量;
	 */
	private final static Logger logger = Logger.getLogger(BaseCtrl.class);
	
	@ExceptionHandler
	public String exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e){
		//无权限错误;
		if( e instanceof org.apache.shiro.authz.UnauthorizedException){
		}
		if(WebHelper.isAjaxHttprequest(request)){

		}else{
			String message = "发生未知错误,请联系管理员!";
			if(e instanceof BusinessException){
				BusinessException be = (BusinessException)e;
				message = be.getMessage();
			}		  
			SessionHelper.attr(request, "BusinessException", message);
			return "error/errorpage";

		}
		return null;
	}

}
