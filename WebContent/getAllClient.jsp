<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看所有的客户信息</title>
</head>
<body>
	<div>
		<h2>所有的客户信息如下:</h2>
		<form action="assignClient">
			<c:forEach items="${list}" var="temp">
					<input type="checkbox" name="clientId" value="${temp.client_id}" />
					客户姓名:${temp.name}&nbsp; &nbsp;客户性别:${temp.gender }&nbsp; &nbsp;客户年龄:${temp.age }
					&nbsp; &nbsp;客户状态:${temp.status }
					<br/>
			</c:forEach>
			
			分配给:<select name="empId">
			<c:forEach items="${elist}" var="temp">			
				<option value="${temp.id}">${temp.name}</option>
			</c:forEach>
			</select><br/>
			
			<input type="submit" value="进行分配">	
		</form>
	</div>
				
	
</body>
</html>