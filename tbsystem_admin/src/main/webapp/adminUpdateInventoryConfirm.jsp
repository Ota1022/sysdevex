<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者画面</title>
</head>
<body>
	<div style="text-align: center">
		<h3>以下の在庫情報を更新しますか</h3>
	</div>
	<h3>在庫情報</h3>

	在庫ID：${inventory.inventoryID}
	<br> タイトル：${inventory.title}
	<br> 出品者会員名：${inventory.userNameSeller}
	<br> 会員：${inventory.userIDSeller}
	<br> 出品価格：${price}
	<br> 在庫：${inventory.isinInventoryName}
	<br> 状態：${state_name}
	<br> コメント：${note}
	<br>
	<form action="/tbsystem_admin/AdminSearchInventoryServlet" method="get">
		<input type="submit" value="はい"> <input type="hidden"
			name="action" value="updateInventoryComplete"> <input
			type="hidden" name="inventory_id" value="${inventory.inventoryID}">
		<input type="hidden" name="price" value="${price}"> <input
			type="hidden" name="state_name" value="${state_name}"> <input
			type="hidden" name="note" value="${note}">
	</form>

	<form action="/tbsystem_admin/AdminSearchInventoryServlet" method="get">
		<input type="submit" value="いいえ"> <input type="hidden"
			name="action" value="updateInventory"> <input type="hidden"
			name="inventory_id" value="${inventory.inventoryID}">

	</form>
</body>
<footer>
	<div style="text-align: center">
		<small>© 2023 アベレージャーズ All Rights Reserved.</small>
	</div>
</footer>
</html>