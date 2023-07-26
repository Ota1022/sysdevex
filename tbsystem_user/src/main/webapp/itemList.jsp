<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="styles/reset.min.css" />
<link rel="stylesheet" href="styles/style.css" />
</head>
<body>
<jsp:include page="/header.jsp" />
<div class="main-content">


	<h1>検索結果</h1>

	<c:forEach items="${inventoryList }" var="inventory">

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
				<td><div style="text-align: right">分類：</div></td>
				<td>${inventory.categoryName }</td>
			</tr>
			<tr>
				<td><div style="text-align: right">値段：</div></td>
				<td>${inventory.price }円</td>
				<td><c:if test="${user.userID ne inventory.userIDSeller }">
						<form action="/tbsystem_user/PurchaseServlet" method="post">
							<input type="hidden" name="action" value="purchaseConfirm"><input
								type="hidden" name="inventory_id"
								value="${inventory.inventoryID }"><input type="submit"
								value="購入">
						</form>
					</c:if> <c:if test="${user.userID eq inventory.userIDSeller }">
						<form action="/tbsystem_user/DisplayHistoryServlet" method="post">
							<input type="hidden" name="action" value="updateItem"> <input
								type="hidden" name="inventory_id"
								value="${inventory.inventoryID }"> <input type="submit"
								value="更新">
						</form>
					</c:if></td>
				<td><form action="/tbsystem_user/PurchaseServlet" method="post">
						<input type="hidden" name="action" value="itemDetail"><input
							type="hidden" name="inventory_id"
							value="${inventory.inventoryID }"><input type="submit"
							value="詳細">
					</form></td>
			</tr>
		</table>

	</c:forEach>
	<br>
	<div style="text-align: center">
		<c:if test="${not empty numPage }">
			<c:forEach var="i" begin="1" end="${numPage }" step="1">
				<a
					href="/tbsystem_user/PurchaseServlet?action=${action }&page=${i }">${i }</a>
			</c:forEach>
		</c:if>
	</div>

</body>
<footer>
	<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>