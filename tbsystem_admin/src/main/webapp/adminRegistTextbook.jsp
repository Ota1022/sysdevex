<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教科書登録</title>
</head>
<body>
	<jsp:include page="/adminHeader.jsp" />
	<div class="main-content">
		<div style="text-align: center">
			<font size="6">教科書登録</font>
			<p>登録内容を入力してください
			<p>
				<br>
			<form action="/tbsystem_admin/AdminRegistTextbookServlet"
				method="post">
				<table style="margin: auto;" border="1">
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
									<option value="${category.categoryID}">${category.categoryName}</option>
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
							name="action" value="registTextbookConfirm"> <input
							type="submit" value="登録"></td>
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