<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者トップ</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="styles/reset.min.css" />
<link rel="stylesheet" href="styles/style.css" />
<style>
.center-image {
	display: block;
	margin-left: auto;
	margin-right: auto;
	width: 40%;
}
</style>
</head>
<body>
	<jsp:include page="/adminHeader.jsp" />
	<div class="main-content">
		<div style="text-align: center">
			<font size="6">管理者トップ</font> <br> <img
				src="img/ShinjukuUniversityLogo.png" class="center-image">
		</div>
		<footer>
			<div style="text-align: center">
				<small>© 2023 アベレージャーズ All Rights Reserved.</small>
			</div>
		</footer>
</body>
</html>
