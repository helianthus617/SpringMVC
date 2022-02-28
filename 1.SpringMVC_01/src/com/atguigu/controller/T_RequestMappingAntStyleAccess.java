package com.atguigu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/*
 *ant风格url地址访问
 *URL地址可以写模糊的通配符 (精确匹配优先！！)
 *?: 能代替任意一个字符,
 *'*':能代替任意多个字符和一层路径,(任意多可以为0个)
 *'**':代表多层路径
 * */
@Controller
public class T_RequestMappingAntStyleAccess {
//http://localhost:8080/1.SpringMVC_01/antTest0x  可以
//http://localhost:8080/1.SpringMVC_01/antTest0xx 报错
//http://localhost:8080/1.SpringMVC_01/antTest0   报错
	@RequestMapping("/antTest0?")
	public String detail030(){
		System.out.println("myfirstRequest3");
		return "success";
	}
//	http://localhost:8080/1.SpringMVC_01/a/antTest00 可以
//	http://localhost:8080/1.SpringMVC_01/a/antTest000 可以
//	http://localhost:8080/1.SpringMVC_01/a/antTest0可以
	@RequestMapping("a/antTest0*")
	public String detail031(){
		System.out.println("myfirstRequest4");
		return "success";
	}
//	http://localhost:8080/1.SpringMVC_01/a/antTest01 可以
//	http://localhost:8080/1.SpringMVC_01/a*/antTest0 可以
	@RequestMapping("a*/antTest0*")
	public String detail032(){
		System.out.println("myfirstRequest5");
		return "success";
	}
//	http://localhost:8080/1.SpringMVC_01/antTest011 不行
	@RequestMapping("/*/antTest0*")
	public String detail033(){
		System.out.println("myfirstRequest6");
		return "success";
	}
//	http://localhost:8080/1.SpringMVC_01/a/b/c/antTest011  可以	
//	http://localhost:8080/1.SpringMVC_01/antTest011  可以
	@RequestMapping("/**/antTest0*")
	public String detail034(){
		System.out.println("myfirstRequest7");
		return "success";
	}
}

