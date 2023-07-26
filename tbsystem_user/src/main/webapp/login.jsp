<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>

	<div style="text-align: center">
		<h1>ログイン</h1>
	</div>



	<form action="/tbsystem_user/LoginServlet" method="post">
		<table style="margin: auto">

			<tr>
				<td colspan="2"><div style="text-align: center">${message }</div></td>
			</tr>
			<tr>
				<td><div style="text-align: right">大学メールアドレス：</div></td>
				<td><div style="text-align: center">
						<input type="text" size="40" name="email" required>
					</div></td>
			</tr>
			<tr>
				<td><div style="text-align: right">パスワード：</div></td>
				<td><div style="text-align: center">
						<input type="password" size="40" name="password" required>
					</div></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<div style="text-align: right">
						<input type="submit" value="ログイン">
					</div>
				</td>
			</tr>
		</table>
		<input type="hidden" value="login" name="action">
	</form>

	<form action="/tbsystem_user/LoginServlet" method="post">
		<input type="submit" value="新規会員登録"> <input type="hidden"
			value="registUserForm" name="action">
	</form>

</body>
<footer>
	<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>