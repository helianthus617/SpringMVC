package com.atguigu.springmvc.crud.controller;
import java.util.Collection;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.springmvc.crud.entities.Employee;
@Controller
public class ResponseEntityTestController {
	//知识点 ResponseEntity 可以自定义 响应头,响应体,状态
	@ResponseBody
	@RequestMapping("/responseentity")
	public 	ResponseEntity<String>   responseentity(){
	
		String body ="success";
		MultiValueMap<String, String> headers = new HttpHeaders() ;
		headers.add("Set-Cookie", "username=hahahaha");
		HttpStatus status = null;
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(body,headers,status.OK);
		return responseEntity;
	}
}
