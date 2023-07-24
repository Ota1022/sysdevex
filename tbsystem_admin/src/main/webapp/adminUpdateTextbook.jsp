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

	<div style="text-align: center">
		<font size="7">教科書情報の更新</font><br>
	</div>
	更新したいものを入力してください
	<br>

	<form action="/tbsystem_admin/AdminSearchTextbookServlet" method="post">
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
				<td><select name="categoryCheck">
						<option>カテゴリを選択してください</option>
						<c:forEach items="${categoryList}" var="category">
							<option value="${category.category_code }">${category.category_name }</option>
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
					name="action" value="updateTextbookConfirm"> <input
					type="submit" value="更新"></td>
			</tr>
		</table>
	</form>
	<form action="/tbsystem_admin/AdminSearchTextbookServlet" method="Post">
		<input type="hidden" name="action" value="adminSearchTextbook">
		<input type="submit" value="戻る">
	</form>



</body>

<footer>
	<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>