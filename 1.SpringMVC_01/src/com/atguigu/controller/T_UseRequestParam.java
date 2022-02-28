package com.atguigu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
/*SpringMVC 如何获取请求参数带来的各种信息
	1.默认方式获取请求参数:直接给方法入参写上一个和请求参数名相同的变量,
					    				  这个变量就来接受参数的值
	2.@RequestParam("user") String username,默认如果没有这个参数就会报错
	  @RequestParam(value="user",required=false)设置该参数不必须
	3.@RequestHeader("User-Agent")String useragent 默认如果没有这个参数就会报错
	public String detail042(@RequestHeader(value="User-Agent",defaultValue="hahah")
	String useragent){设置默认值
	4.@CookieValue(value="JSESSIONID",required=false)获取request请求中cookie的值
 * */
@Controller
public class T_UseRequestParam {
	@RequestMapping("/detail050")
	public String detail050(@RequestParam(value="user",required=false) String username){
		System.out.println("username参数的值是"+username);
		return "success";
	}
	@RequestMapping("/detail051")
	public String detail051(@RequestHeader("User-Agent")String useragent){
		System.out.println("User-Agent的值是"+useragent);
		return "success";
	}
	@RequestMapping("/detail052")
	public String detail052(@RequestHeader(value="User-Agesnt",defaultValue="hahah")String useragent){
		System.out.println("User-Agent的值是"+useragent);
		return "success";
	}
	@RequestMapping("/detail053")
	public String detail053(@CookieValue("JSESSIONID")String jsid){
		System.out.println("cookie中jid的值为"+jsid);
		return "success";
	}
}

