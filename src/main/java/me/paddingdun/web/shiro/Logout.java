/**
 * 
 */
package me.paddingdun.web.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authc.LogoutFilter;

/**
 * 
 * @author paddingdun
 *
 * 2016年6月14日
 * @since 1.0
 * @version 1.0
 */
public class Logout extends LogoutFilter {

	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		return super.preHandle(request, response);
	}

}
