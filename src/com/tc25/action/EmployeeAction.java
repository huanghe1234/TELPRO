package com.tc25.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.tc25.entity.Client;
import com.tc25.entity.Employee;
import com.tc25.service.IClientService;
import com.tc25.service.IEmployeeService;


@ParentPackage("struts-default")
@Namespace("/")
@Controller
public class EmployeeAction implements ModelDriven<Employee>{
	
	@Autowired
	private IEmployeeService ies;
	@Autowired
	private IClientService ics;
	
	private Employee emp1 = new Employee();
	private String tip;
	private List<Client> list;
	private List<Employee> elist;
	
	@Action(value="login",results={
			@Result(name="getAllClient",location="/getAllClient.jsp"),
			@Result(name="getEmpClient",location="/getEmpClient.jsp"),
			@Result(name="addClient",location="/addClient.jsp"),
			@Result(name="error",location="/index.jsp")
	})
	public String login(){
		
		//获得登陆员工的所有字段,判断是什么身份,进行分别登陆
		List<Employee> emp = ies.getEmployee(emp1);
		
		if(0 == emp.size() || emp.get(0).getJob() == null){
			
			tip="账号或密码错误!";
			return "error";
			
		}else{
		
			if("销售助理".equals(emp.get(0).getJob())){
				
				return "addClient";
				
			}else if("销售主管".equals(emp.get(0).getJob())){
				
				//1.获得所有的客户对象
				list =  ics.getAllClient();
				//2.获得所有的销售员
				elist = ies.getAllEmployee();
				return "getAllClient";
				
			}else if("销售员".equals(emp.get(0).getJob())){
				
				//获得分配给该销售员的客户对象
				list = ics.getEmpClient(emp.get(0).getId());
				return "getEmpClient";
				
			}else{
				return "error";
				
			}
		}
		
		
	}
	
	@Override
	public Employee getModel() {
		return emp1;
	}


	public String getTip() {
		return tip;
	}

	public List<Client> getList() {
		return list;
	}

	public List<Employee> getElist() {
		return elist;
	}
	
	
	
}
