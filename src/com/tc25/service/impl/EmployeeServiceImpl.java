package com.tc25.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tc25.dao.IEmployeeDao;
import com.tc25.entity.Client;
import com.tc25.entity.Employee;
import com.tc25.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private IEmployeeDao ied;
	
	@Override
	public List<Employee> getEmployee(Employee emp1) {
		
		List<Employee> emp = ied.queryEmployee(emp1);
		
		System.out.println(emp1);
		
		return emp;
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		List<Employee> list = ied.queryAllEmployee();
		
		return list;
	}

	


}
