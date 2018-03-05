package com.tc25.dao;

import java.util.List;

import com.tc25.entity.Client;
import com.tc25.entity.Employee;

public interface IClientDao {
	/**
	 * 向数据库中添加一个客户
	 * @param cli
	 * @return
	 */
	int insertClient(Client cli);
	/**
	 * 查询所有客户的方法
	 * @return
	 */
	List<Client> queryAllClient();
	
	/**
	 * 给客户分配员工的方法
	 * @param clientIds
	 * @param empId
	 * @return
	 */
	int updateclientEmp(int[] clientIds, int empId);
	/**
	 * 更改客户的状态的方法
	 * @param clientIds
	 * @return
	 */
	int updateclientStatus(int[] clientIds);
	/**
	 * 查询该员工所属的客户的方法
	 * @param id
	 * @return
	 */
	List<Client> queryEmpClient(int id);
	/**
	 * 更新客户联系状态的方法
	 * @param cid
	 * @return
	 */
	int updateContactStatus(int cid);
	

}
