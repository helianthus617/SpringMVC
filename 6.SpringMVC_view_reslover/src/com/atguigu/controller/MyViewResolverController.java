package com.atguigu.controller;

import java.util.Map;

import javax.xml.ws.RequestWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.net.httpserver.Authenticator.Success;

@Controller
public class MyViewResolverController {
	
@RequestMapping("tojump")
public String handle01(Model model){
	model.addAttribute("msg","hello");
 return "spring:fox";	
}
}








