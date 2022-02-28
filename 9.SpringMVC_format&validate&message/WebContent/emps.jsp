<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工列表</title>
<% pageContext.setAttribute("ctp", request.getContextPath()); %>
<script type="text/javascript" src="${ctp }/scripts/jquery-1.9.1.min.js"></script>
</head>
<body>
<%= new Date() %>
<a href="getallajax" >ajax获取所有员工</a><br/>

<div>
<script type="text/javascript">
	$("a:first").click(function(){
		$.ajax({
			url:"${ctp}/getallajax",
			type:"GET",
			success:function(data){
				console.log(data);		
			}
		});	
		return false;
	});
</script>


</div>
</body>
</html>