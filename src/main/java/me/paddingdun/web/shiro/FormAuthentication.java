/**
 * 
 */
package me.paddingdun.web.shiro;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import com.google.gson.Gson;

import me.paddingdun.data.json.JsonResult2;
import me.paddingdun.exception.IErrorCode;
import me.paddingdun.util.GsonHelper;
import me.paddingdun.web.util.WebHelper;

/**
 * 
 * @author paddingdun
 *
 * 2016年6月14日
 * @since 1.0
 * @version 1.0
 */
public class FormAuthentication extends FormAuthenticationFilter {

	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (isLoginRequest(request, response)) {
            if (isLoginSubmission(request, response)) {
                return executeLogin(request, response);
            } else {
                //allow them to see the login page ;)
                return true;
            }
        } else {
        	HttpServletRequest res = (HttpServletRequest)request;
        	HttpServletResponse rp = (HttpServletResponse)response;
        	if(WebHelper.isAjaxHttprequest(res)){
        		Gson gson = GsonHelper.create();
        		JsonResult2<Void>  jr = new JsonResult2<Void>();
        		jr.setStatus(IErrorCode.SESSION_TIMEOUT);
        		WebHelper.rtnAjax(rp, gson, jr);
        	}else{
        		//不记录登录前访问的页面
//              saveRequestAndRedirectToLogin(request, response);
        		redirectToLogin(request, response);
        	}
            return false;
        }
    }

	@Override
	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        String username = WebUtils.getCleanParam(request, "loginName");
        String password = WebUtils.getCleanParam(request, "password");
        
        UserToken token = new UserToken();
        token.setUsername(username);
        token.setPassword(password.toCharArray());
        return token;
    }
	
	@Override
	protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		if(e instanceof UnknownAccountException){
			request.setAttribute("error", "用户名不对");
		}else if (e instanceof IncorrectCredentialsException){
			request.setAttribute("error", "密码不对");
		}
		return true;
	}

	@Override
	public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
		boolean a = isAccessAllowed(request, response, mappedValue) ;
		if(a && pathsMatch(getLoginUrl(), request)){
			try {
				WebUtils.issueRedirect(request, response, this.getSuccessUrl());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return false;
		}
		return a || onAccessDenied(request, response, mappedValue);
	}
}
