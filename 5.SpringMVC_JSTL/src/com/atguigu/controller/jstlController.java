package com.atguigu.controller;

import java.util.Map;

import javax.xml.ws.RequestWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.net.httpserver.Authenticator.Success;
//JSTL返回值不能有forward
@Controller
public class jstlController {
	
@RequestMapping("tologinpage")
public String handle01(){
return "login";	
}
}








