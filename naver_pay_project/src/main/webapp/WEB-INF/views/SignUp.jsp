<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-03
  Time: 오후 6:58
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (session.getAttribute("SESSION_ID") != null) {
        response.sendRedirect("./index.jsp");
    }

%>
<form name="signupInfo" method="post" action="signup"
      onsubmit="return checkValue()">
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
  <h1>회원 가입 화면</h1>
</body>
</html>
</form>
