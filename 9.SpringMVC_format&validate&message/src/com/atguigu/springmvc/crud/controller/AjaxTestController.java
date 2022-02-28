package com.atguigu.springmvc.crud.controller;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.springmvc.crud.dao.EmployeeDao;
import com.atguigu.springmvc.crud.entities.Department;
import com.atguigu.springmvc.crud.entities.Employee;

//知识点4 测试ajax


//jackson-annotations-2.1.5
//jackson-core-2.1.5
//jackson-databind-2.1.5
@Controller
public class AjaxTestController {
	@Autowired
	EmployeeDao  employeeDao;
	/*
	 * 如果是对象自动转为json数据
	 * 	@JsonIgnore
		private Department department; 忽略该属性
		@JsonFormat(pattern="yyyy-MM-dd") 日期格式
		private Date birthDay; //原始的是这个 1633795200000

	知识点:	@ResponseBody返回数据到响应体中
	 * */
	@ResponseBody
	@RequestMapping("/getallajax")
	public 	Collection<Employee>   ajaxGetAll(){
		Collection<Employee> all = employeeDao.getAll();
		return all;
	}

	
	
}
