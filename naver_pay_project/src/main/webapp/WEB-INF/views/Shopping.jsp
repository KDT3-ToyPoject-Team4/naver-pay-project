<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.toyproject.DTO.OrderedProductHistoryDTO" %>
<%@ page import="org.springframework.web.bind.annotation.ModelAttribute" %><%--
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
            <p>사용자 이름 : ${dtoList.get(0).userId}</p>
            <p>사용자 포인트 : ${dtoList.get(0).userPoint}</p>
        </div>
        <div class="section-2">
            <div class="cont-1">
                <p>날짜를 입력 해주세요.</p>
                <form>
                    <input type="date" name="startDate" required>
                    <input type="date" name="endDate" required>
                    <button type="button" onclick="location.href='getSearchDate'">검색</button>
                </form>
            </div>
            <div class="cont-2">
                <c:forEach items="${dtoList}" var = "dto">
                    <tr>
                        <td>주문 번호: ${dto.orderId}</td>
                        <td>상품명: ${dto.productName}</td>
                        <td>상품가격: ${dto.productPrice}</td>
                        <td>결제날짜: ${dto.orderDate}</td>
                        <td>회사이름: ${dto.companyName}</td>
                        <td>회사번호: ${dto.company_tel}</td>
                        <p><button type="button" onclick="location.href='getShoppingDetailList'">주문 상세</button></p>
                    </tr>
                </c:forEach>

            </div>
        </div>
    </div>
</body>
</html>
