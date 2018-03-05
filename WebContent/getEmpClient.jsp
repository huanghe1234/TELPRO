<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看客户信息</title>
<style type="text/css">
	 	a:link, a:visited{
            text-decoration: none;
            color: chocolate;
        }
         a:hover, a:active{
            text-decoration: underline;
            color: blue;
        }

</style>
</head>
<body>
	<div>
		<h2>客户信息如下:</h2>
		<p>${tip }</p>
		<c:forEach items="${list}" var="temp">
					客户姓名:${temp.name}&nbsp; &nbsp;客户性别:${temp.gender }
					&nbsp; &nbsp;客户年龄:${temp.age }&nbsp; &nbsp;电话号码:${temp.telphone }
					&nbsp; &nbsp;客户状态:${temp.status }&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
					<a href="changeContactStatus?cid=${temp.client_id}">设置为已联系</a>
					<br/>
		</c:forEach>
	</div>
</body>
</html>