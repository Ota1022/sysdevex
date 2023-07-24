<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
</head>
<body>



<h1>検索結果</h1>

<c:forEach items="${inventoryList }" var="inventory">

<table>
	<tr><td><div style="text-align: right">教科書名：</div></td><td>${inventory.title }</td></tr>
	<tr><td><div style="text-align: right">著者名：</div></td><td>${inventory.author }</td></tr>
	<tr><td><div style="text-align: right">値段：</div></td><td>${inventory.price }円</td>
		<td><form action="/tbsystem_user/PurchaseServlet" method="post"><input type="hidden" name="action" value="purchaseConfirm"><input type="hidden" name="inventory_id" value="${inventory.inventoryID }"><input type="submit" value="購入"></form></td>
		<td><form action="/tbsystem_user/PurchaseServlet" method="post"><input type="hidden" name="action" value="itemDetail"><input type="hidden" name="inventory_id" value="${inventory.inventoryID }"><input type="submit" value="詳細"></form></td>
	</tr>
</table>

</c:forEach>
<br>
<div style="text-align: center">
	<c:if test="${not empty numPage }">
		<c:forEach var="i" begin="1" end="${numPage }" step="1">
			<a href="/tbsystem_user/PurchaseServlet?action=${action }&page=${i }">${i }</a>
		</c:forEach>
	</c:if>
</div>

</body>
<footer>
<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>