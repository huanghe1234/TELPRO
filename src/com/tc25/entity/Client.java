package com.tc25.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tel_client")
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int client_id; //客户身份id（）
	private String name;//客户姓名（）
	private String gender;//客户性别（）
	private int age;//客户年龄（）
	private String telphone;//客户联系方式（）
	
	@ManyToOne
	private Employee emp_id;//员工id（）
	private String status;//客户状态（：已分配,未分配,已联系）
	
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public Employee getId() {
		return emp_id;
	}
	public void setId(Employee id) {
		this.emp_id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Client() {
		super();
	}
	@Override
	public String toString() {
		return "Client [client_id=" + client_id + ", name=" + name + ", gender=" + gender + ", age=" + age
				+ ", telphone=" + telphone + ", id=" + emp_id + ", status=" + status + "]";
	}
	
	
	
	
	
	
}
