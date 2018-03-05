package com.tc25.service;

import java.util.List;

import com.tc25.entity.Employee;

public interface IEmployeeService {
	
	/**
	 * 获得登陆用户的所有信息
	 * @param emp1
	 * @return
	 */
	List<Employee> getEmployee(Employee emp1);
	/**
	 * 获得所有员工的方法
	 * @return
	 */
	List<Employee> getAllEmployee();
	
	
}
