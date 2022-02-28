<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--
REST风格：
	/book/1 GET---查询1号图书
	/book/1 PUT---更新1号图书
	/book/1 DELETE---删除1号图书
	/book 	POST---添加图书
 -->

<a href="book/1" >查询图书</a>
<form action="book" method="post">
<input type="submit" value="添加1号图书">
</form>
<form action="book/1" method="post">
<input name="_method" value="put">
<input type="submit" value="更新1号图书">
</form>
<form action="book/1" method="post">
<input name="_method" value="delete">
<input type="submit" value="删除1号图书">
</form>

</body>
</html>