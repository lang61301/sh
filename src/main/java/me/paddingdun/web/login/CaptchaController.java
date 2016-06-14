/**
 * 
 */
package me.paddingdun.web.login;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;

import me.paddingdun.util.DateHelper;
import me.paddingdun.web.action.BaseController;
import me.paddingdun.web.util.SessionHelper;
import me.paddingdun.web.util.WebHelper;

/**
 * 验证码生成器;
 * @author paddingdun
 *
 * 2015年11月6日
 */
@Controller
@RequestMapping("/captcha")
public class CaptchaController extends BaseController {
	
	@Autowired
	private DefaultKaptcha kaptcha;
	
	@RequestMapping(method = RequestMethod.GET)
	public void genCaptcha(HttpServletRequest request, HttpServletResponse response)throws IOException{
		WebHelper.setNoCacheHeader(response);
		response.setContentType("image/jpeg");
		
		String text = kaptcha.createText();
		SessionHelper.attr(request.getSession(), Constants.KAPTCHA_SESSION_KEY, text);
		BufferedImage img = kaptcha.createImage(text);
		ImageIO.write(img, "jpeg", response.getOutputStream());
		
		SessionHelper.attr(request.getSession(), Constants.KAPTCHA_SESSION_DATE, DateHelper.now());
	}

}
