<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.toyproject.DTO.OrderedProductHistoryDTO" %><%--
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
</head>
<body>
<h1>주문 목록 화면 입니다.</h1>
<c:forEach items="$(DtoList)" var="dto">
    유저아이디 : ${dto.userId}
    유저포인트 : ${dto.userPoint}
    제품명 : ${dto.productName}
    제품금액 : ${dto.productPrice}
    회사이름 : ${dto.companyName}
    회사번호 : ${dto.company_tel}
    주문번호 : ${dto.orderId}
    주문날짜 : ${dto.orderDate}
</c:forEach>
<button type="button" onclick="location.href='getShoppingDetailList'">주문 결과 상세 페이지로 이동하기</button>
</body>
</html>
