<%@ page import="java.util.Arrays" %>
<%@ page import="org.toyproject.utils.Status" %>
<%
    if (session.getAttribute("SESSION_ID") != null) {
        response.sendRedirect("./index.jsp");
    }

%>

<%

    ///////////////// ��Ű �� �� �α����ϱ� ���ؼ� ������ �־���ϴ� ���� ������ Ȯ�� //////////////////
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

    // �ϳ��� ������ ��Ű�� ����� ��� ��� �� ����
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
    //////////////////////////// �ڵ� �α��� �õ� ///////////////////////////
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName() != null) {
                if (cookie.getName().equals("�ڵ� �α���")) {
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

    if (session.getAttribute("login") != null) {
        if (session.getAttribute("login") == Status.FAIL) {
%>
<script>alert("Login Fail!")</script>
<%

} else if (session.getAttribute("login") == Status.NULL) {

%>
<script>alert("Sign Up First.")</script>
<%
        }
        session.removeAttribute("login");
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


<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<html>
<head>
    <title>�α��� ȭ��</title>

    <script type="text/javascript">

        function checkValue()
        {
            inputForm = eval("document.loginInfo");
            if(!inputForm.userId.value)
            {
                alert("���̵� �Է��ϼ���");
                inputForm.userId.focus();
                return false;
            }
            if(!inputForm.userPassword.value)
            {
                alert("��й�ȣ�� �Է��ϼ���");
                inputForm.userPassword.focus();
                return false;
            }
        }

        <!--ȸ������-->
        function goJoinForm() {
            location.href="signup";
        }
    </script>

</head>
<body>
<div id="wrap">
    <form name="loginInfo" method="post" action="login"
          onsubmit="return checkValue()">

        <br>���̹� ���� ������Ʈ<br>

        <table>
            <tr>
                <td bgcolor="PowderBlue">���̵�</td>
                <td><input type="text" id="userId" name="userId" maxlength="50"></td>
            </tr>
            <tr>
                <td bgcolor="PowderBlue">��й�ȣ</td>
                <td><input type="password" id="userPassword" name="userPassword" maxlength="50"></td>
            </tr>
        </table>
        <br>

        <input type="submit" value="�α���"/>
        <button type="button" onclick="location.href='signup'">ȸ������</button>

    </form>

</div>
</body>
</html>

