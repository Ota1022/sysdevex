<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品詳細</title>
</head>
<body>
<%@ include file="/header.jsp"%>


	<h1>商品情報</h1>

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
		<tr>
			<td><div style="text-align: right">状態：</div></td>
			<td>${inventory.stateName }</td>
		</tr>
		<tr>
			<td><div style="text-align: right">コメント：</div></td>
			<td>${inventory.note }円</td>
		</tr>
	</table>

	<c:if test="${user.userID ne inventory.userIDSeller }">
		<table style="margin: auto">
			<tr>
				<td>
					<form action="/tbsystem_user/PurchaseServlet" method="post">
						<input type="hidden" name="action" value="purchaseConfirm">
						<input type="hidden" name="inventory_id"
							value="${inventory.inventoryID }"> <input type="submit"
							value="購入">
					</form>
				</td>
				<td>
					<form action="/tbsystem_user/PurchaseServlet" method="post">
						<input type="hidden" name="action" value="returnItemList">
						<input type="submit" value="戻る">
					</form>
				</td>
			</tr>
		</table>
	</c:if>
	
	<c:if test="${user.userID eq inventory.userIDSeller }">
		<table style="margin: auto">
			<tr>
				<td>
					<form action="/tbsystem_user/DisplayHistoryServlet" method="post">
						<input type="hidden" name="action" value="updateItem">
						<input type="hidden" name="inventory_id"
							value="${inventory.inventoryID }"> <input type="submit"
							value="更新">
					</form>
				</td>
				<td>
					<form action="/tbsystem_user/PurchaseServlet" method="post">
						<input type="hidden" name="action" value="returnItemList">
						<input type="submit" value="戻る">
					</form>
				</td>
			</tr>
		</table>
	</c:if>
</body>
<footer>
	<div style="text-align: center">
		<small>© 2023 アベレージャーズ All Rights Reserved.</small>
	</div>
</footer>
</html>