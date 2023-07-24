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
.example2{
    width: 70px;
    padding: 4px;
}
</style>
<head>
<meta charset="UTF-8">
<title>出品商品更新</title>
</head>
<body>
<div style="text-align: center">
<h1>以下の情報で更新を確定しますか？</h1>
<h2>商品情報</h2>
<form action="/tbsystem_user/DisplayHistoryServlet" method="post">
<p>タイトル：${item.title}</p>
<input type="hidden" name="title" value="${item.title}">
<p>著者名：${item.author}</p>
<p>状態：${item.stateName}</p>
<input type="hidden" name="state_name" value="${item.stateName}">
<p>値段：${item.price}円</p>
<input type="hidden" name="price" value="${item.price}">
<p>コメント：${item.note}</p>
<input type="hidden" name="note" value="${item.note}">
	
	<div class="right">
	<p>
	<form action="/tbsystem_user/DisplayHistoryServlet" method="post">
	<input type="hidden" name="inventory_id" value="${item.inventoryID}">
	<input type="submit" value="はい" class="example2">
	<input type="hidden" name="action" value="updateItemComplete">
	</form>
	
	<form action="/tbsystem_user/DisplayHistoryServlet" method="post">
	<input type="submit" value="いいえ" class="example2">
	<input type="hidden" name="action" value="updateItem">
	</form>
	</p>
	</div>

</div>

</body>
<footer>
<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>