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
	<div class="main-content">
		<div style="text-align: center">
			<font size="7">この教科書は出品されているため、削除することができません</font><br> <font
				size="3">教科書情報</font><br> ISBN：${isbn} <br> タイトル：${title}
			<br> 分類：${category_name} <br> 著者：${author}


			<form action="/tbsystem_admin/AdminSearchTextbookServlet"
				method="Post">
				<input type="hidden" name="action" value="searchTextbook"> <input
					type="submit" value="戻る">
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