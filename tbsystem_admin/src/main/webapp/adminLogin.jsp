<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者ログイン</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="styles/reset.min.css" />
<link rel="stylesheet" href="styles/style.css" />
</head>
<body>
	<header class="site-header">
		<div class="site-header__start">
			<nav class="nav">
				<button class="nav__toggle" aria-expanded="false" type="button">
					menu</button>
				<ul class="nav__wrapper">
					<li class="nav__item"><a href="/tbsystem_admin/adminLogin.jsp"><img
							src="img/suniv_banner.png" alt="Suniv Banner" class="nav-logo">
					</a></li>
			</nav>
		</div>
	</header>
	<script src="js/header-4.js"></script>
	<div class="main-content">
		<div style="text-align: center">
			<font size="6">管理者ログイン</font>
			<form action="/tbsystem_admin/AdminLoginServlet" method="post">
				<br>
				<table style="margin: auto; border: 0;">
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
	</div>
	<footer>
		<div style="text-align: center">
			<small>© 2023 アベレージャーズ All Rights Reserved.</small>
		</div>
	</footer>
</body>
</html>