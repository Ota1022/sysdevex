<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者トップ</title>
</head>
<body>
	<jsp:include page="/adminHeader.jsp" />
	<div style="text-align: center">
		<h3>以下の在庫情報を出品停止しますか</h3>
	</div>
	<h3>在庫情報</h3>
	在庫ID：${inventory.inventoryID}
	<br> タイトル：${inventory.title}
	<br> 出品者会員名：${inventory.userNameSeller}
	<br> 会員：${inventory.userIDSeller}
	<br> 出品価格：${inventory.price}
	<br> 在庫：${inventory.isinInventoryName}
	<br> 状態：${inventory.stateName}
	<br> コメント：${inventory.note}
	<br>
	<form action="/tbsystem_admin/AdminSearchInventoryServlet" method="get">
		<input type="submit" value="はい"> <input type="hidden"
			name="action" value="stopInventoryComplete"> <input
			type="hidden" name="inventory_id" value="${inventory.inventoryID}">
	</form>

	<form action="/tbsystem_admin/AdminSearchInventoryServlet" method="get">
		<input type="submit" value="いいえ"> <input type="hidden"
			name="action" value="searchInventory"> <input type="hidden"
			name="inventory_id" value="${inventory.inventoryID}">
	</form>
</body>
<footer>
	<div style="text-align: center">
		<small>© 2023 アベレージャーズ All Rights Reserved.</small>
	</div>
</footer>
</html>