package com.atguigu.resolver;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

public class MyView  implements View{
	@Override
	public String getContentType() {		
		return "text/html";
	}
	@Override
	public void render(Map<String, ?> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			System.out.println(model);
			response.setContentType("text/html");
			response.getWriter().write("哈哈");
	}
}
