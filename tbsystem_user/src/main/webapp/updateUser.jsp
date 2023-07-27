<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報の更新</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="styles/reset.min.css" />
<link rel="stylesheet" href="styles/style.css" />
</head>
<body>
<jsp:include page="/header.jsp" />
<div class="main-content">
	<div style="text-align: center">
		<font size="7">会員情報の更新</font><br>
	</div>
	<p>${message}</p>

	<form action="/tbsystem_user/MyPageServlet" method="Post">
		<table>
			<tr>
				<td style="text-align: right">氏名：</td>
				<td style="text-align: center">${user.name}</td>
			</tr>
			<tr>
				<td style="text-align: right">大学メールアドレス：</td>
				<td style="text-align: center">${user.email}</td>
			</tr>
			<tr>
				.
				<td style="text-align: right">住所：</td>
				<td style="text-align: center"><input type="hidden"
					name="action" value="updateUserConfirm"> <input type="text"
					name="address" value="${user.address}"></td>
			</tr>
			<tr>
				<td style="text-align: right">電話番号：</td>
				<td style="text-align: center"><input type="text" size="6"
					name="tel1">-<input type="text" size="6" name="tel2">-<input
					type="text" size="6" name="tel3"></td>
			</tr>

			<tr>
				<td style="text-align: right">パスワード：</td>
				<td style="text-align: center"><input type="password"
					name="password" required></td>
			</tr>

			<tr>
				<td style="text-align: center">パスワード(確認用)：</td>
				<td style="text-align: center"><input type="password"
					name="password_confirm" required></td>
			</tr>
			<tr>
				<td></td>
				<td style="text-align: right">
					<table>
						<input type="submit" value="更新">
						</form>

	<form action="/tbsystem_user/MyPageServlet" method="Post">
		<input type="hidden" name="action" value="userInfo"> <input
			type="submit" value="戻る"></p>
	</form>
</div>
</table>
</body>

<footer>
	<div style="text-align: center">
		<small>© 2023 アベレージャーズ All Rights Reserved.</small>
	</div>
</footer>
</html>