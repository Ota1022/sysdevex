<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トップ画面</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="styles/reset.min.css" />
<link rel="stylesheet" href="styles/style.css" />
</head>
<body>
	<jsp:include page="/header.jsp" />
	<div class="main-content">
		


<div style="text-align: center">

<h1>教科書売買システム</h1>
		<p>コンテンツ</p>
	</div>

<a href="/tbsystem_user/PurchaseServlet">全表示</a>
<c:forEach items="${categoryList }" var="category">
	<a href="/tbsystem_user/PurchaseServlet?category_code=${category.categoryID }&action=itemList">${category.categoryName }</a>
</c:forEach>

<select name="categoryCheck" id="">
			<option>全学部系</option>
			<c:forEach items="${categoryList}" var="category">
				<option value="${category.category_code }">${category.category_name }</option>
			</c:forEach>
</select>

</div>
</body>
<footer>
<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>