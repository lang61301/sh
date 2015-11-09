/**
 * 
 */
package me.paddingdun.web.login;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.code.kaptcha.Constants;

import me.paddingdun.component.LogHolder;
import me.paddingdun.data.User;
import me.paddingdun.exception.BusinessException;
import me.paddingdun.exception.IException;
import me.paddingdun.service.user.IUserService;
import me.paddingdun.util.DateHelper;
import me.paddingdun.util.SecurityHelper;
import me.paddingdun.web.action.BaseController;
import me.paddingdun.web.util.IAppConstant;
import me.paddingdun.web.util.SessionHelper;
import me.paddingdun.web.util.WebHelper;


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
	private final static Logger logger = Logger.getLogger(LoginController.class);


	@Autowired
	private IUserService userService;
	
	@Value("${captcha.enable:false}")
	private boolean captchaEnable;
	
	@Value("${captcha.timeout:30}")
	private Integer captchaTimeout;
	
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
		if (logger.isDebugEnabled()) {
			logger.debug(String.format("LoginController.login:captcha.enable[%s], captcha.timeout[%s]", captchaEnable, captchaTimeout));
		}
		//如果支持验证码操作
		if(captchaEnable){
			
			if(StringUtils.isBlank(code)){
				LogHolder.saveFailOpLog(String.format("[%s][%s] login fail, 验证码为空!", loginName, WebHelper.getIpAddr(request)));
				throw new BusinessException(IException.LOGIN_CODE_EMPTY, "验证码为空");
			}
			
			Date codeGenTime = 	(Date)SessionHelper.attr(request.getSession(), Constants.KAPTCHA_SESSION_DATE);
			
			if(codeGenTime == null){
				LogHolder.saveFailOpLog(String.format("[%s][%s] login fail, 未生成验证码!", loginName, WebHelper.getIpAddr(request)));
				throw new BusinessException(IException.LOGIN_CODE_UNGEN, "未生成验证码");
			}
			
			Date now = DateHelper.now();
			if(now.getTime() > (codeGenTime.getTime() + captchaTimeout * 1000) ){
				LogHolder.saveFailOpLog(String.format("[%s][%s] login fail, 验证码超时!", loginName, WebHelper.getIpAddr(request)));
				throw new BusinessException(IException.LOGIN_CODE_TIMEOUT, "验证码超时");
			}
			
			String codeGen = 	(String)SessionHelper.attr(request.getSession(), Constants.KAPTCHA_SESSION_KEY);
			code = code.trim();
			if(!code.equalsIgnoreCase(codeGen)){
				LogHolder.saveFailOpLog(String.format("[%s][%s] login fail, 验证码错误!", loginName, WebHelper.getIpAddr(request)));
				throw new BusinessException(IException.LOGIN_CODE_ERROR, "验证码错误");
			}
		}
		
		if(StringUtils.isBlank(loginName)){
			LogHolder.saveFailOpLog(String.format("[%s][%s] login fail, 用户为空!", loginName, WebHelper.getIpAddr(request)));
			throw new BusinessException(IException.LOGIN_USER_EMPTY, "用户为空");
		}
		if(StringUtils.isBlank(password)){
			LogHolder.saveFailOpLog(String.format("[%s][%s] login fail, 密码为空!", loginName, WebHelper.getIpAddr(request)));
			throw new BusinessException(IException.LOGIN_PASSWORD_EMPTY, "密码为空");
		}
		if(StringUtils.isBlank(code)){
			LogHolder.saveFailOpLog(String.format("[%s][%s] login fail, 验证码为空!", loginName, WebHelper.getIpAddr(request)));
			throw new BusinessException(IException.LOGIN_CODE_EMPTY, "验证码为空");
		}
		
		String loginName1 = loginName.trim();
		
		User user = userService.findUserByLoginName(loginName1);
		if(user == null){
			LogHolder.saveFailOpLog(String.format("[%s][%s] login fail, 用户不存在!", loginName1, WebHelper.getIpAddr(request)));
			throw new BusinessException(IException.LOGIN_USER_NOT_EXIST, "用户不存在");
		}else{
			String pwd = "";
			try {
				pwd = SecurityHelper.md5Encode(password.trim()).toUpperCase();
			} catch (Exception e) {
				LogHolder.saveFailOpLog(String.format("[%s][%s] login fail, 服务器错误!", loginName1, WebHelper.getIpAddr(request)));
				throw new BusinessException(IException.LOGIN_UNKNOW, "服务器错误", e, null);
			}
			if(pwd.equals(user.getPassword())){
				LoginUser loginUser = new LoginUser(user);
				
				SessionHelper.attr(request.getSession(), IAppConstant.USER_SESSION_KEY, loginUser);
				
				LogHolder.saveOpLog(String.format("[%s][%s] login success!", loginName1, WebHelper.getIpAddr(request)));
				if (logger.isInfoEnabled()) {
					logger.info(String.format("LoginController.login: user[%s] logined!", loginName1));
				}
			}else{
				LogHolder.saveFailOpLog(String.format("[%s][%s] login fail, 密码错误!", loginName1, WebHelper.getIpAddr(request)));
				throw new BusinessException(IException.LOGIN_PASSWORD_ERROR, "密码错误");
			}
		}
		
		return "redirect:/main";
	}
	
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(){
		return "main";
	}

}
