package com.hpeu.web.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hpeu.bean.User;

/**
 * 权限访问过滤器
 * @author 姚臣伟
 */
public class PremissionAccessFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
		
		// 第一步：把ServletRequest和ServletResponse对象转换为HttpServletRequest和HttpServletResponse对象
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		// 第二步：从req对象中获取客户端的请求资源
		String uri = req.getRequestURI();
		
		// 第三步：排除不需要过滤的资源
		if (uri.endsWith("login.jsp") || uri.endsWith("login") || 
				uri.endsWith("vcode") || uri.endsWith(".js") || 
				uri.endsWith(".css") || uri.endsWith(".jpg")||
				uri.endsWith("register.jsp") || uri.endsWith("registerHandler")) {
			// 放行
			chain.doFilter(request, response);
		} else {
			// 从Session中获取是否已经登录过
			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("u");
			if (null != user) {
				// 登录过，就放行
				chain.doFilter(request, response);
			} else {
				// 没有登录过或登录过期，重定向到登录页面
				res.sendRedirect(req.getServletContext().getContextPath() + "/admin/login.jsp");
			}
			
		}
		
	}

}
