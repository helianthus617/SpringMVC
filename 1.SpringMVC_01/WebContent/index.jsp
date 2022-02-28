<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="hello" >hello-world</a>
	<br>
	<a href="requestMappingLimitedQuery/handle02" >测试 method=RequestMethod.POST </a>
	<a href="originAPI" >OriginApi </a>		
	<br>
	<form action="requestMappingLimitedQuery/handle02" method="post">
	<input type="submit" value="测试 method=RequestMethod.POST">
	</form>	
	
	<form action="handleMessyCode" method="post">
图书<input type="text" name="bookName"><br>
价格<input type="text" name="price"><br>
作者<input type="text" name="author"><br>
出版社省份<input type="text" name="press.province"><br>

<input type="submit" value="提交">
	</form>	
</body>
</html>