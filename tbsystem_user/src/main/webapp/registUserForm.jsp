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
		<h1>新規会員登録</h1>
	</div>


	${message}
	<br>
	<form action="/tbsystem_user/LoginServlet" method="post">
		<table style="margin: auto">
			<tr>
				<td><div style="text-align: right">氏名：</div></td>
				<td><div style="text-align: center">
						<input type="text" size="40" name="name">
					</div></td>
			</tr>
			<tr>
				<td><div style="text-align: right">大学メールアドレス：</div></td>
				<td><div style="text-align: center">
						<input type="text" size="40" name="email">
					</div></td>
			</tr>
			<tr>
				<td><div style="text-align: right">住所：</div></td>
				<td><div style="text-align: center">
						<input type="text" size="40" name="address">
					</div></td>
			</tr>
			<tr>
				<td><div style="text-align: right">電話番号：</div></td>
				<td><div style="text-align: center">
						<input type="text" size="6" name="tel1">-<input
							type="text" size="6" name="tel2">-<input type="text"
							size="6" name="tel3">
					</div></td>
			</tr>
			<tr>
				<td><div style="text-align: right">パスワード：</div></td>
				<td><div style="text-align: center">
						<input type="password" size="40" name="password">
					</div></td>
			</tr>
			<tr>
				<td><div style="text-align: right">パスワード(確認用)：</div></td>
				<td><div style="text-align: center">
						<input type="password" size="40" name="password_confirm">
					</div></td>
			</tr>
			<tr>
				<td colspan="2">
					<div style="text-align: center">
						<input type="submit" value="決定">
					</div>
				</td>
			</tr>
		</table>
		<input type="hidden" value="registUserConfirm" name="action">
	</form>

</body>
<footer>
	<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>