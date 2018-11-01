package com.hpeu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.hpeu.bean.User;
import com.hpeu.dao.UserDao;

/**
 * 用户数据访问层接口实现类
 * @author 姚臣伟
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	/**
	 * 添加用户
	 * @param user 用户对象
	 * @return 返回是否添加成功：1成功；0失败
	 */
	@Override
	public int saveUser(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * 根据用户编号删除用户
	 * @param id 用户编号
	 * @return 返回是否删除成功：1成功；0失败
	 */
	@Override
	public int removeUser(Integer id) {
		try {
			sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(User.class, id));
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * 修改用户
	 * @param user 用户对象
	 * @return 返回是否修改成功：1成功；0失败
	 */
	@Override
	public int modifyUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * 根据用户编号查询用户信息
	 * @param id 用户编号
	 * @return 返回用户信息
	 */
	@Override
	public User findUserById(Integer id) {
		return sessionFactory.getCurrentSession()
				.createQuery("from User where id=:id", User.class)
				.setParameter("id", id)
				.getSingleResult();
	}

	/**
	 * 分页查询用户信息
	 * @param page     查询起始位置
	 * @param pagesize 每页显示的记录数
	 * @return	返回当前位置指定数量的用户信息
	 */
	@Override
	public List<User> findUsersByPage(int page, int pagesize) {
		return sessionFactory.getCurrentSession()
				.createQuery("from User", User.class)
				.setFirstResult((page-1)*pagesize)
				.setMaxResults(pagesize)
				.list();
	}

	/**
	 * 获取总的用户数
	 * @return 返回总的用户数
	 */
	@Override
	public long getCounts() {
		return sessionFactory.getCurrentSession()
				.createQuery("select count(*) from User", Long.class)
				.getSingleResult();
	}

	/**
	 * 判断用户账号是否存在
	 * @param account 账号名称
	 * @return	返回大于1表示存在；等于0表示不存在
	 */
	@Override
	public long checkAccountExist(String account) {
		return sessionFactory.getCurrentSession()
				.createQuery("select count(*) from User where account=:account", Long.class)
				.setParameter("account", account)
				.getSingleResult();
	}

	/**
	 * 根据账号和密码进行登录
	 * @param account 账号
	 * @param password 密码
	 * @return	返回登录成功后的用户信息
	 */
	@Override
	public User login(String account, String password) {
		return sessionFactory.getCurrentSession()
				.createQuery("from User where account=:account and password=:password", User.class)
				.setParameter("account", account)
				.setParameter("password", password)
				.getSingleResult();
	}

}
