package com.hpeu.service;

import com.hpeu.bean.Employee;
import com.hpeu.util.PaginationUtil;

/**
 * 员工业务逻辑层接口类
 * 
 * @author 姚臣伟
 */
public interface EmployeeService {
	public void save(Employee employee);
	public void update(Employee employee);
	public void delete(Integer id);
	public Employee findEmployeeById(Integer id);
	public PaginationUtil<Employee> findEmployeesByPage(int page, int pagesize);
	public PaginationUtil<Employee> findEmployeesByPage(int page, int pagesize, Integer departId);
}
