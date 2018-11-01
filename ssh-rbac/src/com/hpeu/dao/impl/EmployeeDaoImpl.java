package com.hpeu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.hpeu.bean.Employee;
import com.hpeu.dao.EmployeeDao;

/**
 * 员工数据访问层接口实现类
 * 
 * @author 姚臣伟
 */
@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	@Override
	public void save(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
	}

	@Override
	public void update(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
	}

	@Override
	public void delete(Integer id) {
		sessionFactory.getCurrentSession()
		.createQuery("delete from Employee e where e.id=:id", Employee.class)
		.setParameter("id", id);
	}

	@Override
	public Employee findEmployeeById(Integer id) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Employee e where e.id=:id", Employee.class)
				.setParameter("id", id)
				.getSingleResult();
	}

	@Override
	public List<Employee> findEmployeesByPage(int page, int pagesize) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Employee", Employee.class)
				.setFirstResult((page-1)*pagesize)
				.setMaxResults(pagesize)
				.list();
	}

	@Override
	public long getCount() {
		return sessionFactory.getCurrentSession()
				.createQuery("select count(*) from Employee", Long.class)
				.getSingleResult();
	}

	@Override
	public List<Employee> findEmployeesByPage(int page, int pagesize, Integer departId) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Employee e where e.depart.id=:id", Employee.class)
				.setParameter("id", departId)
				.setFirstResult((page-1)*pagesize)
				.setMaxResults(pagesize)
				.list();
	}

	@Override
	public long getCount(Integer departId) {
		return sessionFactory.getCurrentSession()
				.createQuery("select count(*) from Employee e where e.depart.id=:id", Long.class)
				.setParameter("id", departId)
				.getSingleResult();
	}

}
