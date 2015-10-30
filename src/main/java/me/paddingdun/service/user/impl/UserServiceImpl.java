package me.paddingdun.service.user.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.paddingdun.dao.user.IUserDao;
import me.paddingdun.data.User;
import me.paddingdun.data.paging.IDataCollection;
import me.paddingdun.data.paging.Paging;
import me.paddingdun.data.paging.impl.DefaultListDataCollection;
import me.paddingdun.service.user.IUserService;

/**
 * user service;
 * @author paddingdun
 *
 * 2015年10月28日
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userDao.saveUser(user);
	}

	public IDataCollection<User> queryUser(User user, Paging pag) {
		// TODO Auto-generated method stub
		DefaultListDataCollection<User> data = new DefaultListDataCollection<User>();
		data.setData(userDao.queryUser(user, pag));
		data.setTotal(userDao.getUserTotal(user));
		if(pag == null)
			pag = new Paging();
		data.setPage(pag.getPage());
		data.setPageSize(pag.getPageSize());
		return data;
	}

	
	
}
