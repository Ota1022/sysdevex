<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教科書情報の更新確認</title>
</head>
<body>
	<jsp:include page="/adminHeader.jsp" />
	<div class="main-content">
		<div style="text-align: center">
			<font size="7">以下の教科書情報で登録しますか</font><br> <font size="3">教科書情報</font><br>

		ISBN：${textbook.isbn} <br> タイトル：${textbook.title} <br> 分類：${textbook.categoryName} <br>
		著者：${textbook.author}

		<form action="/tbsystem_admin/AdminRegistTextbookServlet"
			method="Post">
			<input type="hidden" name="action" value="registTextbookComplete">
			<input type="submit" value="はい">
			<input type="hidden" name="isbn" value="${textbook.isbn}">
			<input type="hidden" name="title" value="${textbook.title}">
			<input type="hidden" name="category_code" value="${textbook.categoryCode}">
			<input type="hidden" name="author" value="${textbook.author}">
		</form>
		<form action="/tbsystem_admin/AdminRegistTextbookServlet"
			method="Post">
			<input type="hidden" name="action" value="registTextbook"> 
			<input type="submit" value="いいえ">
		</form>
	</div>
</body>

<footer>
	<div style="text-align: center">
		<small>© 2023 アベレージャーズ All Rights Reserved.</small>
	</div>
</footer>
</html>