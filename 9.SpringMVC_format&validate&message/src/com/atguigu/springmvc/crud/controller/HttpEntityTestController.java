package com.atguigu.springmvc.crud.controller;
import java.util.Collection;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.atguigu.springmvc.crud.entities.Employee;
@Controller
public class HttpEntityTestController {
	
//知识点	HttpEntity<String> str 可以拿到请求头数据
	@RequestMapping("/getentity")
	public 	String   ajaxGetAll(HttpEntity<String> str){
		System.out.println(str);
		return "success";
	}
}
