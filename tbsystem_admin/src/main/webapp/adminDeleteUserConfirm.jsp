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

	<div style="text-align: center">
		<font size="7">以下の会員情報を本当に削除しますか</font><br> <font size="3">会員情報</font><br>
	</div>
	ID:${user.userID}
	<br>氏名：${user.name}
	<br> 住所：${user.email}
	<br> 電話番号：${user.tel}
	<br>大学メールアドレス：${user.email}
	<br>生年月日:${user.birthday}
	<br>入会年月日:${user.regist_date}

	<form action="/tbsystem_admin/AdminSearchUserServlet" method="Post">
		<input type="hidden" name="action" value="deleteUserComplete">
		<input type="hidden" name="user_id" value=${user.userID}>
		<input type="submit" value="はい">
	</form>
	<form action="/tbsystem_admin/AdminSearchUserServlet" method="Post">
		<input type="hidden" name="action" value="SearchUser"> <input
			type="submit" value="いいえ">
	</form>
</body>
<footer>
	<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>