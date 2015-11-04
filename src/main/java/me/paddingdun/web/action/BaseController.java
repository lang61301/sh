package me.paddingdun.web.action;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author admin
 *
 */
public abstract class BaseController {
	
	/**
	 * BaseController 日志变量;
	 */
	private final static Logger logger = Logger.getLogger(BaseController.class);

	
	/**
	 * 全局异常处理;
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		System.out.println(ex.getClass().getName());
//		ModelAndView model = new ModelAndView("error/generic_error");
//		model.addObject("errMsg", "this is Exception.class");
//
//		return model;
		return null;

	}
}
