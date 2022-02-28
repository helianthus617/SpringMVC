package com.atguigu.springmvc.crud.entities;

import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;



public class Employee {
	@Email
	private String email;
	
	//1 male, 0 female
	private Integer gender;
	@JsonIgnore
	private Department department;
		
	//日期格式化
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Past
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date birthDay;
	
	private Integer id;
	@NotEmpty(message="格式错了")
	@Length(min=5,max=18)
	private String lastName;
	
	
	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public Employee(Integer id, String lastName, Date birthDay, String email,
			Integer gender, Department department) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.email = email;
		this.gender = gender;
		this.department = department;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee(Integer id, String lastName, String email, Integer gender,
			Department department) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.department = department;
	}

	public Employee() {
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", birthDay="
				+ birthDay + ", email=" + email + ", gender=" + gender
				+ ", department=" + department + "]";
	}
		
}
