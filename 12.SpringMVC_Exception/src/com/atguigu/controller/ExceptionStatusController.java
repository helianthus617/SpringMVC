package com.atguigu.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ExceptionStatusController  {
	
	@RequestMapping("test3")
	public String handle01(@RequestParam("i")Integer i){
	if(i==0){
		throw new MyException();
		
	}else{
		return "success";
		
	}
		
	}
	
}
