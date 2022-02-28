package com.atguigu.controller;


import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/* 程序获取国际化信息
 * 默认的区域信息解析器默认为AcceptHeaderLocaleResolver 
 * AcceptHeaderLocaleResolver 
 * @Override
	public Locale resolveLocale(HttpServletRequest request) {
		return request.getLocale();
	}
	视图渲染时获取区域信息
	protected void render(ModelAndView mv, HttpServletRequest request,  HttpServletResponse response) throws Exception {
            // Determine locale for request and apply it to the  response.
	//获取区域信息
            Locale locale = this.localeResolver.resolveLocale(request);
 * 
 * */
@Controller
public class T_NationalTestController {
		@Autowired
		private MessageSource messageSource;
		
		@RequestMapping("/test")
		public String tologingPage(Locale locale,Model model){
			System.out.println("local===="+locale);
			System.out.println(messageSource.getMessage("welcomeinfo", null,locale));
			return "login";
		}
}
