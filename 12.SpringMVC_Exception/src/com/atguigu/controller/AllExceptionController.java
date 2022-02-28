package com.atguigu.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
@ControllerAdvice
public class AllExceptionController  {
/*
 * 全局处理所有异常的类,先找本类是否有处理异常的方法,如果没有就找全局的处理异常方法
 * */
//	@ExceptionHandler(value={Exception.class})
//		public ModelAndView handle02(Exception exception){
//			ModelAndView modelandview =new ModelAndView("errors");
//			modelandview.addObject("ex",exception);
//			return modelandview;
//		}
}
