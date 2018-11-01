package com.hpeu.dao;

import java.util.List;

import com.hpeu.bean.Employee;

/**
 * 员工数据访问层接口类
 * 
 * @author 姚臣伟
 */
public interface EmployeeDao {
	public void save(Employee employee);
	public void update(Employee employee);
	public void delete(Integer id);
	public Employee findEmployeeById(Integer id);
	public List<Employee> findEmployeesByPage(int page, int pagesize);
	public long getCount();
	public List<Employee> findEmployeesByPage(int page, int pagesize, Integer departId);
	public long getCount(Integer departId);
	
}
