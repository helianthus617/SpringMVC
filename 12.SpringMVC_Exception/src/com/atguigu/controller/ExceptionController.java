package com.atguigu.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ExceptionController  {
/*
 * 默认异常组件在配置文件中
org.springframework.web.servlet.HandlerExceptionResolver=
    org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerExceptionResolver,\
	org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver,\@ResponseStatuss
	org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver --->是否是mvc自带的异常
	       if (ex instanceof  NoSuchRequestHandlingMethodException) {
                        return  handleNoSuchRequestHandlingMethod((NoSuchRequestHandlingMethodException)  ex, request, response,
                                    handler);
                  }
                  else if (ex instanceof  HttpRequestMethodNotSupportedException) {
                        return  handleHttpRequestMethodNotSupported((HttpRequestMethodNotSupportedException) ex, request,
                                    response, handler);
                  }
                  else if (ex instanceof  HttpMediaTypeNotSupportedException) {
                        return  handleHttpMediaTypeNotSupported((HttpMediaTypeNotSupportedException) ex,  request, response,
                                    handler);
                  }
                  else if (ex instanceof  HttpMediaTypeNotAcceptableException) {
                        return  handleHttpMediaTypeNotAcceptable((HttpMediaTypeNotAcceptableException)  ex, request, response,
                                    handler);
                  }
                  else if (ex instanceof  MissingServletRequestParameterException) {
                        return  handleMissingServletRequestParameter((MissingServletRequestParameterException) ex, request,
                                    response, handler);
                  }
                  else if (ex instanceof ServletRequestBindingException)  {
                        return  handleServletRequestBindingException((ServletRequestBindingException)  ex, request, response,
                                    handler);
                  }
                  else if (ex instanceof  ConversionNotSupportedException) {
                        return  handleConversionNotSupported((ConversionNotSupportedException) ex,  request, response, handler);
                  }
                  else if (ex instanceof TypeMismatchException) {
                        return  handleTypeMismatch((TypeMismatchException) ex, request, response,  handler);
                  }
                  else if (ex instanceof  HttpMessageNotReadableException) {
                        return  handleHttpMessageNotReadable((HttpMessageNotReadableException) ex,  request, response, handler);
                  }
                  else if (ex instanceof  HttpMessageNotWritableException) {
                        return  handleHttpMessageNotWritable((HttpMessageNotWritableException) ex,  request, response, handler);
                  }
                  else if (ex instanceof  MethodArgumentNotValidException) {
                        return  handleMethodArgumentNotValidException((MethodArgumentNotValidException)  ex, request, response, handler);
                  }
                  else if (ex instanceof  MissingServletRequestPartException) {
                        return  handleMissingServletRequestPartException((MissingServletRequestPartException) ex, request, response, handler);
                  }
                  else if (ex instanceof BindException) {
                        return handleBindException((BindException) ex,  request, response, handler);
                  }
                  else if (ex instanceof NoHandlerFoundException) {
                        return  handleNoHandlerFoundException((NoHandlerFoundException) ex, request,  response, handler);
                  }
            }
该标签<mvc:annotation-driven></mvc:annotation-driven>
将注册new RootBeanDefinition(ExceptionHandlerExceptionResolver.class)进入组件,处理异常 --->@ExceptionHandler
 * */
	@RequestMapping("test1")
	public String handle01(Integer i){
		System.out.println("handle01...");
		System.out.println(10/i);
		return "success";
	}
	//方式1该方法只能接受(Exception exception)参数
	//@ExceptionHandler(value={ArithmeticException.class})
	//public String handle02(Exception exception){
	//	System.out.println(exception);
	//	return "errors";
	//}
	//方式2
	@ExceptionHandler(value={ArithmeticException.class})
		public ModelAndView handle02(Exception exception){
			ModelAndView modelandview =new ModelAndView("errors");
			modelandview.addObject("ex",exception);
			return modelandview;
		}
}
