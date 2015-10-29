package me.paddingdun.service;

import java.util.List;

public interface ICommonService {

	void save(Object obj)throws Exception;
	
	void update(Object obj)throws Exception;
	
	List<Object> query()throws Exception;
	
	void delete(Object obj)throws Exception;
	
	
	/*void testAddUser(User user);*/
}
