package me.paddingdun.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import me.paddingdun.data.json.JsonResult2;

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
		JsonResult2<String> js = new JsonResult2<String>();
		return js;
	}
}
