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

	<h1>会員の検索</h1>

	<form action="/tbsystem_admin/AdminSearchUserServlet" method="post">
		<select name="category">
			<!--<option value="user_id">ID</option>-->
			<option value="name">氏名</option>
			<option value="address">住所</option>
			<option value="tel">電話番号</option>
			<option value="email">大学メールアドレス</option>
			<!--<option value="birthday">生年月日</option>-->
			<!--<option value="regist_day">入会年月日</option>-->
		</select> <input type="text" name="text"> <input type="hidden"
			name="action" value="returnSearchUser"> <input type="submit"
			value="検索">

	</form>

	<table border="1">
		<tr>
			<td><b>ID</td>
			<td><b>氏名</b></td>
			<td><b>住所</b></td>
			<td><b>電話番号</b></td>
			<td><b>大学メールアドレス</b></td>
			<td><b>生年月日</b></td>
			<td><b>入会年月日</b></td>
			<td><b>更新</b></td>
			<td><b>削除</b></td>
		</tr>
		<c:forEach items="${user}" var="user">

			<tr>
				<td>${user.userID}</td>
				<td>${user.name}</td>
				<td>${user.address}</td>
				<td>${user.tel}</td>
				<td>${user.email}</td>
				<td>${user.birthday}</td>
				<td>${user.regist_date}</td>
				<td>
					<form action="/tbsystem_admin/AdminSearchUserServlet" method="post">
						<input type="hidden" name="action" value="updateUser"> <input
							type="hidden" name="user_id" value=${user.userID}> <input
							type="submit" value="更新">
					</form>
				</td>
				<td>
					<form action="/tbsystem_admin/AdminSearchUserServlet" method="post">
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