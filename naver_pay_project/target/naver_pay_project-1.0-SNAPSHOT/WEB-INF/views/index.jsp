<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-02
  Time: 오후 4:32
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Main</title>
  </head>
  <body>
    <h1>메인 화면 입니다.</h1>
    <button type="button" onclick="location.href='login'">로그인</button>
  </body>
</html>--%>
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <meta charset="utf-8">
  <link th:href="@{/css/bootstrap.min.css}"
        href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container" style="max-width: 600px">
  <div class="py-5 text-center">
    <h2>홈 화면</h2>
  </div>
  <div class="row">
    <div class="col">
      <button class="w-100 btn btn-secondary btn-lg" type="button"
              th:onclick="|location.href='@{/members/add}'|">
        회원 가입
      </button>
    </div>
    <div class="col">
      <button class="w-100 btn btn-dark btn-lg"
              onclick="location.href='items.html'"
              th:onclick="|location.href='@{/login}'|" type="button">
        로그인
      </button>
    </div>
  </div>
  <hr class="my-4">
</div> <!-- /container -->
</body>
</html>



