package com.atguigu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/*
 * 从页面发起的PUT,DELETE形式的请求? Spring提供了对Rest风格的支持
 * 发起REST风格URL的方法步骤
 * 1),SpringMVC中有一个Filter,它可以把普通的请求转化为规定形式的请求;配置这个filter
 *   <filter>
	<filter-name>HiddenHttpMethodFilter</filter-name>
	<filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
     </filter>
	<filter-mapping>
		<filter-name>HiddenHttpMethodFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
   2),
	1创建post类型的表单
 	2表单携带一个_method的参数
 	3这个参数的值是请求方式
	3),如果jsp页面报错,"405-JSPs only perimit GET POST or HEAD "
	解决  --->jsp页面标签内添加 isErrorPage="True"
 * */
@Controller
public class BookController {
	@RequestMapping(value="/book/{bid}",method=RequestMethod.GET)
	public String getBook(@PathVariable("bid")Integer id){
		System.out.println("查询到了"+id+"号图书");
		return "success";
	}
	@RequestMapping(value="/book/{bid}",method=RequestMethod.DELETE)
	public String deleteBook(@PathVariable("bid")Integer id){
		System.out.println("删除了"+id+"号图书");
		return "success";
	}
	@RequestMapping(value="/book/{bid}",method=RequestMethod.PUT)
	public String updateBook(@PathVariable("bid")Integer id){
		System.out.println(id+"号图书更新");
		return "success";
	}
	@RequestMapping(value="/book",method=RequestMethod.POST)
	public String addBook(){
		System.out.println("保存了图书");
		return "success";
	}
}








