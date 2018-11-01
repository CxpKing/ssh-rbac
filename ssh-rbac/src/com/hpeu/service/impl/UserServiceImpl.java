package com.hpeu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hpeu.bean.User;
import com.hpeu.dao.UserDao;
import com.hpeu.service.UserService;
import com.hpeu.util.PaginationUtil;

/**
 * 用户业务逻辑接口实现类
 * @author 姚臣伟
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Resource(name = "userDao")
	private UserDao userDao;
	
	/**
	 * 添加或修改用户
	 * @param user 用户对象
	 * @return 返回是否添加成功：1成功；0失败
	 */
	@Override
	public int saveOrModifyUser(User user) {
		if (user.getId() != null) {
			return userDao.modifyUser(user);
		} else {
			return userDao.saveUser(user);
		}
	}

	/**
	 * 根据用户编号删除用户
	 * @param id 用户编号
	 * @return 返回是否删除成功：1成功；0失败
	 */
	@Override
	public int removeUser(Integer id) {
		return userDao.removeUser(id);
	}

	/**
	 * 根据用户编号查询用户信息
	 * @param id 用户编号
	 * @return 返回用户信息
	 */
	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public User findUserById(Integer id) {
		return userDao.findUserById(id);
	}

	/**
	 * 分页查询用户信息
	 * @param page     查询起始位置
	 * @param pagesize 每页显示的记录数
	 * @return	返回当前位置指定数量的用户信息
	 */
	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public PaginationUtil<User> findUsersByPage(int page, int pagesize) {
		if (page <= 1) {
			page = 1;
		}
		
		// 得所有用户数量
		int count = (int) userDao.getCounts();
		
		// 计算总页数
		int pages = count % pagesize == 0 ? count / pagesize : count / pagesize + 1;
		if (page >= pages) {
			page = pages;
		}
		
		// 分页查询用户信息
		List<User> items = userDao.findUsersByPage(page, pagesize);
		
		// 把用户信息封装到分页工具类中
		PaginationUtil<User> users = new PaginationUtil<User>(items,count,page,pagesize);
		return users;
	}

	/**
	 * 判断用户账号是否存在
	 * @param account 账号名称
	 * @return	返回true表示存在；false表示不存在
	 */
	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public boolean checkAccountExist(String account) {
		long exist = userDao.checkAccountExist(account);
		return exist == 0L ? false : true;
	}

	/**
	 * 根据账号和密码进行登录
	 * @param account 账号
	 * @param password 密码
	 * @return	返回登录成功后的用户信息
	 */
	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public User login(String account, String password) {
		return userDao.login(account, password);
	}

}
