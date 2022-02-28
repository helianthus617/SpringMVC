<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> </title>
<% pageContext.setAttribute("ctp", request.getContextPath()); %>
<script type="text/javascript" src="${ctp }/scripts/jquery-1.9.1.min.js"></script>
</head>
<body>
<div>
	<form action="${ctp }/testRequestbody" method="post">
	<input name="username" value="tomcat">
	<input name="password" value="123456">
	<input type="submit" value="提交(测试requestbody)">
	</form>
</div>

<div>
	<form action="${ctp}/getentity" method="post">
	<input name="username" value="tomcat">
	<input name="password" value="123456">
	<input type="submit" value="提交(测试HttpEntity)">
	</form>
</div>
<a href="">发送ajax数据</a>
<script type="text/javascript">
	$("a:first").click(function(){
		var emp={
				lastName:"小米",
				email:"aaa@qq.com",
				gender: 0			
		};	
		var empstr=JSON.stringify(emp);
		$.ajax({
			url:'${ctp}/testRequestbody1',
			type:"POST",
			data:empstr,
			contentType:"application/json"
		});	
		return false;
	});

	</script>
</body>
</html>