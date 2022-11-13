
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
  <head>
    <title>Main</title>
  </head>
  <body>
  <header>
    <jsp:include page="header.jsp"/>
  </header>
    <h1>메인 화면 입니다.</h1>
    <%if (session.getAttribute("SESSION_ID") == null){%>
      <button type="button" onclick="location.href='Login'">로그인</button>
      <button type="button" onclick="location.href='SignUp'">회원가입</button>
    <%}else{%>
      <button type="button" onclick="location.href='shopping/getShoppingList'">주문 목록 확인하기</button>
      <button type="button" onclick="location.href='logout'">로그아웃</button>
    <%}%>

  </body>
</html>
