<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>退会確認</title>
</head>
<body>
	<div style="text-align: center">
		<font size="7">本当に退会しますか</font><br>
	</div>

	<form action="/tbsystem_user/MyPageServlet" method="Post">
		<p>
		<input type="hidden" name="action" value="deleteUserComplete">
		<input type="submit" value="はい">
	</form>
	<form action="/tbsystem_user/MyPageServlet" method="Post">
		<input type="hidden" name="action" value="userInfo">
		<input type="submit" value="いいえ">
		</p>
	</form>
	
</body>

<footer>
	<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>