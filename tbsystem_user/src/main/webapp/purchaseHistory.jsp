<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入履歴</title>
</head>
<body>
<div style="text-align: center">
<h1>購入した商品</h1>

<c:forEach items="${items}" var="item">
	購入日：${item.sellDate}<br>
	タイトル：${item.title}<br>
	著者名：${item.author}<br>
	買値：${item.price}<br>
	<hr>
</c:forEach>
</div>

</body>
<footer>
<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>