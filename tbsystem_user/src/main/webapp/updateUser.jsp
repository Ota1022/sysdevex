<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報の更新</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="styles/reset.min.css" />
<link rel="stylesheet" href="styles/style.css" />
</head>
<body>
<jsp:include page="/header.jsp" />
<div class="main-content">
	<div style="text-align: center">
		<font size="7">会員情報の更新</font><br>
	</div>
	<p>${message}</p>
	<p>氏名：${user.name}</p>
	<p>大学メールアドレス：${user.email}</p>
	<p>住所：
	<form action="/tbsystem_user/MyPageServlet" method="Post">
		<input type="hidden" name="action" value="updateUserConfirm">
		<input type="text" name="address" value="${user.address}"></p>
	<p>電話番号：
		<input type="text" name="tel1" required> 
		-
		<input type="text" name="tel2" required> 
		-
		<input type="text" name="tel3" required>
		</p>

	<p>パスワード：
		<input type="password" name="password" required></p>

	<p>パスワード確認用：
		<input type="password" name="password_confirm" required></p>
		<p><input type="submit" value="更新">
	</form>

	<form action="/tbsystem_user/MyPageServlet" method="Post">
		<input type="hidden" name="action" value="userInfo"> <input
			type="submit" value="戻る"></p>
	</form>
</div>
</body>

<footer>
	<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>