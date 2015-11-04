/**
 * 
 */
package me.paddingdun.web.filter.login;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

import me.paddingdun.web.login.LoginUser;
import me.paddingdun.web.util.SessionHelper;

/**
 * 用户登录filter
 * @author paddingdun
 *
 * 2015年11月2日
 */
public class LoginFilter implements Filter {
	
	/**
	 * LoginFilter 日志变量;
	 */
	private final static Logger logger = Logger.getLogger(LoginFilter.class);


	
	public static String loginUrl;
	private Set<String> excludeUrl;

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * 1.是否是排除url;
	 * 2.判断session是否存在该用户;
	 * 3.
	 */
	public void doFilter(ServletRequest r, ServletResponse p, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)r;
		HttpServletResponse response = (HttpServletResponse)p;
		String reqURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		if (logger.isDebugEnabled()) {
			logger.debug("LoginFilter: access url: " + reqURI);
		}
		if(!excludeUrl.isEmpty()){
			for(String eu : excludeUrl){
				if(reqURI.equals(contextPath + eu)){
					if (logger.isDebugEnabled()) {
						logger.debug("LoginFilter: the url in exclude url: " + (contextPath + eu));
					}
					chain.doFilter(r, p);
					return;
				}
			}
		}
		
		//判断用户是否登录;
		LoginUser loginUser = SessionHelper.loginUser(request);
		if(loginUser == null){
			
			if (logger.isDebugEnabled()) {
				logger.debug("LoginFilter: the user not login: " + reqURI + " , redirect:" + (contextPath + loginUrl));
			}
			
			//重新登录;
			response.sendRedirect(contextPath + loginUrl);
			return;
		}
		
		//如果没有这句话将会终止filter流链;
		chain.doFilter(r, p);
	}
	
	public static void main(String[] args) {
//		MockServletContext sc = new MockServletContext();
//		sc.setContextPath("ssh2");
//		MockHttpServletRequest request = new MockHttpServletRequest(sc);
//		request.setMethod("get");
//		System.out.println(request.getRequestURI());
//		System.out.println(request.getContextPath());
		
	}

	/**
	 * 获取初始化参数;
	 */
	public void init(FilterConfig fc) throws ServletException {
		//获取登录url;
		String lu_init_param  = fc.getInitParameter("loginUrl");
		
		//排除验证url;
		String eu_init_param  = fc.getInitParameter("excludeUrl");
		
		/**
		 * 登录url;
		 */
		if(StringUtils.isNotBlank(lu_init_param)){
			String lu = lu_init_param.trim();
			if(!lu.startsWith("/")){
				lu = "/" + lu;
			}
			loginUrl = lu;
			
			if (logger.isDebugEnabled()) {
				logger.debug(String.format("LoginFilter: web.xml => loginFilter => loginUrl [%s] !", loginUrl));
			}
		}else{
			if(logger.isEnabledFor(Level.WARN)){
				logger.warn("LoginFilter: web.xml => loginFilter => loginUrl is empty!");
			}
		}
		
		/**
		 * 排除url;
		 */
		excludeUrl = new HashSet<String>();
		if(StringUtils.isNotBlank(eu_init_param)){
			String eu_str = eu_init_param.trim();
			String[] eus = eu_str.split(",");
			
			for(String e : eus){
				String eu = e.trim();
				if(StringUtils.isNotBlank(eu)){
					if(!eu.startsWith("/")){
						eu = "/" + eu;
					}
					excludeUrl.add(eu);
				}
			}
			if (logger.isDebugEnabled()) {
				logger.debug(String.format("LoginFilter: web.xml => loginFilter => excludeUrl [%s] !", eu_init_param));
			}
		}else{
			if (logger.isDebugEnabled()) {
				logger.debug("LoginFilter: web.xml => loginFilter => excludeUrl is empty !");
			}
		}
	}

}
