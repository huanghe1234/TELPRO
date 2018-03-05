package com.tc25.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tc25.dao.IClientDao;
import com.tc25.entity.Client;
import com.tc25.entity.Employee;

@Repository
public class ClientDaoImpl implements IClientDao {
	
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	@Transactional(readOnly = false )
	public int insertClient(Client cli) {
		
		cli.setStatus("未分配");
		int id = (int) ht.save(cli);

		return id;
	}

	@Override
	public List<Client> queryAllClient() {
		
		String hql = "from Client";
		List<Client> list = (List<Client>) ht.find(hql);
		return list;
	}

	

	@Override
	public int updateclientEmp(int[] clientIds, int empId) {
		
		int id = 0;
		for (int i = 0; i < clientIds.length; i++) {
			String hql = "update Client set emp_id.id = ? where client_id = ?";
			id = ht.bulkUpdate(hql, empId,clientIds[i]);
		}
		return id;
	}

	@Override
	public int updateclientStatus(int[] clientIds) {
		int id = 0;
		for (int i = 0; i < clientIds.length; i++) {
			String hql = "update Client set status = '已分配' where client_id = ?";
			id = ht.bulkUpdate(hql, clientIds[i]);
		}

		return id;
	}

	@Override
	public List<Client> queryEmpClient(int id) {
		
		String hql = "from Client where emp_id.id = ? ";
		List<Client> list = (List<Client>) ht.find(hql, id);
		
		return list;
	}

	@Override
	public int updateContactStatus(int cid) {
		
		String hql = "update Client set status = '已联系' where client_id = ?";
		int id = ht.bulkUpdate(hql, cid);
		
		return id;
	}

	

}
