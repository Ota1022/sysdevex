<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>出品教科書検索</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="styles/reset.min.css" />
<link rel="stylesheet" href="styles/style.css" />
</head>
<body>
<jsp:include page="/header.jsp" />
<div class="main-content">

<h1>出品する教科書を選択してください</h1>

<form action="displayServlet" method="post">
<table>
	<c:forEach items="${textbookList}" var="textbook">
		<tr><td><input type="radio" name="isbn" value="${textbook.isbn }"></td><td><div style="text-align: right">ISBN：</div></td><td>${textbook.title }</td></tr>
		<tr><td></td><td><div style="text-align: right">タイトル：</div></td><td>${textbook.author }</td></tr>
		<tr><td></td><td><div style="text-align: right">分類：</div></td><td>${textbook.price }円</td></tr>
		<tr><td></td><td><div style="text-align: right">著者名：</div></td><td>${textbook.stateName }</td></tr>
	</c:forEach>
</table>

<div style="text-align: center">
<input type="submit" value="決定">
</div>
</form>

<div style="text-align: center">
	<c:if test="${not empty numPage }">
		<c:forEach var="i" begin="1" end="${numPage }" step="1">
			<a href="/tbsystem_user/PurchaseServlet?action=${action }&page=${i }">${i }</a>
		</c:forEach>
	</c:if>
</div>
</div>
</body>
<footer>
<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>