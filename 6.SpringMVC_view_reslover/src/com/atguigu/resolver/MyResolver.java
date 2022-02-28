package com.atguigu.resolver;
import java.util.Locale;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

public class MyResolver  implements ViewResolver ,Ordered {
	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {	
		if(viewName.startsWith("spring:")){
			 return  new MyView();	
		}else{
			return null;
		}
	}

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 1;
	}
}
