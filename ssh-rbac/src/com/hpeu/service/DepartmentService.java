package com.hpeu.service;

import java.util.List;

import com.hpeu.bean.Department;

/**
 * 部门业务逻辑层接口类
 * 
 * @author 姚臣伟
 */
public interface DepartmentService {
	public void save(Department department);
	public void update(Department department);
	public void delete(Department department);
	public Department findDepartmentById(Integer id);
	public List<Department> findDepartments();
}
