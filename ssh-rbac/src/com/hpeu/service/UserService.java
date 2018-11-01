package com.hpeu.service;

import com.hpeu.bean.User;
import com.hpeu.util.PaginationUtil;

/**
 * 用户业务逻辑接口类
 * @author 姚臣伟
 */
public interface UserService {
	/**
	 * 添加或修改用户
	 * @param user 用户对象
	 * @return 返回是否添加成功：1成功；0失败
	 */
	public int saveOrModifyUser(User user);
	
	/**
	 * 根据用户编号删除用户
	 * @param id 用户编号
	 * @return 返回是否删除成功：1成功；0失败
	 */
	public int removeUser(Integer id);
	
	/**
	 * 根据用户编号查询用户信息
	 * @param id 用户编号
	 * @return 返回用户信息
	 */
	public User findUserById(Integer id);
	
	/**
	 * 分页查询用户信息
	 * @param page     查询起始位置
	 * @param pagesize 每页显示的记录数
	 * @return	返回当前位置指定数量的用户信息
	 */
	public PaginationUtil<User> findUsersByPage(int page, int pagesize);
	
	/**
	 * 判断用户账号是否存在
	 * @param account 账号名称
	 * @return	返回true表示存在；false表示不存在
	 */
	public boolean checkAccountExist(String account);
	
	/**
	 * 根据账号和密码进行登录
	 * @param account 账号
	 * @param password 密码
	 * @return	返回登录成功后的用户信息
	 */
	public User login(String account, String password);
}
