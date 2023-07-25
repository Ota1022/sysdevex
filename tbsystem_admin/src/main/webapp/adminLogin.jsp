<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者ログイン</title>
</head>
<body>
	<div class="main-content">
		<div style="text-align: center">
			<h1>管理者ログイン</h1>
		</div>

		<form action="/tbsystem_admin/AdminLoginServlet" method="post">
			<table style="margin: auto">

				<tr>
					<td colspan="2"><div style="text-align: center">${message }</div></td>
				</tr>
				<tr>
					<td><div style="text-align: right">管理者メールアドレス：</div></td>
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
	</div>
</body>
<footer>
	<div style="text-align: center">
		<small>© 2023 アベレージャーズ All Rights Reserved.</small>
	</div>
</footer>
</html>