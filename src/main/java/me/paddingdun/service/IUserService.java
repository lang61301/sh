package me.paddingdun.service;

import me.paddingdun.data.User;
import me.paddingdun.data.paging.IDataCollection;
import me.paddingdun.data.paging.Paging;

/**
 * 用户接口;
 * @author paddingdun
 *
 * 2015年10月28日
 */
public interface IUserService {

	void saveUser(User user);
	
	IDataCollection<User> queryUser(User user, Paging pag);
}
