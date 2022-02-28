package com.atguigu.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.bean.*;
/*
 * SpringMVC知识点1：可以直接在参数上写原生API
 * 			知识点2：Springmvc会自动为这个POJO进行赋值,还可级联赋值
 * 	解决乱码
 * 		1请求乱码
 * 			1.1GET: 建议tomcat安装上就在: tomcat服务器server.xml配置 ,添加 URIEncoding="UTF-8"
 * 				 <Connector URIEncoding="UTF-8" connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443"/>
 * 			1.2POST:
 * 				 在第一次获取请求参数之前设置 request.setCharacterEncoding("UTF-8),
 * 			对于springmvc来说 需要配置一个filter
 *					<filter>
						<filter-name>CharacterEncodingFilter</filter-name>
						<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
						<!-- 设置post方式提及的乱码 request.setCharacterEncoding("UTF-8), -->
						<init-param>
								<param-name>encoding</param-name>
								<param-value>UTF-8</param-value>
						</init-param>
						<!-- 设置响应编码  response.setContentType("text/html;charset=utf-8") -->
							<init-param>
								<param-name>forceEncoding</param-name>
								<param-value>true</param-value>
						</init-param>
					</filter>
					<filter-mapping>
					<filter-name>CharacterEncodingFilter</filter-name>
					<url-pattern>/*</url-pattern>
					</filter-mapping> 
 * 		2相应乱码
 * 				 response.setContentType("text/html;charset=utf-8")
 * 
 * 		知识点3:处理请求乱码的filter 一定要在其他filter 之前，
 * 	对于其他的filter(例如解决restful风格请求方式的filter),可能提前获取了request.getParameter()参数,
 * 	解决乱码问题一定是在第一次获取请求参数之前设置 
 * */	
@Controller
public class HandleMessyCode {
	@RequestMapping("/handleMessyCode")
	public String RequestMappingDetail07(Book book){
		System.out.println(book);
		return "success";
	}

}

