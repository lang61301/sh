package me.paddingdun.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import me.paddingdun.data.User;
import me.paddingdun.data.paging.Paging;

/**
 * 
 * @author paddingdun
 *
 * 2015年10月30日
 */

@Repository
public interface IUserDao {

	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUser(Long id);
	
	User getUser(Long id);
	
	List<User> queryUser(@Param("user") User user, @Param("paging") Paging page);
	
	int getUserTotal(@Param("user") User user);
	
	User findUserByLoginName(String loginName);
}
