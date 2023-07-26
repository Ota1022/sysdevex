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
</style>
<head>
<meta charset="UTF-8">
<title>出品履歴</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="styles/reset.min.css" />
<link rel="stylesheet" href="styles/style.css" />
</head>
<body>
<jsp:include page="/header.jsp" />
<div class="main-content">

<div style="text-align: center">
<a href="/tbsystem_user/MyPageServlet?action=displayHistory&isin_inventory_code=1">出品中</a>|
<a href="/tbsystem_user/MyPageServlet?action=displayHistory&isin_inventory_code=0">売却済み</a>|
<a href="/tbsystem_user/MyPageServlet?action=displayHistory&isin_inventory_code=2">出品停止</a>|
<h1>出品した商品(出品中)</h1>

<c:forEach items="${items}" var="item">
	タイトル：${item.title}<br>
	著者名：${item.author}<br>
	値段：${item.price}
	<br>
	</form>
	
	<div class="right">
	<form action="/tbsystem_user/DisplayHistoryServlet" method="post">
	<input type="submit" value="更新">
	<input type="hidden" name="action" value="updateItem">
	<input type="hidden" name="inventory_id" value="${item.inventoryID}">
	<input type="hidden" name="title" value="${item.title}">
	<input type="hidden" name="author" value="${item.author}">
	<input type="hidden" name="state_code" value="${item.stateCode}">
	<input type="hidden" name="price" value="${item.price}">
	<input type="hidden" name="note" value="${item.note}">
	</form>
	
	<form action="/tbsystem_user/DisplayHistoryServlet" method="post">
	<input type="submit" value="削除">
	<input type="hidden" name="action" value="deleteItemConfirm">
	<input type="hidden" name="inventory_id" value="${item.inventoryID}">
	<input type="hidden" name="title" value="${item.title}">
	<input type="hidden" name="author" value="${item.author}">
	<input type="hidden" name="price" value="${item.price}">
	</form>
	</div>
	
	<hr>
</c:forEach>
</div>
</div>
</body>
<footer>
<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>