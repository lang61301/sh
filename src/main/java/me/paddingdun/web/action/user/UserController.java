package me.paddingdun.web.action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import me.paddingdun.data.User;
import me.paddingdun.data.json.JsonResult2;
import me.paddingdun.data.paging.IDataCollection;
import me.paddingdun.data.paging.Paging;
import me.paddingdun.service.user.IUserService;
import me.paddingdun.util.GsonHelper;
import me.paddingdun.web.action.BaseController;
import me.paddingdun.web.util.WebHelper;

/**
 * 用户信息 controller
 * @author paddingdun
 *
 * 2015年10月28日
 */
@Controller
@RequestMapping(value="/user")
public class UserController extends BaseController{

	/**
	 * UserController 日志变量;
	 */
	private final static Logger logger = Logger.getLogger(UserController.class);

	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/userAdd", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void save(User user, HttpServletRequest request, HttpServletResponse response)throws Exception{
		userService.saveUser(user);
		logger.info("save user! ");
	}
	
	@RequestMapping(value="/userList", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void list(User user, Paging pag, HttpServletRequest request, HttpServletResponse response)throws Exception{
		IDataCollection<User> data = userService.queryUser(user, pag);
		
		JsonResult2 jr = new JsonResult2();
		jr.setData(data);
		WebHelper.rtnAjax(response, GsonHelper.gson(), jr); 
		
		
		logger.info("list user! ");
	}
	
}
