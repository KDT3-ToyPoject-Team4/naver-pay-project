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
    <div>
        <button>주문 결과 삭제</button>
    </div>
    <div>
        <div>
            <p>주문 일자 : ${orderDate}</p>
            <p>주문 번호 : ${orderId}</p>
        </div>
        <div>
            <p>상품 금액 : ${productPirce}</p>
            <p>상품 결제시 제공 포인트 : ${supplyPoint}</p>
            <p>상품 판매 회사 : ${companyName}</p>
            <p>상품 판매 회사 전화 번호 : ${companyTel}</p>
            <p>상품 판매 회사 스토어 URL : ${companyStore}</p>
        </div>
        <div>
            <p>사용자가 결제한 결제 수단 : ${paymentMethod}</p>
            <p>사용자가 사용한 포인트 : ${usedPoint}</p>
            <p>사용자가 지불한 금액 : ${orderMoney}</p>
        </div>
        <div>
            <p>배송지 정보</p>
            <p>사용자 이름 : ${userName}</p>
            <p>사용자 주소 : ${userAddr}</p>
            <p>사용자 연락처 : ${userPh}</p>
        </div>
    </div>
</body>
</html>
