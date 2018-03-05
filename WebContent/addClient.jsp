<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>录入客户</title>
</head>
<body>
	<div>
		<h2>录入客户信息</h2>
		<p>${tip}</p>
		<form action="addClient">
				<span>客户姓名</span><input type="text" value="" name="name"><br/>
				<span>客户性别</span><input type="radio" value="男" name="gender">男
				<input type="radio" value="女" name="gender">女<br/>
				<span>客户年龄</span><input  type="text" value="" name="age"><br/>
				<span>客户联系方式</span><input type="text" value="" name="telphone"><br/>
				<input type="submit" value="提交" class="submit">
		</form>
	</div>
</body>
</html>