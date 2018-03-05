<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<style type="text/css">
	div{
		width:300px;
		height:300px;
		margin: 100px auto;
		border: green 1px solid;
		}
	.center{
		margin-left: 120px;
		margin-top: 30px;
	}
</style>
</head>
<body>
	<div>
		<h1>主页</h1>
		<p>${tip}<p/>
		
		<form action="login">
		<span>员工姓名</span><input type="text" value="" name="name"><br/>
						<input type="submit" value="登陆" class="center">
		</form>
	</div>
</body>
</html>