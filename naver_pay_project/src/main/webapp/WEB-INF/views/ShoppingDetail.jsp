<%@ page import="org.toyproject.DTO.ShoppingDetailDTO" %><%--
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
    <div>
        <button>주문 결과 삭제</button>
        <button type="button" onclick="location.href='shopping/getShoppingList'">쇼핑리스트</button>
    </div>
    <div>
        <div>
            <p>주문 일자 : ${order.orderDate}</p>
            <p>주문 번호 : ${order.orderId}</p>
        </div>
        <div>
            <p>상품 금액 : ${order.productPrice}</p>
            <p>상품 결제시 제공 포인트 : ${order.supplyPoint}</p>
            <p>상품 판매 회사 : ${order.companyName}</p>
            <p>상품 판매 회사 전화 번호 : ${order.companyTel}</p>
            <p>상품 판매 회사 스토어 URL : ${order.companyStore}</p>
        </div>
        <div>
            <p>사용자가 결제한 결제 수단 : ${order.paymentMethod}</p>
            <p>사용자가 사용한 포인트 : ${order.usedPoint}</p>
            <p>사용자가 지불한 금액 : ${order.orderMoney}</p>
        </div>
        <div>
            <p>배송지 정보</p>
            <p>사용자 이름 : ${orderorder.userName}</p>
            <p>사용자 주소 : ${order.userAddr}</p>
            <p>사용자 연락처 : ${order.userTel}</p>
        </div>
    </div>
</body>
</html>
