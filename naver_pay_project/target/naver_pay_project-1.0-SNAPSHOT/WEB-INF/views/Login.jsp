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
    <%--로그아웃--%>
    <form action="logout" method="post">
        <input type="submit" value="로그아웃">
    </form>

    <%--내 정보--%>
    <form action="myInfo" method="post">
        <button type="button" onclick="location.href='login/myinfo'">내 정보</button>
    </form>

    <%--회원가입--%>
    <form action="join" method="post">
        <input type="submit" value="회원가입">
    </form>

    <%--회원탈퇴--%>
    <form action="delete" method="post">
        <input type="submit" value="회원탈퇴">
    </form>
    <title>Login</title>
</head>
<body>
    <h1> 로그인 화면 입니다. </h1>

    <%--로그인구현--%>
    <form action="login" method="post">
        아이디 :
        <input type="text" name="id" placeholder="아이디 입력">
        비밀번호 :
        <input type="password" name="password" placeholder="비밀번호 입력">
        <input type="submit" value="로그인">
    </form>
    <button type="button" onclick="location.href='shopping/getShoppingList'">(날짜 입력 전)주문 목록 리스트로 이동하기</button>
    <button type="button" onclick="location.href='shopping/getSearchDate'">(날짜 입력 후)주문 목록 리스트로 이동하기</button>
</body>
</html>
