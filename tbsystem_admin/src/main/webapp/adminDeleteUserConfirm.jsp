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
		<font size="7">以下の会員情報を本当に削除しますか</font><br> <font size="3">会員情報</font><br>
	</div>
	ID:
	<br>氏名：${name}
	<br> 住所：${email}
	<br> 電話番号：${tel}
	<br>大学メールアドレス：${email}
	<br>生年月日:
	<br>入会年月日:

	<form action="/tbsystem_admin/AdminSearchUserServlet" method="Post">
		<input type="hidden" name="action" value="deleteUserComplete">
		<input type="submit" value="はい">
	</form>
	<form action="/tbsystem_admin/AdminSearchUserServlet" method="Post">
		<input type="hidden" name="action" value="searchUser"> <input
			type="submit" value="いいえ">
	</form>
</body>
<footer>
	<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>