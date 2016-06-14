/**
 * 
 */
package me.paddingdun.web.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 
 * @author paddingdun
 *
 * 2016年6月14日
 * @since 1.0
 * @version 1.0
 */
public class DbRealm extends AuthorizingRealm {

	/**
	 * 权限获取;
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
//		User user = (User)principals.getPrimaryPrincipal();
		
		//从根据用户从数据库获取该用户的权限;
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermission("query");
		info.addStringPermission("add");
		info.addStringPermission("delete");
		
		return info;
	}

	/**
	 * 登录验证;
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UserToken t = (UserToken)token;
		
		AuthenticationInfo info = new SimpleAuthenticationInfo("admin", "admin".toCharArray(), this.getName());
		return info;
	}

}


