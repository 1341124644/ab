package com.qianfeng.entity;

public class Employee {
	
	private Integer id;
	private String password;
	private String name;
	private String sex;
	private Integer age;
	private String phone;
	
	

	public Employee(){}
	
	public Employee(String name, String sex, Integer age, String phone){
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.phone = phone;
	}
	
	public Employee(Integer id, String name, String sex, Integer age, String phone){
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.phone = phone;
	}
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
