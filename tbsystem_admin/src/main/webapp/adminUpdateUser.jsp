<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者ページ</title>
</head>
<body>

	<div style="text-align: center">
		<font size="7">会員情報の更新</font><br>
	</div>
<h1>更新したいものを入力してください</h1>

<form action="/tbsystem_admin/AdminSearchUserServlet" method="Post">
	氏名：<input type="text" name="name" required> 
	<br> 住所：<input type="text" name="address" required>
		
	<br> 電話番号：
		<input type="text" name="tel1" required> 
		-
		<input type="text" name="tel2" required> 
		-
		<input type="text" name="tel3" required> 

	<br> 大学メールアドレス：
		<input type="text" name="password" required> 

<br>
		<input type="hidden" name="action" value="userConfirm">
		 <input type="submit" value="更新">
	</form>
	<form action="/tbsystem_admin/AdminSearchUserServlet" method="Post">
		<input type="hidden" name="action" value="adminSearchUser"> 
		<input	type="submit" value="戻る">
	</form>

</body>

<footer>
	<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>