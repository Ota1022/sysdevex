<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除完了</title>
</head>
<body>
	<%@ include file="/header.jsp"%>
	<div style="text-align: center">
		<h2>商品を削除しました</h2>

		<p>
		<form action="/tbsystem_user/DisplayHistoryServlet" method="post">
			<table style="margin: auto">
				<td><input type="submit" value="確認"> <input
					type="hidden" name="action" value="returnDisplayHistory"></td>
			</table>
		</form>
		</p>
	</div>
</body>
<footer>
	<div style="text-align: center">
		<small>© 2023 アベレージャーズ All Rights Reserved.</small>
	</div>
</footer>
</html>