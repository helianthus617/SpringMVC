package com.atguigu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/*
@PathVariable获取占位符上的值(精确匹配优先访问)
路径上的占位符只能占一个路径
 * */
@Controller
public class T_UsePathVariable {
//user/admin
//user/haha	
	@RequestMapping("/user/{id}")
	public String detail040(@PathVariable("id")String f1){
		System.out.println(f1);
		return "success";
	}
	@RequestMapping("/{user}/{id}")
	public String detail041(
			@PathVariable("id")String f1 ,
			@PathVariable("user")String f2
			){
		System.out.println(f1+"==="+f2);
		return "success";
	}
}

