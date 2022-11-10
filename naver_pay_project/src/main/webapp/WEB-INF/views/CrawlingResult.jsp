<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <p>아이디 : ${crawlingResult.get(0).userId} 비밀번호(랜덤값) : ${crawlingResult.get(0).userPw}</p>
    <p>이름 : ${crawlingResult.get(0).userName} 연락처 : ${crawlingResult.get(0).userTel}</p>
    <p>주소(임의값) : ${crawlingResult.get(0).userAddress} 유저포인트 : ${crawlingResult.get(0).userPoint}</p>
</head>
<body>
<br/>
<h1>실제 네이버 주문목록입니다.</h1>
<br/>
<c:forEach items="${crawlingResult}" var="result">
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <p>주문날짜: <fmt:formatDate value="${result.orderDate}" pattern="yyyy-MM-dd" />   주문번호: ${result.orderId}</p>
    <p>제품명: ${result.productName}
    <p>제품수량: ${result.orderQuantity}   제품가격: ${result.productPrice}</p>
    <p>회사명: ${result.companyName}   회사대표번호: ${result.comPanyTel}</p>
    <p>회사URL: ${result.companyStore}   사업자번호(랜덤값): ${result.businessNumber}</p>
    <p>결제방법: ${result.paymentMethod}   제공포인트: ${result.supplyPoint}   사용포인트: ${result.usedPoint}</p>
    <p>총 가격: ${result.orderTotalMoney}</p>
    <br/>
    <hr/>
</c:forEach>
</form>
</body>
</html>
