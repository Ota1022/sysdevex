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
</head>
<body>
<div style="text-align: center">
<a href="/shopping/DisplayHistoryServlet?action=displayHistory&code=${isinInventoryCode}">出品中</a>|
<a href="/shopping/DisplayHistoryServlet?action=displayHistory&code=${isinInventoryCode}">売却済み</a>|
<a href="/shopping/DisplayHistoryServlet?action=displayHistory&code=${isinInventoryCode}">出品停止</a>|
<h1>出品した商品(出品中)</h1>

<!--<c:forEach items="${items}" var="item">-->
	<form action="/tbsystem_user/DisplayHistoryServlet" method="post">
	タイトル：${item.title}<br>
	<input type="hidden" name="title" value="${item.title}">
	</form>
	<form action="/tbsystem_user/DisplayHistoryServlet" method="post">
	著者名：${item.author}<br>
	<input type="hidden" name="author" value="${item.author}">
	値段：${item.price}<br>
	</form>
	
	<div class="right">
	<form action="/tbsystem_user/DisplayHistoryServlet" method="post">
	<input type="submit" value="更新">
	<input type="hidden" name="action" value="updateItem">
	</form>
	
	<form action="/tbsystem_user/DisplayHistoryServlet" method="post">
	<input type="submit" value="削除">
	<input type="hidden" name="action" value="deleteItemConfirm">
	</form>
	</div>
	
	<hr>
<!--</c:forEach>-->
</div>

</body>
<footer>
<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>