<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>出品商品検索</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="styles/reset.min.css" />
<link rel="stylesheet" href="styles/style.css" />
<style>
.centered-form {
	margin: 0 auto; /* Centers the form */
	text-align: left;
	width: 50%; /* Adjust to suit */
}
</style>

</head>
<body>
	<jsp:include page="/header.jsp" />
	<div class="main-content">
		<div style="text-align: center">
			<h2>商品の情報を入力してください</h2>
			<form action="/tbsystem_user/DisplayItemServlet" method="post">
				<table class="centered-form">
					<tr>
						<td><div style="text-align: right">ISBN：</div></td>
						<td>${textbook.isbn }</td>
					</tr>
					<tr>
						<td><div style="text-align: right">タイトル：</div></td>
						<td>${textbook.title }</td>
					</tr>
					<tr>
						<td><div style="text-align: right">分類：</div></td>
						<td>${textbook.categoryName }</td>
					</tr>
					<tr>
						<td><div style="text-align: right">著者名：</div></td>
						<td>${textbook.author }</td>
					</tr>
					<tr>
						<td><div style="text-align: right">状態：</div></td>
						<td><select name="state_code">
								<option value="0">新品、未使用</option>
								<option value="1">未使用に近い</option>
								<option value="2">目立った傷や汚れなし</option>
								<option value="3">やや傷や汚れあり</option>
								<option value="4">傷や汚れあり</option>
								<option value="5">全体的に状態が悪い</option>
						</select></td>
					</tr>
					<tr>
						<td><div style="text-align: right" required>売値：</div></td>
						<td><input type="text" name="price"></td>
					</tr>
					<tr>
						<td><div style="text-align: right">コメント：</div></td>
						<td><textarea name="note" rows="5" cols="33"
								style="vertical-align: top"></textarea></td>
					</tr>
					<tr>
						<td></td>
						<td style="text-align: right"><input type="hidden"
							name="action" value="returnDisplayHistory"> <input
							type="hidden" name="isbn" value="${textbook.isbn }"> <input
							type="submit" value="出品"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<footer>
		<div style="text-align: center">
			<small>© 2023 アベレージャーズ All Rights Reserved.</small>
		</div>
	</footer>
</body>
</html>