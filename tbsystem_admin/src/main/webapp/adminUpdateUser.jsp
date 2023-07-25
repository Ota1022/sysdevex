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
	<jsp:include page="/adminHeader.jsp" />
	<div class="main-content">
		<div style="text-align: center">
			<font size="7">会員情報の更新</font><br>
		</div>
		<h1>更新したいものを入力してください</h1>
		<form action="/tbsystem_admin/AdminSearchUserServlet" method="Post">
			<input type="hidden" name="user_id" value=${user.userID}> 氏名：<input
				type="text" name="name" value=${user.name } required> <br>
			住所：<input type="text" name="address" value=${user.address } required>
			<br> 電話番号： <input type="text" name="tel1" required> - <input
				type="text" name="tel2" required> - <input type="text"
				name="tel3" required> <br> 大学メールアドレス： <input
				type="text" name="email" value=${user.email } required> <br>
			<input type="hidden" name="action" value="userConfirm"> <input
				type="submit" value="更新">
		</form>
		<form action="/tbsystem_admin/AdminSearchUserServlet" method="Post">
			<input type="hidden" name="action" value="SearchUser"> <input
				type="submit" value="戻る">
		</form>
		<!--${user.userID}あなたのユーザID-->
	</div>
</body>
<footer>
	<div style="text-align: center">
		<small>© 2023 アベレージャーズ All Rights Reserved.</small>
	</div>
</footer>
</html>