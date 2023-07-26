<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規会員登録</title>
</head>
<body>

	<div style="text-align: center">
		<h1>新規会員登録</h1>
	</div>


	${message}
	<br>
	<table style="margin: auto">
		<tr>
			<td><div style="text-align: right">氏名：</div></td>
			<td>${name }</td>
		</tr>
		<tr>
			<td><div style="text-align: right">大学メールアドレス：</div></td>
			<td>${email }</td>
		</tr>
		<tr>
			<td><div style="text-align: right">住所：</div></td>
			<td>${address }</td>
		</tr>
		<tr>
			<td><div style="text-align: right">電話番号：</div></td>
			<td>${tel }</td>
		</tr>
		<tr>
			<form action="/tbsystem_user/LoginServlet" method="post">
				<input type="hidden" value="${name }" name="name"> <input
					type="hidden" value="${email }" name="email"> <input
					type="hidden" value="${address }" name="address"> <input
					type="hidden" value="${tel }" name="tel"> <input
					type="hidden" value="${password }" name="password"> <input
					type="hidden" value="sendEmail" name="action">
				<td></td>
				<td>
					<div style="text-align: center">
						<input type="submit" value="決定">
					</div>
				</td>
			</form>
		</tr>
	</table>

</body>
<footer>
	<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>