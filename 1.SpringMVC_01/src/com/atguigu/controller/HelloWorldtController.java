package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 1.@Controller告诉SpringMVC这个是个处理器,可以处理请求
 * 2.@RequestMapping告诉Springmvc处理什么请求.("/hello")和("hello")处理一样
 * 3.如果不指定配置文件的位置
 *  */
@Controller
public class HelloWorldtController {
	@RequestMapping("/hello")
	public String yfirstRequest(){
		System.out.println("请求收到了...正在处理");
//return "/WEB-INF/pages/success.jsp";	
//配置视图解析器bean 指定前后缀拼接,默认请求方式是转发(地址栏不变,/hello地址但转发到success.jsp);
		return "success";
	}
}
