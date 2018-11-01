package com.hpeu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hpeu.bean.Employee;
import com.hpeu.dao.EmployeeDao;
import com.hpeu.service.EmployeeService;
import com.hpeu.util.PaginationUtil;

/**
 * 员工业务逻辑层接口实现类
 * 
 * @author 姚臣伟
 */
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Resource(name = "employeeDao")
	private EmployeeDao employeeDao;
	
	@Override
	public void save(Employee employee) {
		employeeDao.save(employee);
	}

	@Override
	public void update(Employee employee) {
		employeeDao.update(employee);
	}

	@Override
	public void delete(Integer id) {
		employeeDao.delete(id);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Employee findEmployeeById(Integer id) {
		return employeeDao.findEmployeeById(id);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public PaginationUtil<Employee> findEmployeesByPage(int page, int pagesize) {
		if (page <= 1) {
			page = 1;
		}
		int count = (int) employeeDao.getCount();
		int pages = count % pagesize == 0 ? count / pagesize : count / pagesize + 1;
		if (page >= pages) {
			page = pages;
		}
		List<Employee> items = employeeDao.findEmployeesByPage(pages, pagesize);
		return new PaginationUtil<Employee>(items, count, page, pagesize);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public PaginationUtil<Employee> findEmployeesByPage(int page, int pagesize, Integer departId) {
		if (page <= 1) {
			page = 1;
		}
		int count = (int) employeeDao.getCount(departId);
		int pages = count % pagesize == 0 ? count / pagesize : count / pagesize + 1;
		if (page >= pages) {
			page = pages;
		}
		List<Employee> items = employeeDao.findEmployeesByPage(pages, pagesize, departId);
		return new PaginationUtil<Employee>(items, count, page, pagesize);
	}

}
