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
<h1>更新したい情報を入力してください</h1>
<div class="left">
<h2>商品情報</h2>
<form action="/tbsystem_user/DisplayHistoryServlet" method="post">
<input type="hidden" name="inventory_id" value="${item.inventoryID}">
<p>タイトル：${item.title}</p>
<input type="hidden" name="title" value="${item.title}">
<p>著者名：${item.author}</p>
<p>状態：<select name="state_code">
<option value="0">新品・未使用</option>
<option value="1">未使用に近い</option>
<option value="2">目立った傷や汚れなし</option>
<option value="3">やや傷や汚れあり</option>
<option value="4">傷や汚れあり</option>
<option value="5">全体的に状態が悪い</option>
</select>
</p>
<p>値段：<input type="text" name="price" required>円</p>
</form>
<p>コメント：
<textarea name="note" rows="5" cols="33"></textarea>
</p>
</div>
	
	<div class="right">
	<p>
	<form action="/tbsystem_user/DisplayHistoryServlet" method="post">
	<input type="hidden" name="inventory_id" value="${item.inventoryID}">
	<input type="submit" value="更新" class="example2">
	<input type="hidden" name="action" value="updateItemConfirm">
	</form>
	
	<form action="/tbsystem_user/DisplayHistoryServlet" method="post">
	<input type="submit" value="戻る" class="example2">
	<input type="hidden" name="action" value="displayHistory">
	</form>
	</p>
	</div>

</div>

</body>
<footer>
<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>