<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報の更新確認</title>
</head>
<body>
	<div style="text-align: center">
		<font size="7">以下の会員情報で更新しますか</font>
	</div>
	<form action="/tbsystem_user/MyPageServlet" method="post">
		<p>氏名：${user.name}</p>
		<p>大学メールアドレス：${user.email}</p>
		<p>住所：${user.address}</p>
		<p>電話番号：${user.tel}</p>

	<form action="/tbsystem_user/MyPageServlet" method="Post">
		<input type="hidden" name="action" value="updateUserComplete">
		<p>
		<input type="submit" value="はい">
		<input type="hidden" name="address" value="${user.address}">
		<input type="hidden" name="tel" value="${user.tel}">
		<input type="hidden" name="password" value="${user.password}">
	</form>
	<form action="/tbsystem_user/MyPageServlet" method="Post">
		<input type="hidden" name="action" value="updateUser">
		<input type="submit" value="いいえ">
		</p>
	</form>
</body>

<footer>
	<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>