<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="css/Shopping.css">
</head>
<body>
    <h1>주문 목록 화면 입니다.</h1>
    <div>
        <button type="button" onclick="location.href='/'">메인 화면으로 이동</button>
    </div>
    ${shoppingList}
    <div class="container">
        <div class="section-1">
            <p>사용자 이름 : ${DtoList.get(0).userId}</p>
            <p>사용자 포인트 : ${DtoList.get(0).userPoint}</p>
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
                <c:forEach items="${DtoList}"  var="dto" >
                    <p>제품명 : ${dto.productName}</p>
                    <p>제품금액 : ${dto.productPrice}</p>
                    <p>회사명 : ${dto.companyName}</p>
                    <p>회사번호 : ${dto.company_tel}</p>
                    <p>주문번호 : ${dto.orderId}</p>
                    <p>주문날짜 : ${dto.orderDate}</p>
                    <p>해당 주문 결과 상세 페이지로 이동하기 : <button type="button" onclick="location.href='getShoppingDetailList'">이동</button></p>
                </c:forEach>
            </div>
        </div>
    </div>
</body>
</html>
