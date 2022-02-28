package com.atguigu.resolver;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.LocaleResolver;

public class MyResolver implements LocaleResolver {

	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		Locale locale=null;
		String parameter = request.getParameter("locale");
		if(locale!=null){
			return locale=	new Locale(parameter.split("_")[0],parameter.split("_")[1]);
		}
		else{
			return request.getLocale();			
		}		
	}
	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		throw new UnsupportedOperationException(
				"Cannot change HTTP accept header - use a different locale resolution strategy");
	}

}
