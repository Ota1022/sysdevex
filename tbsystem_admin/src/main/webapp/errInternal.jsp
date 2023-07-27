<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Input Error</title>
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
					<li class="nav__item"><a href="/tbsystem_admin/adminTop.jsp"><img
							src="img/suniv_banner.png" alt="Suniv Banner" class="nav-logo">
					</a></li>
			</nav>
		</div>
	</header>
	<script src="js/header-4.js"></script>
	<div class="main-content">
		<div style="text-align: center">
			<font size="6">${message}</font>
		</div>
	</div>
	<footer>
		<div style="text-align: center">
			<small>© 2023 アベレージャーズ All Rights Reserved.</small>
		</div>
	</footer>
</body>
</html>