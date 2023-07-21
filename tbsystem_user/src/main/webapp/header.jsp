<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--
<a href="/tbsystem_admin/TopServlet?action=top">トップ</a>

<form action="/tbsystem_admin/TopServlet" method="get">
	<input type="text" name="query"> <input type="hidden"
		name="action" value="search"> <input type="submit" value="検索">
</form>


<a href="/tbsystem_admin/TopServlet?action=display">出品</a>

<a href="/tbsystem_admin/TopServlet?action=mypage">マイページ</a>

<a href="/tbsystem_admin/TopServlet?action=login">ログアウト</a>

-->

<html lang="ja">

<head>
<meta charset="UTF-8" />
<title>ヘッダー</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="styles/reset.min.css" />
<link rel="stylesheet" href="styles/style.css" />
<link rel="stylesheet" href="styles/header-4.css" />
</head>

<body>
	<div class="wrapper">
		<header class="site-header">
			<div class="wrapper site-header__wrapper">
				<div class="site-header__start">
					<nav class="nav">
						<button class="nav__toggle" aria-expanded="false" type="button">
							menu</button>
						<ul class="nav__wrapper">
							<li class="nav__item active"><a
								href="/tbsystem_admin/TopServlet?action=top"> <img
									src="img/sunivlogo.png" alt="Suniv Logo" class="nav-logo">
							</a></li>
							<li class="nav__item"><a
								href="/tbsystem_admin/TopServlet?action=display"><span>出品</span></a>
							</li>
							<li class="nav__item"><a
								href="/tbsystem_admin/TopServlet?action=mypage"><span>マイページ</span></a></li>
							</li>
							<li class="nav__item"><a
								href="/tbsystem_admin/TopServlet?action=login"><span>ログアウト</span></a></li>
						</ul>
					</nav>
				</div>


				<div class="site-header__end">
					<div class="search">
						<button class="search__toggle" aria-label="Open search">
							検索</button>
						<form class="search__form" action="/tbsystem_admin/TopServlet"
							method="get">
							<label class="sr-only" for="search">検索</label> <input
								type="hidden" name="action" value="search"> <input
								type="search" name="query" id="search" placeholder="何をお探しですか？" />
							<button>検索</button>
						</form>
					</div>
				</div>
			</div>
		</header>
		<p>コンテンツ</p>

		<script src="js/header-4.js"></script>
	</div>
</body>

</html>