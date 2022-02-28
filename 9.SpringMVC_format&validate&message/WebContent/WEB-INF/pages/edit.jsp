<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工修改</title>
</head>
<body>
<!-- Neither BindingResult nor plain target object for bean name 'command' available as request attribute
 -->
<h1>员工修改</h1>
<% pageContext.setAttribute("ctp", request.getContextPath()); %>

<form:form action="${ctp }/emps/${employee.id}"
 modelAttribute="employee" 
 method="post">
 <input type="hidden" name="_method" value="put"/>

 <input type="hidden" name="id" value="${employee.id }"/> 
birthday:<form:input path="birthDay"/><br/>
email:<form:input path="email"/><br/>
gender:<br/>
男:<form:radiobutton path="gender" value="1"/><br/>
女:<form:radiobutton path="gender" value="0"/><br/>
dept:
<form:select path="department.id" 	items="${depts }" 
itemLabel="departmentName" itemValue="id">
</form:select>	<br/>
<input type="submit" value="修改">
</form:form>


<!--
<form action="">
lastName:<input type="text" name="lastName"><br/>
email:<input type="text" name="email"><br/>
gender:<br/>
男<input type="radio" name="gender" value="1"><br/>
女<input type="radio" name="gender" value="0"><br/>
dept:
<select>
<c:forEach items="${depts}" var="deptItem">
<option value="${deptItem.id}" >  ${deptItem.departmentName}</option>
</c:forEach> 
</select>
<input type="submit" value="提交">
</form>
-->
</body>
</html>