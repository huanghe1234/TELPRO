package com.tc25.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.tc25.entity.Client;
import com.tc25.service.IClientService;

@ParentPackage("struts-default")
@Namespace("/")
@Controller
public class ClientAction implements ModelDriven<Client>{
	
	private Client cli = new Client();
	private String tip;
	private int[] clientId;
	private int empId;
	private int cid;
	
	@Autowired
	private IClientService ics;
	
	@Action(value="addClient",results={
			@Result(name="success",location="/addClient.jsp"),
			@Result(name="error",location="/addClient.jsp"),
			})
	public String addClient(){
		
		System.out.println(cli);
		int id = ics.addClient(cli);
		if(id>=0){
			tip = "添加客户成功!";
			return "success";
		}else{
			tip = "添加客户失败!";
			return "error";
		}
		
	}
	
	@Action(value="assignClient",results={
			@Result(name="success",location="/index.jsp")
			})
	public String assignClient(){
		//获得所有的用户id
		for (int i = 0; i < clientId.length; i++) {
			System.out.println(clientId[i]);
		}
		//获得员工的id
		System.out.println(empId);
		
		//传递至业务层进行判断,然后分配对象
		int id  = ics.clientEmp(clientId,empId);
		
		return "success";
		
	}
	
	
	@Action(value="changeContactStatus",results={
			@Result(name="ok",location="/getEmpClient.jsp")
			})
	public String changeContactStatus(){
		
		System.out.println(cid);
		tip = "更改成功!";
		//更改客户的状态为已联系
		int id = ics.changeContact(cid);
		return "ok";
		
	}
	
	
	
	@Override
	public Client getModel() {
		return cli;
	}


	public String getTip() {
		return tip;
	}


	public int[] getClientId() {
		return clientId;
	}

	public void setClientId(int[] clientId) {
		this.clientId = clientId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}
	
	
	
}
