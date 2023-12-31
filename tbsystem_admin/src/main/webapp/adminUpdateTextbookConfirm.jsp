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
	<div style="text-align: center">
		<font size="7">以下の教科書情報で更新しますか</font><br> <font size="3">教科書情報</font><br>

		ISBN：${isbn} <br> タイトル：${title} <br> 分類：${category_name} <br>
		著者：${author}

		<form action="/tbsystem_admin/AdminSearchTextbookServlet"
			method="Post">
			<input type="hidden" name="action" value="updateTextbookComplete">
			<input type="hidden" name="isbn" value=${isbn}>
			<input type="hidden" name="title" value=${title}>
			<input type="hidden" name="category_code" value=${category_code}>
			<input type="hidden" name="author" value=${author}>
			<input type="hidden" name="isbn_before" value=${isbn_before}>
			<input type="submit" value="はい">
		</form>
		<form action="/tbsystem_admin/AdminSearchTextbookServlet"
			method="Post">
			<input type="hidden" name="action" value="SearchTextbook"> <input
				type="submit" value="いいえ">
		</form>
	</div>
</body>

<footer>
	<div style="text-align: center">
		<small>© 2023 アベレージャーズ All Rights Reserved.</small>
	</div>
</footer>
</html>