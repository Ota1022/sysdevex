<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

	<h1>出品する教科書の情報を入力してください</h1>

	<form action="/tbsystem_user/DisplayItemServlet" method="post">
		<table>
			<tr>
				<td><div style="text-align: right">ISBN：</div></td>
				<td><input type="text" name="isbn"></td>
			</tr>
			<tr>
				<td><div style="text-align: right">タイトル：</div></td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td><div style="text-align: right">分類：</div></td>
				<td><select name="category_code">
						<option value="">カテゴリを選択してください</option>
						<c:forEach items="${categoryList}" var="category">
							<option value="${category.categoryID }">${category.categoryName }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><div style="text-align: right">著者名：</div></td>
				<td><input type="text" name="author"></td>
			</tr>
			<tr>
				<td></td>
				<td style="text-align: right"><input type="hidden"
					name="action" value="displayItemSearchResult"> <input
					type="submit" value="検索"></td>
			</tr>
		</table>
	</form>

</body>
<footer>
	<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>