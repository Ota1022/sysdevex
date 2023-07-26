<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<%@ include file="/header.jsp" %>
	<div class="main-content">

		<div style="text-align: center">

			<h1>教科書売買システム</h1>

			<select name="category_code" form="search_header">
				<option value="">全学部系</option>
				<c:forEach items="${categoryList}" var="category">
					<option value="${category.categoryID }">${category.categoryName }</option>
				</c:forEach>
			</select>
		</div>
	</div>
</body>
<footer>
	<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>