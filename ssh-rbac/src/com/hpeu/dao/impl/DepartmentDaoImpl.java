package com.hpeu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.hpeu.bean.Department;
import com.hpeu.dao.DepartmentDao;

/**
 * 部门数据访问层接口实现类
 * 
 * @author 姚臣伟
 */
@Repository("departmentDao")
public class DepartmentDaoImpl implements DepartmentDao {
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	@Override
	public void save(Department department) {
		sessionFactory.getCurrentSession().save(department);
	}

	@Override
	public void update(Department department) {
		sessionFactory.getCurrentSession().update(department);
	}

	@Override
	public void delete(Department department) {
		sessionFactory.getCurrentSession().delete(department);
	}

	@Override
	public Department findDepartmentById(Integer id) {
		return sessionFactory.getCurrentSession().get(Department.class, id);
	}

	@Override
	public List<Department> findDepartments() {
		return sessionFactory.getCurrentSession()
				.createQuery("from Department", Department.class)
				.list();
	}

}
