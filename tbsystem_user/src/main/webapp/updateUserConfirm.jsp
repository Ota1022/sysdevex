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
		<font size="7">以下の会員情報で更新しますか</font><br> <font size="3">会員情報</font><br>
	</div>

	氏名：${name}
	<br> 大学メールアドレス：${email}
	<br> 住所：${email}
	<br> 電話番号：${tel}

	<form action="/tbsystem_user/MyPageServlet" method="Post">
		<input type="hidden" name="action" value="updateUserComplete">
		<input type="submit" value="はい">
	</form>
	<form action="/tbsystem_user/MyPageServlet" method="Post">
		<input type="hidden" name="action" value="updateUser"> <input
			type="submit" value="いいえ">
	</form>

</body>

<footer>
	<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>