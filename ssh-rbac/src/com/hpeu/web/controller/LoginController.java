package com.hpeu.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hpeu.bean.User;
import com.hpeu.config.Config;
import com.hpeu.service.UserService;
import com.hpeu.util.FileUtil;
import com.hpeu.util.ValidateUtil;

/**
 * 登录和退出控制器类
 * 
 * @author 姚臣伟
 */
@Controller
@RequestMapping("/admin")
public class LoginController {
	@Resource(name = "userService")
	private UserService userService;
	
	// 登录
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(HttpServletRequest request,
			@RequestParam(value="account",required=true) String account,
			@RequestParam(value="password",required=true) String password,
			@RequestParam(value="code",required=true) String code,
			Map<String, Object> map) {
		
		// 验证数据有有效性
		if (!ValidateUtil.validateString(account, Config.ACCOUNTREG)) {
			map.put("accountMsg", "账号不对，必须是6~16个字母、数字或下划线组成。");
			map.put("account", account);
		}
		if (!ValidateUtil.validateString(password, Config.PASSWORDREG)) {
			map.put("passwordMsg", "密码不对，必须是6~16个字母、数字或下划线组成。");
		}
		if (!ValidateUtil.validateString(code, Config.CODEREG)) {
			map.put("codeMsg", "验证码不对，由5个字母或数字组成。");
			map.put("code", code);
		}
		if (!map.isEmpty()) {
			return "login";
		}
		
		HttpSession session = request.getSession();
		// 从Session对象中获取验证码数据
		String sessionCode = (String)session.getAttribute("code");
		if (code.equalsIgnoreCase(sessionCode)) {
			// 根据账号和密码查询用户是否存在
			User user = userService.login(account, password);
			if (null != user) {
				// 登录成功后，把用户放到session对象中
				session.setAttribute("u", user);
				// 登录成功后把验证码从session对象中去掉
				session.removeAttribute("code");
				// 重定向到后台管理界面
				return "redirect:/admin/index.jsp";
			} else {
				map.put("accountMsg", "账名或密码错误。");
				map.put("account", account);
				map.put("code", code);
				return "login";
			}
		} else {
			map.put("codeMsg", "验证码错误。");
			map.put("account", account);
			map.put("code", code);
			return "admin/login";
		}
	}
	@RequestMapping("/registerHandler")
	public String register(
		HttpServletRequest request,
		User user,
		@RequestParam(value="avator1",required=false) MultipartFile avator,
		Map<String,Object> map) {
		if(!ValidateUtil.validateString(user.getName(), Config.NAMEREG)) {
			map.put("nameMsg", "姓名不符合规则");
			map.put("user", user);
			return "admin/register";
		}
		if(!ValidateUtil.validateString(user.getAccount(), Config.ACCOUNTREG)) {
			map.put("accountMsg", "账号不符合规则");
			map.put("user", user);
			return "admin/register";
		}
		if(!ValidateUtil.validateString(user.getEmail(), Config.EMAILREG)) {
			map.put("emailMsg", "邮箱不符合规则");
			map.put("user", user);
			return "admin/register";
		}
		if(!ValidateUtil.validateString(user.getPhone(), Config.PHONEREG)) {
			map.put("phoneMsg", "电话不符合规则");
			map.put("user", user);
			return "admin/register";
		}
		//获取头上传的路径
		String realPath = request.getServletContext().getRealPath("upload");
		
		if(null != avator && avator.getSize() > 0) {
			// 表示有文件上传
			String mimeType = avator.getContentType();
			// 获取文件的扩展名
			String ext = FileUtil.getExt(mimeType);
			
			// 给上传文件重新生成一个新的文件名称
			String fileName = FileUtil.createFileName(ext);
			//判断头像上传路径
			File file = new File(realPath);
			if(!file.exists()) {
				file.mkdirs();
			}
			//将文件路径保存进用户对象
			user.setAvator("upload/"+fileName);
			//上传头像
			try {
				avator.transferTo(new File(realPath,fileName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//添加用户注册时间
		user.setRegtime(new Date());
		//添加用户到数据库
		userService.saveOrModifyUser(user);
		return "admin/login";
	}
	
	
	
	// 退出
	@RequestMapping(value="/loginout",method=RequestMethod.GET)
	public String loginOut(HttpServletRequest request) {
		// 第一步：创建Session对象
		HttpSession session = request.getSession();
		
		// 第二步：删除Session对象中的数据
		session.invalidate();
		
		// 第三步：重定向到登录页面
		return "redirect:/admin/login.jsp";
	}
}
