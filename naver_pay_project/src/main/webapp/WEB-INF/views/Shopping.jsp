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
    <title>Shopping</title>
    <link rel="stylesheet" href="../../resources/css/Shopping.css">
</head>
<body>
    <h1>주문 목록 화면 입니다.</h1>
    ${shoppingList}
    <div class="container">
        <div class="section-1">
            <p>사용자 이름 : ${userName}</p>
            <p>사용자 포인트 : ${userPoint}</p>
        </div>
        <div class="section-2">
            <div class="cont-1">
                <p>날짜를 입력 해주세요.</p>
                <form action="getSearchDate">
                    <input type="date" name="startDate" required>
                    <input type="date" name="endDate" required>
                    <button type="submit">검색</button>
                </form>
            </div>
            <div class="cont-2">
                <p>날짜 : ${date}</p>
                <p>상품명 : ${produectName}</p>
                <p>상품 가격 : ${produectPrice}</p>
                <p>결제 날짜 : ${orderDate}</p>
                <p>회사 이름 : ${companyName}</p>
                <p>회사 전화 번호 : ${companyTel}</p>
                <p>해당 주문 결과 상세 페이지로 이동하기 : <button type="button" onclick="location.href='getShoppingDetailList'">이동</button></p>
            </div>
        </div>
    </div>
</body>
</html>
