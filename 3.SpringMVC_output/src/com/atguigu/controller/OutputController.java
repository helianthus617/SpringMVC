package com.atguigu.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.net.httpserver.Authenticator.Success;
/*
 Springmvc输出数据
 Map<String,String> map , Model model, ModelMap modelmap ModelAndView 都是request作用域
 实质都是BindingAwareModelMap
 *关系:
 *	map --->modelmap----->ExtendedModelMap---->BindingAwareModelMap
 *	model---------------->ExtendedModelMap---->BindingAwareModelMap
 * */
@Controller
public class OutputController {
	Object o1;
	Object o2;
	Object o3;
	Object o4;	
	
	@RequestMapping("/outputdetail01")
	public String outputdetail01(Map<String,String> map){
		map.put("msg1", "hello1");
		o1=map;
		System.out.println(map.getClass());
		return "success";
	}
	@RequestMapping("/outputdetail02")
	public String outputdetail02(Model model){
		model.addAttribute("msg2", "hello2");
		o2=model;
		System.out.println(model.getClass());
		return "success";
	}
	@RequestMapping("/outputdetail03")
	public String outputdetail03(ModelMap modelmap){
		modelmap.addAttribute("msg3", "hello3");
		o3=modelmap;
		System.out.println(modelmap.getClass());
		return "success";
	}
	@RequestMapping("/outputdetail04")
	public ModelAndView outputdetail04(ModelMap modelmap){
		o4=modelmap;
		ModelAndView mv = new ModelAndView("success");
		mv.addObject("msg4","hello4");
		return mv ;
	}
	@RequestMapping("/outputdetail05")
	public String outputdetail04(){
	System.out.println(o1==o2);
	System.out.println(o3==o4);
	System.out.println(o2==o3);
		return "success" ;
	}
}








