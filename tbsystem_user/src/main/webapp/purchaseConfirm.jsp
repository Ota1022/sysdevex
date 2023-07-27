<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入確認</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="styles/reset.min.css" />
<link rel="stylesheet" href="styles/style.css" />
</head>
<body>
	<jsp:include page="/header.jsp" />
	<div class="main-content">

		<div style="text-align: center">
			<h2>以下の情報で購入を確定しますか</h2>
		</div>

		<h2>商品情報</h2>
		<table>
			<tr>
				<td><div style="text-align: right">教科書名：</div></td>
				<td>${inventory.title }</td>
			</tr>
			<tr>
				<td><div style="text-align: right">著者名：</div></td>
				<td>${inventory.author }</td>
			</tr>
			<tr>
				<td><div style="text-align: right">値段：</div></td>
				<td>${inventory.price }円</td>
			</tr>
		</table>

		<h2>購入者情報</h2>
		<table>
			<tr>
				<td><div style="text-align: right">氏名：</div></td>
				<td>${user.name }</td>
			</tr>
			<tr>
				<td><div style="text-align: right">電話番号：</div></td>
				<td>${user.tel }</td>
			</tr>
			<tr>
				<td><div style="text-align: right">住所：</div></td>
				<td>${user.address }</td>
			</tr>
			<tr>
				<td><div style="text-align: right">大学メールアドレス：</div></td>
				<td>${user.email }</td>
			</tr>
		</table>

		<br>

		<table style="margin: auto">
			<tr>
				<td>
					<form action="/tbsystem_user/PurchaseServlet" method="post">
						<input type="hidden" name="action" value="purchaseComplete">
						<input type="hidden" name="inventory_id"
							value="${inventory.inventoryID }"> <input type="submit"
							value="はい">
					</form>
				</td>
				<td>
					<form action="/tbsystem_user/PurchaseServlet" method="post">
						<input type="hidden" name="action" value="itemDetail"> <input
							type="hidden" name="inventory_id"
							value="${inventory.inventoryID }"> <input type="hidden"
							name="category_code" value="${categoryCode }"> <input
							type="hidden" name="query" value="${query}"> <input
							type="submit" value="いいえ">
					</form>
				</td>
			</tr>
		</table>
</body>
<footer>
	<div style="text-align: center">
		<small>© 2023 アベレージャーズ All Rights Reserved.</small>
	</div>
</footer>
</html>