<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教科書検索</title>
</head>
<body>
	<jsp:include page="/adminHeader.jsp" />
	<div class="main-content">
		<div style="text-align: center">
			<font size="6">教科書検索</font>
			<form action="/tbsystem_admin/AdminSearchTextbookServlet"
				method="post">
				<select name="category">
					<!--<option value="user_id">ID</option>-->
					<option value="title">タイトル</option>
					<option value="category_name">分類</option>
					<option value="author">著者名</option>
					<!--<option value="birthday">生年月日</option>-->
					<!--<option value="regist_day">入会年月日</option>-->
				</select> <input type="text" name="text"> <input type="hidden"
					name="action" value="returnSearchTextbook"> <input
					type="submit" value="検索">
			</form>
			<br>
			<table style="margin: auto;" border="1">
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
							<form action="/tbsystem_admin/AdminSearchTextbookServlet"
								method="post">
								<input type="hidden" name="action" value="updateTextbook">
								<input type="hidden" name="action" value="updateTextbook">
								<input
									<input type="hidden" name="isbn" value=${textbook.isbn}> 
							<input type="submit" value="更新">
							</form>
						</td>
						<td>
							<form action="/tbsystem_admin/AdminSearchTextbookServlet"
								method="post">
								<input type="hidden" name="action" value="deleteTextbookConfirm">
								<input type="hidden" name="isbn" value=${textbook.isbn}>
								<input type="submit" value="削除">
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<footer>
		<div style="text-align: center">
			<small>© 2023 アベレージャーズ All Rights Reserved.</small>
		</div>
	</footer>
</body>
</html>