package com.atguigu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/*
 *规定请求参数
 * */
@RequestMapping("/requestMappingLimitedQuery")
@Controller
public class T_RequestMappingLimitedQuery {
//	method:限定请求方式(GET,POST),默认全部接受
	@RequestMapping(value="/handle02",method=RequestMethod.POST)
	public String detail020(){
		return "success";
	}
	/*params 
	 * eg:params={"username"}  发送请求时携带 username参数 
	 * eg:params={"!username"} 发送请求时不携带 username参数
	 * eg:params={"username=123"}  发送请求时携带 username参数且值为123
	 * eg:params={"username!=123"}  发送请求时携带 username参数且值不为123
	 * */
	//测试
	@RequestMapping(value="/handle03",params={"username!=123","pwd","!age"})
	public String detail021(){
		return "success";
	}
	/*headers
	 * User-Agent:
	 * Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:97.0) Gecko/20100101 Firefox/97.0
	 * 测试
	 * */
	@RequestMapping(value="/handle04",headers={"User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:97.0) Gecko/20100101 Firefox/97.0"})
	public String detail022(){
		return "success";
	}
	/*consumes:只接受内容类型是哪种请求,规定请求头中的Content-Type
	 *produces:告诉浏览器返回的内容类型是什么,给响应头中加上Content-Type:text/html;charset=utf-8
	 * */
	
}

