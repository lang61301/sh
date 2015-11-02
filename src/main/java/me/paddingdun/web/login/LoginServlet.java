/**
 * 
 */
package me.paddingdun.web.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import me.paddingdun.service.user.IUserService;

/**
 * 未完成, 修改为spring Controller ;
 * 登录servlet;
 * 
 * @author paddingdun
 *
 * 2015年11月2日
 */
public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * LoginServlet 日志变量;
	 */
	private final static Logger logger = LoggerFactory.getLogger(LoginServlet.class);

	private String successUrl;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String str_username = request.getParameter("username");
		String str_password = request.getParameter("password");
		
		IUserService userService = WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getBean(IUserService.class);
		
		
		
	}

	@Override
	public void init() throws ServletException {
		//成功后跳转url;
		String su_init_param  = getInitParameter("successUrl");
		
		/**
		 * 登录url;
		 */
		if(StringUtils.isNotBlank(su_init_param)){
			String su = su_init_param.trim();
			if(!su.startsWith("/")){
				su = "/" + su;
			}
			successUrl = su;
			
			if (logger.isDebugEnabled()) {
				logger.debug(String.format("LoginServlet: web.xml => loginServlet => successUrl [%s] !", successUrl));
			}
		}else{
			if(logger.isWarnEnabled()){
				logger.warn("LoginServlet: web.xml => loginServlet => successUrl is empty!");
			}
		}
	}

	

}
