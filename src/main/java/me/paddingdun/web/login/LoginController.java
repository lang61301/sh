/**
 * 
 */
package me.paddingdun.web.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import me.paddingdun.data.User;
import me.paddingdun.exception.CommonException;
import me.paddingdun.exception.IException;
import me.paddingdun.service.user.IUserService;
import me.paddingdun.util.SecurityHelper;
import me.paddingdun.web.action.BaseController;
import me.paddingdun.web.util.IAppConstant;
import me.paddingdun.web.util.SessionHelper;


/**
 * @author paddingdun
 *
 * 2015年11月2日
 */
@Controller
public class LoginController extends BaseController {
	/**
	 * LoginController 日志变量;
	 */
	private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private IUserService userService;
	
	/**
	 * 用户名, 密码, 验证码
	 * @param username
	 * @param password
	 * @param code
	 * @return
	 */
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@RequestParam("loginName")String loginName, 
						@RequestParam("password")String password,
						@RequestParam("code")String code,
						HttpServletRequest request,
						HttpServletResponse response){
		if(StringUtils.isBlank(loginName)){
			throw new CommonException(IException.LOGIN_USER_EMPTY, "用户为空");
		}
		if(StringUtils.isBlank(password)){
			throw new CommonException(IException.LOGIN_PASSWORD_EMPTY, "密码为空");
		}
		if(StringUtils.isBlank(code)){
			throw new CommonException(IException.LOGIN_CODE_EMPTY, "验证码为空");
		}
		
		String loginName1 = loginName.trim();
		
		User user = userService.findUserByLoginName(loginName1);
		if(user == null){
			throw new CommonException(IException.LOGIN_USER_NOT_EXIST, "用户不存在");
		}else{
			String pwd = "";
			try {
				pwd = SecurityHelper.md5Encode(password.trim()).toUpperCase();
			} catch (Exception e) {
				throw new CommonException(IException.LOGIN_UNKNOW, "服务器错误", e, null);
			}
			if(pwd.equals(user.getPassword())){
				LoginUser loginUser = new LoginUser(user);
				
				SessionHelper.attr(request.getSession(), IAppConstant.USER_SESSION_KEY, loginUser);
				
				if (logger.isInfoEnabled()) {
					logger.info(String.format("LoginController.login: user[%s] logined!", loginName1));
				}
			}else{
				throw new CommonException(IException.LOGIN_PASSWORD_ERROR, "密码错误");
			}
		}
		
		return "redirect:/main";
	}
	
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(){
		return "main";
	}

}
