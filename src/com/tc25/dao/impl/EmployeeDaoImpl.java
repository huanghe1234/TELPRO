package com.tc25.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.tc25.dao.IEmployeeDao;
import com.tc25.entity.Employee;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {
	
	@Autowired
	private HibernateTemplate ht;
	
	
	@Override
	public List<Employee> queryEmployee(Employee emp1) {
		
		String hql = "from Employee where name = ?";
		
		List<Employee> emp =  (List<Employee>) ht.find(hql, emp1.getName());
		
		return emp;
	}
	
	@Override
	public List<Employee> queryAllEmployee() {
		
		String hql = "from Employee where job = '销售员'";
		List<Employee> list = (List<Employee>) ht.find(hql);
		
		return list;
	}

	@Override
	public int updateEmpStatus(int eid,String status) {
		
		String hql = "update Employee set is_leisure = ? where id = ?";
		int id = ht.bulkUpdate(hql, status,eid);
		
		return id;
	}

}
