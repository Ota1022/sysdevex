<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="ja">

<head>
<meta charset="UTF-8" />
<title>ヘッダー</title>
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
					<li class="nav__item"><a
						href="/tbsystem_admin/AdminSearchInventoryServlet"><img
							src="img/inventory_search.png" alt="searchInventory"
							class="nav-logo"></a></li>
					<li class="nav__item"><a
						href="/tbsystem_admin/AdminSearchUserServlet"><img
							src="img/member_search.png" alt="searchUser" class="nav-logo"></a></li>
					</li>
					<li class="nav__item"><a
						href="/tbsystem_admin/AdminRegistTextbookServlet"><img
							src="img/tb_regist.png" alt="registTextbook" class="nav-logo"></a></li>
					</li>
					<li class="nav__item"><a
						href="/tbsystem_admin/AdminSearchTextbookServlet"><img
							src="img/tb_search.png" alt="searchTextbook" class="nav-logo"></a></li>
					</li>
					<li class="nav__item"><a href="/tbsystem_admin/adminLogin.jsp"><img
							src="img/logout_admin.png" alt="Logout" class="nav-logo"></a></li>
			</nav>
		</div>
	</header>
	<script src="js/header-4.js"></script>
</body>

</html>
