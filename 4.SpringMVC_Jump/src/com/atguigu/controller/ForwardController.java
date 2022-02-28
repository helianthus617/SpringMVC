package com.atguigu.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.net.httpserver.Authenticator.Success;

@Controller
public class ForwardController {
	
	
//	return "forward:/hello.jsp"; 如果不加/代表相对路径
	@RequestMapping("/forward01")
	public String forward01(){
		return "forward:/hello.jsp";
	}
	
	
	@RequestMapping("/forward03")
	public String forward03(){
		return "../../hello";
	}
	
	@RequestMapping("/forward02")
	public String forward02(){
		return "forward:/forward01";
	}
	
	
}








