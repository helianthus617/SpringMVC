package com.atguigu.springmvc.crud.controller;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.springmvc.crud.dao.EmployeeDao;
import com.atguigu.springmvc.crud.entities.Department;
import com.atguigu.springmvc.crud.entities.Employee;

//知识点4 测试ajax


@Controller
public class RequestBodyTestController {
	//@RequestBody 用法知识点
	//只能获取表单post请求的数据,get方式不能获取
	@RequestMapping("/testRequestbody")
	public 	String  testRequestbody1(@RequestBody String s1){
		System.out.println(s1);
	return "success";
	}
	//JSON自动封装对象,高级用法
	@RequestMapping("/testRequestbody1")
	public 	String  testRequestbody2(@RequestBody Employee em1){
		System.out.println(em1);
	return "success";
	}
}
