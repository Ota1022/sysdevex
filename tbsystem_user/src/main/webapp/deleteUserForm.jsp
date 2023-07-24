<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>退会フォーム</title>
</head>
<body>
	<div style="text-align: center">
		<font size="7">退会処理のためにパスワードを確認します</font><br>
	</div>

	${message}
	<br> パスワード：


	<form action="/tbsystem_user/MyPageServlet" method="Post">
		<input type="hidden" name="action" value="deleteUserConfirm">
		<input type="text" name="password"> <input type="submit"
			value="確認">
	</form>
	<form action="/tbsystem_user/MyPageServlet" method="Post">
		<input type="hidden" name="action" value="userInfo"> <input
			type="submit" value="戻る">
	</form>

</body>

<footer>
	<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>