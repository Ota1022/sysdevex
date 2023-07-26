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
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="styles/reset.min.css" />
<link rel="stylesheet" href="styles/style.css" />
</head>
<body>
<jsp:include page="/header.jsp" />
<div class="main-content">
<div style="text-align: center">
<h1>以下の情報で更新を確定しますか？</h1>
<h2>商品情報</h2>
<form action="/tbsystem_user/DisplayHistoryServlet" method="post">
<p>タイトル：${item.title}</p>
<p>著者名：${item.author}</p>
<p>状態：${item.stateCode}</p>
<input type="hidden" name="state_code" value="${item.stateCode}">
<p>値段：${item.price}円</p>
<input type="hidden" name="price" value="${item.price}">
<p>コメント：${item.note}</p>
<input type="hidden" name="note" value="${item.note}">
	
	<div class="right">
	<p>
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
</div>

</body>
<footer>
<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>