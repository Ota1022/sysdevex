<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トップ</title>
</head>
<body>



<div style="text-align: center">

<h1>教科書売買システム</h1>

<a href="/tbsystem_user/PurchaseServlet">全表示</a>
<c:forEach items="${categoryList }" var="category">
	<a href="/tbsystem_user/PurchaseServlet?=${category.categoryID }">${category.categoryName }</a>
</c:forEach>

</div>
</body>
<footer>
<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>