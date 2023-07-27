<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<style>
.right {
	margin-right: 100px;
	text-align: right
}

.left {
	margin-left: 100px;
	text-align: left
}

.example2 {
	width: 70px;
	padding: 4px;
}
</style>
<head>
<meta charset="UTF-8">
<title>出品商品削除</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="styles/reset.min.css" />
<link rel="stylesheet" href="styles/style.css" />
</head>
<body>
	<%@ include file="/header.jsp"%>
	<div style="text-align: center">
		<h1>以下の商品を本当に削除しますか？</h1>
		<h2>商品情報</h2>
			<p>タイトル：${title}</p>
			<p>著者名：${author}</p>
			<p>値段：${price}円</p>
			<p>コメント：${note}</p>
			<div class="right">
				<p>
				<table>
					<td>
						<form action="/tbsystem_user/DisplayHistoryServlet" method="post">
								<input type="submit" value="はい" class="example2">
								<input type="hidden" name="action" value="deleteItemComplete">
								<input type="hidden" name="inventory_id" value="${inventory_id}">
						</form>
					</td>

					<td>
						<form action="/tbsystem_user/MyPageServlet" method="post">
							<input type="submit" value="いいえ" class="example2">
							<input type="hidden" name="action" value="displayHistory">
							<input type="hidden" name="isin_inventory_code" value="1">
						</form>
					</td>
				</table>
				</p>
			</div>
	</div>

</body>
<footer>
	<div style="text-align: center">
		<small>© 2023 アベレージャーズ All Rights Reserved.</small>
	</div>
</footer>
</html>