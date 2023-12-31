<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<style>
.example {
	width: 300px;
	padding: 10px;
}
</style>

<head>
<meta charset="UTF-8">
<title>マイページ</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="styles/reset.min.css" />
<link rel="stylesheet" href="styles/style.css" />
</head>
<body>
<jsp:include page="/header.jsp" />
<div class="main-content">

	<div style="text-align: center">
		<h1>マイページ</h1>

		<table style="margin: auto">
		<tr><td>
		<form action="/tbsystem_user/MyPageServlet" method="post">
			<input type="submit" value="購入した商品" class="example">
			<input type="hidden" name="action" value="purchaseHistory">
		</form>
		</td></tr>
		<tr><td>
		<form action="/tbsystem_user/MyPageServlet" method="post">
			<input type="submit" value="出品した商品" class="example">
			<input type="hidden" name="action" value="displayHistory">
			<input type="hidden" name="isin_inventory_code" value="1">
		</form>
		</td></tr>
		<tr><td>
		<form action="/tbsystem_user/MyPageServlet" method="post">
			<input type="submit" value="会員情報照会" class="example">
			<input type="hidden" name="action" value="userInfo">
		</form>
		</td></tr>
		</table>
	</div>
	</div>
	</div>
</body>
<footer>
	<div style="text-align: center">
		<small>© 2023 アベレージャーズ All Rights Reserved.</small>
	</div>
</footer>
</html>