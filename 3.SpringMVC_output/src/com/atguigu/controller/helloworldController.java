package com.atguigu.controller;

import java.awt.print.Book;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class helloworldController {	

	@RequestMapping("/hello0")
	public String modelattribute0(){
	System.out.println("请求收到了...正在处理..");
	return "success";
	}
	
}









