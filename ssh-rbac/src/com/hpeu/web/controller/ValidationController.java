package com.hpeu.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.dsna.util.images.ValidateCode;

/**
 * 验证码控制器类
 * 
 * @author 姚臣伟
 */
@Controller
@RequestMapping("/admin")
public class ValidationController {
	@RequestMapping("/vcode")
	public void createValidateCode(HttpServletRequest request, HttpServletResponse response) {
		// 第一步：使用第三方jar程序来生成验证码
		ValidateCode code = new ValidateCode(200, 30);
		
		// 第二步：获取生成的验证码内容
		String str = code.getCode();
		
		// 第三步：把生成的验证码内容存放到session对象中，便于登录时验证
		request.getSession().setAttribute("code", str);
		
		// 第四步：把生成的验证码输出到页面中
		try {
			code.write(response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
