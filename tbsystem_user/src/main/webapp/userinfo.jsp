<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報</title>
</head>
<body>
	<%@ include file="/header.jsp"%>
	<div style="text-align: center">
		<font size="7">以下の情報で登録されています</font><br>
	</div>
	<p>氏名：${user.name}</p>
	<p>大学メールアドレス：${user.email}</p>
	<p>住所：${user.address}</p>
	<p>電話番号：${user.tel}</p>

	<table>
	<td>
	<form action="/tbsystem_user/MyPageServlet" method="Post">
		<input type="hidden" name="action" value="updateUser">
		<p>
		<input type="submit" value="更新">
	</form>
	</td>
	<td>
	<form action="/tbsystem_user/MyPageServlet" method="Post">
		<input type="hidden" name="action" value="deleteUserForm">
		<input type="submit" value="退会">
		</p>
	</form>
	</td>
	</table>

</body>

<footer>
	<div style="text-align: center">
		<small>© 2023 アベレージャーズ All Rights Reserved.</small>
	</div>
</footer>
</html>