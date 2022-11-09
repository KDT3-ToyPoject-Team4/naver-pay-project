<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
    <style>
        * {
            box-sizing: border-box;
        }

        form {
            width: 400px;
            height: 600px;
            display: flex;
            flex-direction: column;
            align-items: center;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            border: 1px solid rgb(89, 117, 196);
            border-radius: 10px;
        }

        .input-field {
            width: 300px;
            height: 40px;
            border: 1px solid rgb(89, 117, 196);
            border-radius: 5px;
            padding: 0 10px;
            margin-bottom: 10px;
        }

        label {
            width: 300px;
            height: 30px;
            margin-top: 4px;
        }

        button {
            background-color: rgb(89, 117, 196);
            color: white;
            width: 300px;
            height: 50px;
            font-size: 17px;
            border: none;
            border-radius: 5px;
            margin: 20px 0 30px 0;
        }

        .title {
            font-size: 50px;
            margin: 40px 0 30px 0;
        }

        .msg {
            height: 30px;
            text-align: center;
            font-size: 16px;
            color: red;
            margin-bottom: 20px;
        }

    </style>
    <title>Register</title>
</head>
<body>

<form action="/sign/success" method="POST">
<%--<form action="/sign/success" method="POST" onsubmit="return setMessage(this)">--%>
    <%--  회원 가입 완료하면 입력한 정보 저장하고 메인 페이지로 이동하기--%>

        <legend>회원가입</legend>

        <div id="msg" class="msg"></div>
    <label for="userID">아이디</label>
    <input class="input-field" id="userID" type="text" name="userID" placeholder="7 ~ 14자 영문 대소문자와 숫자"
           pattern="[a-zA-Z]{1}[a-zA-Z0-9_-]{7,14}" required autofocus>
    <%--    아직 특수문자같은거 정규식 사용해서 설정 안함 --%>
    <label for="userPassword">비밀번호</label>
    <input class="input-field" id="userPassword" type="text" name="userPassword" placeholder="10 ~ 16자 영문,숫자,특수문자 포함"
           pattern="^[a-zA-Z0-9!@#$%^&*]{10,16}$" required>
    <label for="userPasswordCheck">비밀번호 확인</label>
    <input class="input-field" id="userPasswordCheck" type="text" name="userPasswordCheck" required>
    <label for="userName">이름</label>
    <input class="input-field" id="userName" type="text" name="userName" placeholder="홍길동">
    <label for="userPhoneNumber">핸드폰번호</label>
    <input class="input-field" id="userPhoneNumber" type="text" name="userPhoneNumber" placeholder="당신 핸드폰 번호">
    <label for="userAddress">주소</label>
    <input class="input-field" id="userAddress" type="text" name="userAddress" placeholder="당신 집 주소">

    <button>회원 가입</button>
    <button type="button" onclick="location.href='/'">취소</button>


</form>
<script>
    // function formCheck(frm) {
    //     var msg = '';
    //
    //     if (frm.id.value.length < 3) {
    //         setMessage('id의 길이는 3이상이어야 합니다.', frm.id);
    //         return false;
    //     }
    //
    //     return true;
    // }

    <%--function setMessage(msg, element) {--%>
    <%--    document.getElementById("msg").innerHTML = `<i class="fa fa-exclamation-circle"> ${'${msg}'}'</i>`;--%>

    <%--    if (element) {--%>
    <%--        element.select();--%>
    <%--    }--%>
    <%--}--%>
    var userPassword = document.getElementById("userPassword")
        , userPasswordCheck = document.getElementById("userPasswordCheck");

    function validatePw(){
        if(userPassword.value != userPasswordCheck.value){
            userPasswordCheck.setCustomValidity("Passwords Don't Match");

            // setMessage("비밀번호가 일치하지 않습니다.");
        }else{
            userPasswordCheck.setCustomValidity('');
            // setMessage("회원가입 성공");
        }
    }
    userPassword.onchange = validatePw;
    userPasswordCheck.onkeyup = validatePw;




</script>
</body>
</html>
