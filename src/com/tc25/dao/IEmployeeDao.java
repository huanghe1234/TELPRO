package com.tc25.dao;

import java.util.List;

import com.tc25.entity.Client;
import com.tc25.entity.Employee;

public interface IEmployeeDao {
	/**
	 * 从数据库中获得客户对象
	 * @param emp1
	 * @return
	 */
	List<Employee> queryEmployee(Employee emp1);
	
	/**
	 * 查询所有员工的方法
	 * @return
	 */
	List<Employee> queryAllEmployee();
	/**
	 * 更改员工状态的方法
	 * @param eid 员工id
	 * @param string 更改员工否空闲的状态
	 * @return
	 */
	int updateEmpStatus(int eid, String string);
	
}
