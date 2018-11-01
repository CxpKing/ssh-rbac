package com.hpeu.dao;

import java.util.List;

import com.hpeu.bean.User;

/**
 * 用户数据访问层接口类
 * 
 * @author 姚臣伟
 */
public interface UserDao {
	/**
	 * 添加用户
	 * @param user 用户对象
	 * @return 返回是否添加成功：1成功；0失败
	 */
	public int saveUser(User user);
	/**
	 * 根据用户编号删除用户
	 * @param id 用户编号
	 * @return 返回是否删除成功：1成功；0失败
	 */
	public int removeUser(Integer id);
	
	/**
	 * 修改用户
	 * @param user 用户对象
	 * @return 返回是否修改成功：1成功；0失败
	 */
	public int modifyUser(User user);
	
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
	public List<User> findUsersByPage(int page, int pagesize);
	
	/**
	 * 获取总的用户数
	 * @return 返回总的用户数
	 */
	public long getCounts();
	
	/**
	 * 判断用户账号是否存在
	 * @param account 账号名称
	 * @return	返回大于1表示存在；等于0表示不存在
	 */
	public long checkAccountExist(String account);
	
	/**
	 * 根据账号和密码进行登录
	 * @param account 账号
	 * @param password 密码
	 * @return	返回登录成功后的用户信息
	 */
	public User login(String account, String password);
	
}
