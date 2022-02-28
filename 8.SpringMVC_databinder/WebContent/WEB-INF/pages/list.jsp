<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工列表</title>
<% pageContext.setAttribute("ctp", request.getContextPath()); %>
</head>
<body>
<h1>员工列表</h1>
<script type="text/javascript" src="${ctp }/scripts/jquery-1.9.1.min.js"></script>

<table>
	<tr>
	<th>ID</th>
	<th>lastName</th>
	<th>email</th>
	<th>gender</th>
	<th>departmentName</th>
	<th>EDIT</th>	
	<th>DELETE</th>		
	</tr>
	<c:forEach items="${emps}" var="emp"> 
		<tr>
		<td>${emp.id}</td>
		<td>${emp.lastName}</td>
		<td>${emp.email}</td>
		<td>${emp.gender==0? "女":"男"}</td>
		<td>${emp.department.departmentName}</td>
		<td><a href="${ctp }/emps/${emp.id}">EDIT</a></td>	
		<td><a href="${ctp }/emps/${emp.id}" class="DELETEBTN">DELETE</a></td>	
		<!-- <td>
		<form action="${ctp }/emps/${emp.id}" method="post">
		 <input type="hidden" name="_method" value="delete"/>
		  <input type="submit"  value="DELETE"/>
		</form> 
		</td>	-->	
		</tr>
	</c:forEach>
</table>

<form action="${ctp }/toaddempquick" method="post">
	<input name="empinfo"   value="empAdmin-admin@qq.com-1-101"/>
	<input type="submit"  value="快速添加"/>
</form> 
<form  id ="deleteform"  action="" method="post">
	<input type="hidden" name="_method" value="delete"/>
</form> 
<script type="text/javascript">
$(function(){
	$(".DELETEBTN").click(function(){
		$("#deleteform").attr("action",this.href);
		$("#deleteform").submit();
		return false;
	})
});

</script>

</body>
</html>