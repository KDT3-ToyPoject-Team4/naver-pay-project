<%@ page import="java.util.Arrays" %>
<%@ page import="org.toyproject.controller.login.Status" %>
<%
//    if (session.getAttribute("SESSION_ID") != null) {
//        response.sendRedirect("./index.jsp");
//    }

%>

<%

    ///////////////// 쿠키 값 중 로그인하기 위해서 무조건 있어야하는 값이 없는지 확인 //////////////////
    String[] mustCookies = {"COOKIE_ID", "COOKIE_PW", "COOKIE_HASH_PW", "AUTO_LOGIN"};
    Cookie[] cookies = request.getCookies();
    String[] cookiesName = Arrays.stream(request.getCookies()).map(c -> c.getName()).toArray(String[]::new);
    boolean isMustCookies = false;
    for (int i = 0; i < mustCookies.length; i++) {
        if (cookiesName != null) {
            for (int j = 0; j < cookiesName.length; j++) {
                if (mustCookies[i].equals(cookiesName[j])) {
                    isMustCookies = true;
                    break;
                }
            }
            if (!isMustCookies) {
                break;
            }
        }
    }

    // 하나라도 없으면 쿠키에 저장된 모든 요소 다 삭제
    if (!isMustCookies) {
        for (int i = 0; i < mustCookies.length; i++) {
            if (cookies != null) {
                for (int j = 0; j < cookies.length; j++) {
                    if (mustCookies[i].equals(cookies[j].getName())) {
                        cookies[j].setMaxAge(0);
                        cookies[j].setPath("/");
                        response.addCookie(cookies[j]);
                    }
                }
            }
        }
    }
%>

<%
    //////////////////////////// 자동 로그인 시도 ///////////////////////////
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName() != null) {
                if (cookie.getName().equals("자동 로그인")) {
                    String value = cookie.getValue();
                    if (value.equals("true")) {
%>
<script>
    location.href = "./DoAutoLoginServlet";
</script>
<%
                    }
                }
            }
        }
    }
%>



<%

    if (session.getAttribute("Login") != null) {
        if (session.getAttribute("Login") == Status.FAIL) {
%>
<script>alert("Login Fail!")</script>
<%

} else if (session.getAttribute("Login") == Status.NULL) {

%>
<script>alert("Sign Up First.")</script>
<%
        }
        session.removeAttribute("Login");
    }
%>

<%

    if (session.getAttribute("signup") != null) {

        if (session.getAttribute("signup") == Status.SUCCESS) {

%>
<script>alert("Sign Up Success!")</script>
<%
        }
        session.removeAttribute("signup");
    }
%>

<!-- -->

<header>
</header>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>

<html>

<head>
    <title>로그인 화면</title>

    <script type="text/javascript">

        function checkValue()
        {
            inputForm = eval("document.LoginInfo");
            if(!inputForm.userId.value)
            {
                alert("아이디를 입력하세요");
                inputForm.userId.focus();
                return false;
            }
            if(!inputForm.userPassword.value)
            {
                alert("비밀번호를 입력하세요");
                inputForm.userPassword.focus();
                return false;
            }
        }

        <!--회원가입-->
        function goJoinForm() {
            location.href="signup";
        }
    </script>

</head>
<body>
<div id="wrap">
    <form name="LoginInfo" method="post" action="/Login"
          onsubmit="return checkValue()">

        <br>네이버 페이 프로젝트<br>

        <table>
            <tr>
                <div class="form__list">
                    <td bgcolor="PowderBlue">아이디</td>
                    <td><input type="text" id="userId" name="userId" maxlength="50"></td>
                </div>
            </tr>
            <tr>
                <div class="form__list">
                    <td bgcolor="PowderBlue">비밀번호</td>
                    <td><input type="password" id="userPassword" name="userPassword" maxlength="50"></td>
                </div>
            </tr>
        </table>
        <br>

        <input type="submit" value="로그인"/>

    </form>

</div>
</body>
</html>














