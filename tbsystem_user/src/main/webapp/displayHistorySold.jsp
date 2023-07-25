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
<h1>出品した商品(売却済み)</h1>

<!--<c:forEach items="${items}" var="item">-->
	タイトル：${item.title}<br>
	分類：${item.category}<br>
	著者名：${item.author}<br>
	値段：${item.price}<br>
	売却日：${item.sellDate}	
	<hr>
<!--</c:forEach>-->
</div>

</body>
<footer>
<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>