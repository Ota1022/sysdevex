<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者ページ</title>
</head>
<body>

	<h1>教科書の検索</h1>

	<form action="/tbsystem_admin/AdminSearchTextbookServlet" method="post">
		<select name="category">
			<!--<option value="user_id">ID</option>-->
			<option value="title">タイトル</option>
			<option value="category_name">分類</option>
			<option value="author">著者名</option>
			<!--<option value="birthday">生年月日</option>-->
			<!--<option value="regist_day">入会年月日</option>-->
		</select> <input type="text" name="text"> <input type="hidden"
			name="action" value="returnSearchTextbook"> <input type="submit"
			value="検索">

	</form>

	<table border="1">
		<tr>
			<td><b>ISBN番号</td>
			<td><b>タイトル</b></td>
			<td><b>分類</b></td>
			<td><b>著者名</b></td>
			<td><b>更新</b></td>
			<td><b>削除</b></td>
		</tr>
		<c:forEach items="${textbook}" var="textbook">

			<tr>
				<td>${textbook.isbn}</td>
				<td>${textbook.title}</td>
				<td>${textbook.categoryName}</td>
				<td>${textbook.author}</td>
				<td>
					<form action="/tbsystem_admin/AdminSearchTextbookServlet" method="post">
						<input type="hidden" name="action" value="updateUser"> <input
							type="hidden" name="user_id" value=${user.userID}> <input
							type="submit" value="更新">
					</form>
				</td>
				<td>
					<form action="/tbsystem_admin/AdminSearchTextbookServlet" method="post">
						<input type="hidden" name="action" value="deleteUserConfirm">
						<input type="hidden" name="user_id" value=${user.userID}>
						
						
						
						<input type="submit" value="削除">
					</form>

				</td>

			</tr>
		</c:forEach>



	</table>






</body>
<footer>
	<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>