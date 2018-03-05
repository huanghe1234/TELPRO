package com.tc25.service;

import java.util.List;

import com.tc25.entity.Client;
import com.tc25.entity.Employee;

public interface IClientService {
	/**
	 * 添加一个客户对象的方法
	 * @param cli
	 * @return
	 */
	int addClient(Client cli);
	/**
	 * 获得所有的客户的方法
	 * @return
	 */
	List<Client> getAllClient();
	
	/**
	 * 给员工分配客户的方法
	 * @param clientId
	 * @param empId
	 * @return
	 */
	int clientEmp(int[] clientId, int empId);
	/**
	 * 查看该员工的客户的方法
	 * @param id
	 * @return
	 */
	List<Client> getEmpClient(int id);
	/**
	 * 更改客户联系状态的方法
	 * @param cid
	 * @return
	 */
	int changeContact(int cid);

}
