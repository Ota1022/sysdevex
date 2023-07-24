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
					<li class="nav__item"><a href="/tbsystem_user/top.jsp"><img
							src="img/suniv_banner.png" alt="Suniv Banner" class="nav-logo">
					</a></li>
					<li class="nav__item"><a
						href="/tbsystem_user/TopServlet?action=display"><img
							src="img/display.png" alt="Display" class="nav-logo"></a>
					</li>
					<li class="nav__item"><a
						href="/tbsystem_user/TopServlet?action=mypage"><img
							src="img/mypage.png" alt="Mypage" class="nav-logo"></a></li>
					</li>
					<li class="nav__item"><a
						href="/tbsystem_user/TopServlet?action=login"><img
							src="img/logout.png" alt="Logout" class="nav-logo"></a></li>
			</nav>
		</div>

		<div class="site-header__end">
			<div class="search">
				<button class="search__toggle" aria-label="Open search">検索</button>
				<form class="search__form" action="/tbsystem_user/TopServlet"
					method="get">
					<label class="sr-only" for="search">検索</label> <input type="hidden"
						name="action" value="search"> <input type="search"
						name="query" id="search" placeholder="教科書名" />
					<button>検索</button>
				</form>
			</div>
		</div>
	</header>
	<script src="js/header-4.js"></script>
</body>

</html>
