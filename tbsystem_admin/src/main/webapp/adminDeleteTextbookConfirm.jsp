<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教科書情報の削除確認</title>
</head>
<body>
<jsp:include page="/adminHeader.jsp" />
	<div style="text-align: center">
		<font size="7">以下の教科書情報を本当に削除しますか</font><br> <font size="3">教科書情報</font><br>

			ISBN：${textbook.isbn} <br> タイトル：${textbook.title} <br> 分類：${textbook.categoryName} <br>
			著者：${textbook.author}

			<form action="/tbsystem_admin/AdminSearchTextbookServlet"
				method="Post">
				<input type="hidden" name="action" value="deleteTextbookComplete">
				<input type="hidden" name="isbn" value=${textbook.isbn}>	
				<input type="submit" value="はい">
			</form>
			<form action="/tbsystem_admin/AdminSearchTextbookServlet"
				method="Post">
				<input type="hidden" name="action" value="returnSearchTextbook2">
				<input type="submit" value="いいえ">
			</form>
		</div>
	</div>
</body>

<footer>
	<div style="text-align: center">
		<small>© 2023 アベレージャーズ All Rights Reserved.</small>
	</div>
</footer>
</html>