package me.paddingdun.service.user.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
		commonDao.save(user);
	}

	public IDataCollection<User> queryUser(User user, Paging pag) {
		Map<String, Object> params = Collections.emptyMap();
		return commonDao.queryPaging(" from User ",  params, pag.getPage(), pag.getPageSize());
	}

	/* 
	 * 根据根据登录用户名获取用户对象;
	 */
	public User findUserByLoginName(String loginName) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("loginName", loginName);
		List<User> list = commonDao.findObjects(" from User where loginName=:loginName", params);
		User result = null;
		if(!list.isEmpty()){
			result = list.get(0);
		}
		return result;
	}

	
	
}
