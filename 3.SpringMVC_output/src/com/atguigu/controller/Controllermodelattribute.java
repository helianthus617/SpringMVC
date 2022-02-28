package com.atguigu.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.bean.Book;
/*
SpringMVC要封装请求参数的Book对象不应该是自己new出来的
而应该是【从数据库中】拿到的准备好的对象,再来使用这个对象封装请求参数(页面只是部分提交数据)
 * */
@Controller
public class Controllermodelattribute {	
	
	/*springmvc @ModelAttribute 是request域的数据共享容器
	 * 第一步:在方法上标注@ModelAttribute ,这个方法会提前运行, 我们提前查出这个信息
	 * */
	@ModelAttribute
	public void modelattribute0(Map<String,Object> map){		
	//从数据库中查出来的
		Book book =new Book("水浒传","100","施耐庵");
		map.put("book", book);
		System.out.println("modelattribute1 方法执行");
	}
	/*第二步:在方法参数位置标注@ModelAttribute ,
	 * 这个参数会查找使用上一步保存的对象值
	 * */
	@RequestMapping("/modelattribute1")
	public String modelattribute1(
//			@RequestParam("author") String aucthor,
			Map<String,Object> model
//			,
//			HttpServletRequest request,
//			@ModelAttribute("shuihuzhuan")Book book
			){
//	System.out.println(("book提交过来的图书信息"+book));
		System.out.println(model);
	return "success";
	}
	
	@RequestMapping("/modelattribute2")
	public String modelattribute2(
			@RequestParam("author") String aucthor,
			Map<String,Object> model,
			HttpServletRequest request,
			Book book
			){
	System.out.println(("book提交过来的图书信息"+book));
	return "success";
	}
	
}









