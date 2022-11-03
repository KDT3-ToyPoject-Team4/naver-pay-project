<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-03
  Time: 오전 2:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${userName}Info</title>
</head>
<body>

<h1>내 정보</h1>
<p>아이디 : ${user.userId}</p>
<p>비밀번호 : ${user.password}</p>
<p>이름 : ${user.userName}</p>
<p>이메일 : ${user.point}</p>
<p>전화번호 : ${user.phoneNumber}</p>
<p>주소 : ${user.address}</p>
</body>
</html>
