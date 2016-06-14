/**
 * 
 */
package me.paddingdun.web.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import me.paddingdun.component.LogHolder;
import me.paddingdun.data.User;
import me.paddingdun.exception.BusinessException;
import me.paddingdun.exception.IException;
import me.paddingdun.service.user.IUserService;
import me.paddingdun.util.SecurityHelper;
import me.paddingdun.web.action.BaseCtrl;
import me.paddingdun.web.util.IAppConstant;
import me.paddingdun.web.util.SessionHelper;
import me.paddingdun.web.util.WebHelper;


/**
 * @author paddingdun
 *
 * 2015年11月2日
 */
@Controller
public class LoginCtrl extends BaseCtrl {
	
	/**
	 * LoginController 日志变量;
	 */
	private final static Logger logger = Logger.getLogger(LoginCtrl.class);


	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(){
		return "main";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(){
		return "main";
	}

}
