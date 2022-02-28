package com.atguigu.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.net.httpserver.Authenticator.Success;

@Controller
public class DirectController {
	
/*
 * 重定向 redirect: 重定向的路径
 * 			原生的Servlet重定向--->路径+项目名才能成功 
 * 		Springmvc处理/hello.jsp代表从当前项目下开始.springmvc会自动加上项目名+/hello.jsp
 * */
	@RequestMapping("/redirect01")
	public String redict01(){
		return "redirect:/hello.jsp";
	}
	

	@RequestMapping("/tobaidu")
	public String forward02(){
		return  "redirect:https://www.baidu.com/";
	}
	
	
}








