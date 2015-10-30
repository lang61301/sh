package me.paddingdun.service.user.impl;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.paddingdun.dao.ICommonDao;
import me.paddingdun.data.User;
import me.paddingdun.data.paging.IDataCollection;
import me.paddingdun.data.paging.Paging;
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
	private ICommonDao commonDao;
	
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		commonDao.save(user);
	}

	public IDataCollection<User> queryUser(User user, Paging pag) {
		// TODO Auto-generated method stub
		Map<String, Object> params = Collections.emptyMap();
		return commonDao.queryPaging(" from User ",  params, pag.getPage(), pag.getPageSize());
	}

	
	
}
