package me.paddingdun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.paddingdun.dao.ICommonDao;
import me.paddingdun.service.ICommonService;

/**
 * 
 * @author admin
 *
 */
@Service
public class CommonServiceImpl implements ICommonService {

	
	@Autowired
	private ICommonDao commonDao;

	public void save(Object obj) throws Exception {
		// TODO Auto-generated method stub
		commonDao.save(obj);
		
	}

	public void update(Object obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public List<Object> query() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Object obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
//	public void saveUser(User user){
//		commonDao.save(user);
//	}
//	
//	/*public void testAddUser(User user){
//		commonDao.save(user);
//		
//		if(2>1) throw new RuntimeException("2 > 1 故意的错误");
//		User u = new User();
//		u.setName(user.getName() + "@mail");
//		commonDao.save(u);
//	}*/
//	
//	public List<User> queryUser(){
//		return null;
//	}
//	
//	public void updateUser(User user){
//		
//	}
//	
//	public void deleteUser(User user){
//		
//	}
}
