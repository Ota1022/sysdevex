<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教科書情報の更新</title>
</head>
<body>
	<jsp:include page="/adminHeader.jsp" />
	<div style="text-align: center">
		<font size="7">教科書情報の更新</font><br>
	</div>
	更新したいものを入力してください
	<br>

	<form action="/tbsystem_admin/AdminSearchTextbookServlet" method="post">
		<table>
			<tr>
				<td><div style="text-align: right">ISBN：</div></td>
				<td>${textbook.isbn}<input type="hidden" name="isbn"value=${textbook.isbn} required></td>
			</tr>
			<tr>
				<td><div style="text-align: right">タイトル：</div></td>
				<td><input type="text" name="title" value=${textbook.title} required></td>
			</tr>
			<tr>
				<td><div style="text-align: right">分類：</div></td>
				<td><select name="category_name" value=${textbook.categoryCode} required >
						<option value="0">文学部</option>
						<option value="1">教育学部</option>
						<option value="2">法学部</option>
						<option value="3">社会学部</option>
						<option value="4">経済学部</option>
						<option value="5">理学部</option>
						<option value="6">医学部</option>
						<option value="7">歯学部</option>
						<option value="8">薬学部</option>
						<option value="9">工学部</option>
						<option value="10">農学部</option>
						
						
				</select></td>
			</tr>
			<tr>
				<td><div style="text-align: right">著者名：</div></td>
				<td><input type="text" name="author" value=${textbook.author} required></td>
			</tr>
			<tr>
				<td></td>
				<td style="text-align: right"><input type="hidden"
					name="action" value="updateTextbookConfirm">
					<input type="hidden"
					name="isbn_before" value=${textbook.isbn}>
					
					 <input type="submit" value="更新"></td>
			</tr>
		</table>
	</form>
	<form action="/tbsystem_admin/AdminSearchTextbookServlet" method="Post">
		<input type="hidden" name="action" value="SearchTextbook">
		<input type="submit" value="戻る">
	</form>
</body>

<footer>
	<div style="text-align: center">
		<small>© 2023 アベレージャーズ All Rights Reserved.</small>
	</div>
</footer>
</html>