/**
 * 
 */
package me.paddingdun.web.login;

import me.paddingdun.data.User;

/**
 * 用户登录后的loginUser对象;
 * @author paddingdun
 *
 * 2015年11月2日
 */
public class LoginUser {
	
	private User currentUser;

	/**
	 * @param currentUser
	 */
	public LoginUser(User currentUser) {
		super();
		this.currentUser = currentUser;
	}

	public User getCurrentUser() {
		return currentUser;
	}
}
