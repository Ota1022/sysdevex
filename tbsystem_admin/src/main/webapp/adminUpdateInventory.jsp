<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者画面</title>
</head>
<body>
	<jsp:include page="/adminHeader.jsp" />
	<h3>在庫情報の更新</h3>
	<h3>更新したいものを入力してください</h3>
	<form action="/tbsystem_admin/AdminSearchInventoryServlet" method="get">
		タイトル：${inventory.title}<br> 出品者会員名：${inventory.userNameSeller}<br>
		会員ID：${inventory.userIDSeller}<br> 出品価格：<input type="text"
			name="price" value="${inventory.price}"><br>
		在庫：${inventory.isinInventoryName}<br> 状態： <select
			name="state_name">
			<option value="0">新品、未使用</option>
			<option value="1">未使用に近い</option>
			<option value="2">目立った傷や汚れなし</option>
			<option value="3">やや傷や汚れあり</option>
			<option value="4">傷や汚れあり</option>
			<option value="5">全体的に状態が悪い</option>
		</select> <br> コメント：
		<textarea name="note">${inventory.note}</textarea>
		<br> <input type="submit" value="更新"> <input
			type="hidden" name="action" value="updateInventoryConfirm"> <input
			type="hidden" name="inventory_id" value="${inventory.inventoryID}">
	</form>
	<form action="/tbsystem_admin/AdminSearchInventoryServlet" method="get">
		<input type="submit" value="戻る"> <input type="hidden"
			name="action" value="adminSearchInventory">
	</form>
</body>
<footer>
	<div style="text-align: center">
		<small>© 2023 アベレージャーズ All Rights Reserved.</small>
	</div>
</footer>
</html>