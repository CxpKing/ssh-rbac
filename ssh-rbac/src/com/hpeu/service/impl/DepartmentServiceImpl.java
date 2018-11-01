package com.hpeu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hpeu.bean.Department;
import com.hpeu.dao.DepartmentDao;
import com.hpeu.service.DepartmentService;

/**
 * 部门业务逻辑层接口类
 * 
 * @author 姚臣伟
 */
@Service("departmentService")
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	@Resource(name = "departmentDao")
	private DepartmentDao departmentDao;
	
	@Override
	public void save(Department department) {
		departmentDao.save(department);
	}

	@Override
	public void update(Department department) {
		departmentDao.update(department);
	}

	@Override
	public void delete(Department department) {
		departmentDao.delete(department);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Department findDepartmentById(Integer id) {
		return departmentDao.findDepartmentById(id);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Department> findDepartments() {
		return departmentDao.findDepartments();
	}

}
