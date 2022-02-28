package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
//SimpleMappingController,配置的方式处理异常
public class SimpleMappingController {
	@RequestMapping("test4")
	public String handle01(Integer i){
		String str=null;
		System.out.println(str.codePointAt(0));
		return "success";
	}
}
