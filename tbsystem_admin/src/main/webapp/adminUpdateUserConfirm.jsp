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
			<font size="7">以下の会員情報で更新しますか</font><br> <font size="3">会員情報</font><br>
		</div>
		<p>ID:${user_id}</p>
		<p>氏名：${name}</p>
		<p>住所：${address}</p>
		<p>電話番号：${tel}</p>
		<p>大学メールアドレス：${email}</p>
	</div>
	<form action="/tbsystem_admin/AdminSearchUserServlet" method="Post">
		<input type="hidden" name="action" value="updateUserComplete">
		<input type="hidden" name="user_id" value=${user_id}> <input
			type="hidden" name="name" value=${name}> <input type="hidden"
			name="address" value=${address}> <input type="hidden"
			name="tel" value=${tel}> <input type="hidden" name="email"
			value=${email}> <input type="submit" value="はい">
	</form>
	<form action="/tbsystem_admin/AdminSearchUserServlet" method="Post">
		<input type="hidden" name="action" value="UpdateUser"> <input
			type="submit" value="いいえ">
	</form>
</body>
<footer>
	<div style="text-align: center">
		<small>© 2023 アベレージャーズ All Rights Reserved.</small>
	</div>
</footer>
</html>