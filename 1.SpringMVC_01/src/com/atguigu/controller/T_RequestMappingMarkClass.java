package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 * 为类添加为@RequestMapping 注解
 * 当前类所有方法的请求地址制定了基准路径
 * */
@RequestMapping("/requestMappingMarkClass")
@Controller
public class T_RequestMappingMarkClass {
	//测试:
	@RequestMapping("/hello")
	public String detail010(){
		return "success";
	}
	//测试:
	@RequestMapping("hello1")
	public String detail011(){
		return "success";
	}
}

