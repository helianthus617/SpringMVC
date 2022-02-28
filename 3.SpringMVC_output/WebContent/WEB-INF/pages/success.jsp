<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%System.out.println("页面输出"); %>
request域中:${requestScope.msg1 }<br/>
request域中:${requestScope.msg2 }<br/>
request域中:${requestScope.msg3 }<br/>
request域中:${requestScope.msg4 }<br/>
request域中:${requestScope.msg4 }<br/>
<hr>
request域中:${requestScope.msg7 }<br/>
session域中:${sessionScope.msg7 }<br/>
</body>
</html>