<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除完了</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="styles/reset.min.css" />
<link rel="stylesheet" href="styles/style.css" />
</head>
<body>
<jsp:include page="/header.jsp" />
<div class="main-content">
<div style="text-align: center">
<h2>商品を削除しました</h2>

<p>
<form action="/tbsystem_user/MyPageServlet" method="post">
<input type="submit" value="確認">
<input type="hidden" name="action" value="displayHistory">
<input type="hidden" name="isin_inventory_code" value="1">
</div>
</div>
</body>
<footer>
<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>