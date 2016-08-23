package me.paddingdun.web.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import me.paddingdun.data.json.JsonResult2;
import me.paddingdun.exception.BusinessException;
import me.paddingdun.exception.IErrorCode;

/**
 * 
 * @author paddingdun
 *
 * 2016年8月22日
 * @since 1.0
 * @version 1.0
 */
@Controller
@RequestMapping("/test")
public class TestCtrl extends BaseCtrl {
	
	@RequestMapping
	public String index(){
		return "test";
	}

	@RequestMapping(value="/upload", method= RequestMethod.POST)
	@ResponseBody
	public JsonResult2<String> upload(@RequestParam(value="uploadFile") MultipartFile file){
		JsonResult2<String> result = new JsonResult2<String>();
		try {
			String str= file.getOriginalFilename();
			String ext = FilenameUtils.getExtension(str);
			
			String fn = UUID.randomUUID().toString() + "." + ext;
			File f = new File("/home/company-pc/program/apache-tomcat-7.0.69/webapps/yjtk", fn);
			FileOutputStream fos = new FileOutputStream(f);
			byte[] cache = new byte[1024];
			int length = -1;
			InputStream in = file.getInputStream();
			while((length = in.read(cache)) > 0 ){
				fos.write(cache, 0, length);
			}
			fos.close();
			result.setData(fn);
		} catch (BusinessException be) {
			result.setMsg(be.getMessage());
			result.setStatus(be.getErrorCode());
		} catch (Exception e) {
			result.setMsg("发生异常");
			result.setStatus(IErrorCode.UNKNOW_EXCEPTION);
			e.printStackTrace();
		}
		return result;
	}
}
