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
    <link rel="stylesheet" href="../../resources/css/Login.css">
</head>
<body>
    <h1> 로그인 화면 입니다. </h1>
    <div class="container">
        <div class="section-1">
            <button>로그아웃</button>
            <button>내 정보</button>
            <button>회원 탈퇴</button>
        </div>
        <div class="section-2">
            <form action="login" method="post">
                아이디 :
                <input type="text" name="Id" placeholder="아이디 입력">
                비밀번호 :
                <input type="password" name="password" placeholder="비밀번호 입력">
                <button type="submit">로그인</button>
            </form>
        </div>
        <div class="section-3">
<%--            action="shoppingList" method="post"--%>
            <button type="button" onclick="location.href='shoppingList'">주문 목록 리스트로 이동하기</button>
        </div>
    </div>
</body>
</html>
