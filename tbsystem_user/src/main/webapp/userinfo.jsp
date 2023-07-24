<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ情報</title>
</head>
<body>
	<div style="text-align: center">
		<font size="7">以下の情報で登録されています</font><br>
	</div>

	氏名：${name}<br>
	大学メールアドレス：${email}<br>
	住所：${email}<br>
	電話番号：${tel}

	<form action="tbsystem_user/MyPageServlet" method="Post">
		<input type="hidden" name="action" value="updateUser">
		<input type="text" name="password"> <input type="submit"
			value="更新">
	</form>
	<form action="tbsystem_user/MyPageServlet" method="Post">
		<input type="hidden" name="action" value="deleteUserForm"> <input
			type="submit" value="退会">
	</form>

</body>

<footer>
	<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>