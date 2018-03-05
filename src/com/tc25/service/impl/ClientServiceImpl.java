package com.tc25.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tc25.dao.IClientDao;
import com.tc25.dao.IEmployeeDao;
import com.tc25.entity.Client;
import com.tc25.entity.Employee;
import com.tc25.service.IClientService;

@Service
public class ClientServiceImpl implements IClientService {
	
	@Autowired
	private IClientDao icd;
	
	@Autowired
	private IEmployeeDao ied;
	
	
	@Override
	public int addClient(Client cli) {
		
		int id = icd.insertClient(cli);
		
		return id;
	}


	@Override
	public List<Client> getAllClient() {
		
		List<Client> list = icd.queryAllClient();
		
		return list;
	}


	@Override
	@Transactional
	public int clientEmp(int[] clientIds, int empId) {
		//给员工分配客户
		int id = icd.updateclientEmp(clientIds,empId);
		//更改客户的状态为已分配
		int id2 = icd.updateclientStatus(clientIds);
		
		return id2+id;
		
	}


	@Override
	public List<Client> getEmpClient(int eid) {
		//获得该销售员手中所有的客户对象
		List<Client>  list = icd.queryEmpClient(eid);
		//查询该销售员手中的客户是否都是已联系状态
		int j = 0;
		for (int i = 0; i < list.size(); i++) {
			if(!list.get(i).getStatus().equals("已联系")){
				j=1;
				
			}	
		}
		if(j==0){
			//修改业务员状态为空闲
			//给销售员设置为空闲,即状态改为"是"
			System.out.println("客户已经全部联系");
			int id = ied.updateEmpStatus(eid,"是");
		}else{
			//修改成非空闲
			System.out.println("有客户没有联系");
			int id = ied.updateEmpStatus(eid, "否");
		}
		
		return list;
	}


	@Override
	public int changeContact(int cid) {
		
		//更改销售员手中的客户的状态
		int id = icd.updateContactStatus(cid);
		
		return id;
	}


	

}
