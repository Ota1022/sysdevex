<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>在庫検索</title>
</head>
<body>
	<jsp:include page="/adminHeader.jsp" />
	<div class="main-content">
		<div style="text-align: center">
			<font size="6">在庫検索</font><br>
			<form action="/tbsystem_admin/AdminSearchInventoryServlet"
				method="get">
				<select name="pull">
					<option value="title">タイトル</option>
					<option value="name">出品者会員名</option>
					<option value="inventory">在庫</option>
					<option value="state">状態</option>
					<option value="note">コメント</option>
				</select> <input type="text" name="query"> <input type="hidden"
					name="action" value="returnSearchInventory"> <input
					type="submit" value="検索">
			</form>
			<br>
			<table style="margin: auto;" border="1">
				<tr>
					<th>ID</th>
					<th>タイトル</th>
					<th>出品者会員名</th>
					<th>会員ID</th>
					<th>出品価格</th>
					<th>在庫</th>
					<th>状態</th>
					<th>コメント</th>
					<th>更新</th>
					<th>出品停止</th>
				</tr>
				<c:forEach items="${inventory}" var="invent">
					<c:if test="${ empty invent}">
		${no}
	</c:if>
					<c:if test="${not empty invent}">
						<tr>
							<td>${invent.inventoryID}</td>
							<td>${invent.title}</td>
							<td>${invent.userNameSeller}</td>
							<td>${invent.userIDSeller}</td>
							<td>${invent.price}</td>
							<td>${invent.isinInventoryName}</td>
							<td>${invent.stateName}</td>
							<td>${invent.note}</td>
							<th>
								<form action="/tbsystem_admin/AdminSearchInventoryServlet"
									method="get">
									<input type="hidden" name="action" value="updateInventory">
									<input type="hidden" name="inventory_id"
										value="${invent.inventoryID}"> <input type="submit"
										value="更新">
								</form>
							</th>
							<th>
								<form action="/tbsystem_admin/AdminSearchInventoryServlet"
									method="get">
									<input type="hidden" name="action" value="stopInventoryConfirm">
									<input type="hidden" name="inventory_id"
										value="${invent.inventoryID}"> <input type="submit"
										value="出品停止">
								</form>
							</th>
						</tr>
					</c:if>
				</c:forEach>
			</table>
		</div>
	</div>
	<footer>
		<div style="text-align: center">
			<small>© 2023 アベレージャーズ All Rights Reserved.</small>
		</div>
	</footer>
</body>
</html>