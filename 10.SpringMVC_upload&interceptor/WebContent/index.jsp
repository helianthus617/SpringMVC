<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<% pageContext.setAttribute("ctp", request.getContextPath()); %>
</head>
<body>
单文件上传<br>
	<form action="${ctp }/upload" method="post" enctype="multipart/form-data">
		用户头像:<input type="file" name="headerimg">
		用户名:<input type="text" name="username">
		<input type="submit" value="上传">
	</form>
	多文件上传<br>
	<form action="${ctp }/upload" method="post" enctype="multipart/form-data">
		用户头像1:<input type="file" name="headerimg"><br>
			用户头像2:<input type="file" name="headerimg"><br>
				用户头像3:<input type="file" name="headerimg"><br>
					用户头像4:<input type="file" name="headerimg"><br>
						用户头像5:<input type="file" name="headerimg"><br>
		用户名:<input type="text" name="username"><br>
		<input type="submit" value="上传">
	</form>
</body>
</html>