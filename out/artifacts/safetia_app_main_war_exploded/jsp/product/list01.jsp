<%@ page
    language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Sus_01</title>
</head>
<body>
<h1>Sus_01 제품목록</h1>
<p><a href='list'>제품목록</a></p>

<table border='1'>
<thead>
<tr>
<th>번호</th> <th>상품명</th> <th>가격</th> <th>제조사</th> <th>사진</th>
</tr>
</thead>
<tbody>

<c:forEach items="${list01}" var="p1">
  <c:if test="${not empty p1.photo}">
    <c:set var="photoUrl">../../upload/${p1.photo}_30x30.jpg</c:set>
  </c:if>
  <c:if test="${empty p1.photo}">
    <c:set var="photoUrl">../../images/person_30x30.jpg</c:set>
  </c:if>
<tr>
  <td>${p1.no}</td>
  <td><a href='detail?no=${p1.no}'>${p1.model}</a></td>
  <td>${p1.price} 원</td>
  <td>${p1.company}</td>
  <td><img src='${photoUrl}'></td>
</tr>
</c:forEach>
</tbody>
</table>

</body>
</html>
