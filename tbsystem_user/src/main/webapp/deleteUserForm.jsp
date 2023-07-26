<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>退会フォーム</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="styles/reset.min.css" />
<link rel="stylesheet" href="styles/style.css" />
</head>
<body>
<jsp:include page="/header.jsp" />
<div class="main-content">

	<div style="text-align: center">
		<font size="7">退会処理のためにパスワードを確認します</font><br>
	</div>

	<p>${message}</p>
	<p>パスワード：
	<form action="/tbsystem_user/MyPageServlet" method="Post">
		<input type="hidden" name="action" value="deleteUserConfirm">
		<input type="text" name="password"></p>
		<p>
		<input type="submit"value="確認">
	</form>
	<form action="/tbsystem_user/MyPageServlet" method="Post">
		<input type="hidden" name="action" value="userInfo">
		<input type="submit" value="戻る">
		</p>
	</form>
</div>
</body>

<footer>
	<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>