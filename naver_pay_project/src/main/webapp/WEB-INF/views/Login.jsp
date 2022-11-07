<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-02
  Time: 오후 4:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1> 로그인 화면 입니다. </h1>
<form action="/shopping/getShoppingList" method="post">
    <input type="text" name="userId">
    <input type="submit" value="확인">
    <button type="button" onclick="location.href='shopping/getShoppingList'">(날짜 입력 전)주문 목록 리스트로 이동하기</button>
    <button type="button" onclick="location.href='shopping/getSearchDate'">(날짜 입력 후)주문 목록 리스트로 이동하기</button>
</form>
</body>
</html>
