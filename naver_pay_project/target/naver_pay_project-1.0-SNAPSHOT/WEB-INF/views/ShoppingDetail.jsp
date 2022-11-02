<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-02
  Time: 오후 4:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ShoppingDetail</title>
</head>
<body>
    <h1>주문 결과 상세 페이지 입니다.</h1>
    <h2>결제정보 : ${paymentId}</h2>
    <h2>제품이름 : ${productName}</h2>
    <h2>제품금액 : ${productPrice}</h2>
    <h2>제품수량 : ${productAmount}</h2>
    <h2>결제방법 : ${paymentMethod}</h2>
    <h2>결제날짜 : ${paymentDate}</h2>
    <h2>판매자명 : ${sellerName}</h2>
    <h2>판매자 대표 번호 : ${sellerPhone}</h2>
    <h2>구매자 번호 : ${userSerialNumber}</h2>
    <h2>적립된 포인트 : ${collectedPoints}</h2>
    <h2>제품 상세페이지 : ${URL}</h2>
</body>
</html>
