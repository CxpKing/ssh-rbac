package com.hpeu.config;

/**
 * 系统设置类
 * 
 * @author 姚臣伟
 */
public interface Config {
	// 主键的正则表达式
	public static final String PRIMARYKEYREG = "^[1-9]$|^[1-9]\\d+$";
	// 验证码的正则表达式
	public static final String CODEREG = "^[0-9a-zA-Z]{5}$";
	// 姓名的正则表达式
	public static final String NAMEREG = "^[\\u4e00-\\u9fa5]{2,8}$";
	// 账号的正则表达式
	public static final String ACCOUNTREG = "^\\w{6,16}$";
	// 密码的正则表达式
	public static final String PASSWORDREG = "^\\w{6,16}$";
	// 邮箱的正则表达式
	public static final String EMAILREG = "^\\w+@\\w+(\\.[a-zA-Z]{2,3}){1,2}$";
	// 电话的正则表达式
	public static final String PHONEREG = "^1\\d{10}$";
	
	// 用户每页显示记录数
	public static final int USER_PAGE_SIZE = 3;
}
