package com.atguigu.controller;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
/*
Springmvc向session 域中存放属性
	1@SessionAttributes(value="msg"),
	这个代表了给BingdingAwareModelMap中保存的数据,
	同时给session中放一份(该数据的key必须是msg)
知识点:给session放的数据,不论是否是同一个请求,
只要在session的作用范围下(test1/),
访问任何的页面(test1/*)都可以取到session的值,session的作用域是会话范围的.
session.setattribute()代表了服务器内部存储了该session的值,会在响应头放一个jsessionId
的cookie,传给浏览器,该cookie的生命周期是放在内存中,关闭浏览器就会丢失掉这个cookie
,利用这个cookie就可以定位到具体的session.
* */
@Controller
@SessionAttributes(value={"msg7"})
public class OutputControllersession {
@RequestMapping("/session")
public String sessiondetail01(Map<String,String> map){
	map.put("msg7", "hello1");
	System.out.println(map.getClass());
	return "success";
}

}


