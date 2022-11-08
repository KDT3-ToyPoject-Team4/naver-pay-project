<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
    <link rel="stylesheet" href="../../resources/css/CrawlingLogin.css">
</head>
<body>
    <div class="center">
        <h1>네이버 로그인</h1>
        <form action="crawlingResult" method="post">
            <div class="txt_field">
                <input type="text" name="userId" required>
                <span></span>
                <label>Username :</label>
            </div>
            <div class="txt_field">
                <input type="password" name="userPassword" required>
                <span></span>
                <label>Password :</label>
            </div>
            <input type="submit" value="로그인">
        </form>
    </div>
</body>
</html>
