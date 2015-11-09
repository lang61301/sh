/**
 * 
 */
package me.paddingdun.component.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import me.paddingdun.web.util.WebHelper;

/**
 * 异常处理;
 * @author paddingdun
 *
 * 2015年11月5日
 */
public class CustomSimpleMappingExceptionResolver extends SimpleMappingExceptionResolver {

	/**
	 * CustomSimpleMappingExceptionResolver 日志变量;
	 */
	private final static Logger logger = Logger.getLogger(CustomSimpleMappingExceptionResolver.class);

	
	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		// Expose ModelAndView for chosen error view.
		String viewName = determineViewName(ex, request);
		if (viewName != null) {
			//ajax请求异常处理;
			if(WebHelper.isAjaxHttprequest(request)){
				return null;
			}else{
				// Apply HTTP status code for error views, if specified.
				// Only apply it if we're processing a top-level request.
				Integer statusCode = determineStatusCode(request, viewName);
				if (statusCode != null) {
					applyStatusCodeIfPossible(request, response, statusCode);
				}
				return getModelAndView(viewName, ex, request);
			}
		}
		else {
			return null;
		}
	}
	
	

}
