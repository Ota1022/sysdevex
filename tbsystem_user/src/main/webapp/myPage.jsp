<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<style>
.example{
    width: 300px;
    padding: 10px;
}
</style>

<head>
<meta charset="UTF-8">
<title>マイページ</title>
</head>
<body>


<div style="text-align: center">
<h1>マイページ</h1>

<form action="/tbsystem_user/MyPageServlet" method="post">
<input type="submit" value="購入した商品" class="example">
<input type="hidden" name="action" value="purchaseHistory"></form>
<br><br>
<form action="/tbsystem_user/MyPageServlet" method="post">
<input type="submit" value="出品した商品" class="example">
<input type="hidden" name="action" value="displayHistory"></form>
<br><br>
<form action="/tbsystem_user/MyPageServlet" method="post">
<input type="submit" value="会員情報照会" class="example">
<input type="hidden" name="action" value="userInfo">
</form>
</div>
</body>
<footer>
<small>© 2023 アベレージャーズ All Rights Reserved.</small>
</footer>
</html>