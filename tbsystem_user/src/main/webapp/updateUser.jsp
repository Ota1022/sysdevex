<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報の更新</title>
</head>
<body>
	<div style="text-align: center">
		<font size="7">会員情報の更新</font><br>
	</div>

	氏名：${name}
	<br> 大学メールアドレス：${email}
	<br> 住所：
	<form action="/tbsystem_user/MyPageServlet" method="Post">
		<input type="hidden" name="action" value="updateUserConfirm">
		<input type="text" name="adress"> 
	<br> 電話番号：
		<input type="text" name="tel1" required> 
		-
		<input type="text" name="tel2" required> 
		-
		<input type="text" name="tel3" required> 

	<br> パスワード：
		<input type="text" name="password" required> 

	<br> パスワード確認用：
		<input type="text" name="password_confirm" required> 
		<input type="submit" value="更新">
	</form>

	<form action="tbsystem_user/MyPageServlet" method="Post">
		<input type="hidden" name="action" value="userInfo"> <input
			type="submit" value="戻る">
	</form>

</body>

<footer>
	<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>