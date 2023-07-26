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
	<div style="text-align: center">
		<font size="7">以下の教科書情報を本当に削除しますか</font><br> <font size="3">教科書情報</font><br>

		ISBN：${isbn} <br> タイトル：${title} <br> 分類：${category_name} <br>
		著者：${author}

		<form action="/tbsystem_admin/AdminSearchTextbookServlet"
			method="Post">
			<input type="hidden" name="action" value="deleteTextbookComplete">
			<input type="submit" value="はい">
		</form>
		<form action="/tbsystem_admin/AdminSearchTextbookServlet"
			method="Post">
			<input type="hidden" name="action" value="returnSearchTextbook">
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