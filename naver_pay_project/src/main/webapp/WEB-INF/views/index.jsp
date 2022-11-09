<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-02
  Time: 오후 4:32
  To change this template use File | Settings | File Templates.
--%>
<header>
  <jsp:include page="header.jsp"/>
</header>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Main</title>
  </head>
  <body>
    <h1>메인 화면 입니다.</h1>
    <button type="button" onclick="location.href='Login'">로그인</button>
    <button type="button" onclick="location.href='signup'">회원가입</button>
    <button type="button" onclick="location.href='loading'">크롤링</button>
  </body>
</html>
