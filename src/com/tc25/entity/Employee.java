package com.tc25.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tel_employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private int age;
	private String gender;
	private String is_leisure;
	private String job;//(销售助理,销售主管,销售员)
	
	@OneToMany
	@JoinColumn(name="emp_id")
	private Set<Client> cli = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIs_leisure() {
		return is_leisure;
	}

	public void setIs_leisure(String is_leisure) {
		this.is_leisure = is_leisure;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Set<Client> getCli() {
		return cli;
	}

	public void setCli(Set<Client> cli) {
		this.cli = cli;
	}

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", is_leisure="
				+ is_leisure + ", job=" + job + ", cli=" + cli + "]";
	}
	
	
	
	
}
