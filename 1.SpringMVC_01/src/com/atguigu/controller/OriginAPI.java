package com.atguigu.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
/*
 * SpringMVC可以直接在参数上写原生API
 * session的数据,作用域是会话级别的,只要浏览器不关闭,
 * 任何session作用域下的页面都能获取到session的值
 * */
@Controller
public class OriginAPI {
	@RequestMapping("/originAPI")
	public String RequestMappingDetail06(HttpServletRequest request,HttpSession session){
		request.setAttribute("message", "我是请求域的,通过转发可以让转发的页面进行获取值,转发就是使用同一次请求");	
		session.setAttribute("message", "我是session的数据,作用域是会话级别的");
		return "getMessage";
	}

}

