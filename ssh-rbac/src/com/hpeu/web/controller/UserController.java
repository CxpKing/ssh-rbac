package com.hpeu.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hpeu.bean.User;
import com.hpeu.config.Config;
import com.hpeu.service.UserService;
import com.hpeu.util.FileUtil;
import com.hpeu.util.PaginationUtil;
import com.hpeu.util.ValidateUtil;

/**
 * 用户控制器类
 * 
 * @author 姚臣伟
 */
@Controller
@RequestMapping("/admin")
public class UserController {
	@Resource(name = "userService")
	private UserService userService;
	
	@RequestMapping("/userList")
	public String list(@RequestParam(value="page",required=false) String pageStr,
			Map<String, Object> map) {
		
		int page = ValidateUtil.stringToInt(pageStr);
		if (page <= 0) {
			page = 1;
		}
		
		// 分页查询用户信息
		PaginationUtil<User> users = userService.findUsersByPage(page, Config.USER_PAGE_SIZE);
		
		map.put("users", users);
		
		return "admin/user/user_list";
	}
	
	// 删除用户
	@RequestMapping(value="/deleteUser", method=RequestMethod.GET)
	public String deleteUser(HttpServletRequest request, 
			@RequestParam(value="id",required=true) String idStr,
			@RequestParam(value="page",required=false) String pageStr) {
		
		// 把字符串的ID转换数字ID
		int id = ValidateUtil.stringToInt(idStr);
		
		// 根据用户编号查询用户信息
		User user = userService.findUserById(id);
		if (null != user) {
			try {
				String avator = user.getAvator();
				// 获取文件的绝对路径
				String delPath = request.getServletContext().getRealPath(avator);
				File delFile = new File(delPath);
				delFile.delete();
			} catch (Exception e) {
			}
			
			// 根据用户编号删除用户信息
			userService.removeUser(id);
		}
		
		return "/admin/userList?page=" + pageStr;
	}
	
	// 处理添加用户
	@RequestMapping("/addUserHandler")
	public String addHandler(HttpServletRequest request, User user, 
			@RequestParam("avator") MultipartFile avator,
			Map<String, Object> map) {
		// 根据账号查询数据是否存在
		boolean flag = userService.checkAccountExist(user.getAccount());
		if (flag) {
			// 表示验证没通过，把验证对象放入request对象中
			map.put("account", "账号已经存在，请重新输入。");
			
			// 转发到用户添加页面
			return "user/user_add";
		}
		
		user.setRegtime(new Date());
		
		/*--------------- 实现用户头像上传 开始 -----------------------*/
		if (null != avator && avator.getSize() > 0) {
			// 表示有文件上传
			String mimeType = avator.getContentType();
			// 获取文件的扩展名
			String ext = FileUtil.getExt(mimeType);
			
			// 给上传文件重新生成一个新的文件名称
			String fileName = FileUtil.createFileName(ext);
			
			// 获取存放上传文件的目录路径
			String realPath = request.getServletContext().getRealPath("upload");
			File dir = new File(realPath);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			
			// 执行文件上传——把文件上传服务器中
			try {
				avator.transferTo(new File(realPath, fileName));
				user.setAvator("upload/" + fileName);
			} catch (IOException e) {
			}
			// 把上传的文件设置到用户对象中
		}
		/*--------------- 实现用户头像上传 结束 -----------------------*/
		
		// 添加用户数据
		userService.saveOrModifyUser(user);
		
		return "/admin/userList";
	}
	
}
