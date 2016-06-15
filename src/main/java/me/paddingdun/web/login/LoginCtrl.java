/**
 * 
 */
package me.paddingdun.web.login;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import me.paddingdun.web.action.BaseCtrl;


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

	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(){
		return "main";
	}

}
