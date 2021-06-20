<%@ page
    language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>제품 목록</title>
</head>
<body>
<h1>제품 목록</h1>
<p><a href='add'>제품등록</a></p>
<p><a href='list01'>sus_01확인</a></p>
<p><a href='list02'>sus_02확인</a></p>
<table border='1'>
<thead>
<tr>
<th>번호</th> <th>상품명</th> <th>가격</th> <th>제조사</th> <th>사진</th> <th>비고</th>
</tr>
</thead>
<tbody>

<c:forEach items="${list}" var="p">
  <c:if test="${not empty p.photo}">
    <c:set var="photoUrl">../../upload/${p.photo}_30x30.jpg</c:set>
  </c:if>
  <c:if test="${empty p.photo}">
    <c:set var="photoUrl">../../images/person_30x30.jpg</c:set>
  </c:if>
<tr>
  <td>${p.no}</td>
  <td><a href='detail?no=${p.no}'>${p.model}</a></td>
  <td>${p.price} 원</td>
  <td>${p.company}</td>
  <td><img src='${photoUrl}'></td>

  <c:set var="is01" scope="request" value="${isList01}"/>
  <c:set var="existP" value="${false}"/>
  <c:forEach items="${isList01}" var="is01">
    <c:if test="${p.no == is01.no}">
  <td>
      <c:out value="재고있음"/>
  </td>
      <c:set var="existP" value="${true}"/>
    </c:if>
  </c:forEach>

    <c:if test="${!existP}">
  <td><form action="put" method="post">
    <input type="number" name="no" value="${p.no}" hidden>
    <input type='submit' value='sus_01/sus_02 추가' onclick="check()">
  </form></td>
    </c:if>
</tr>
</c:forEach>

</tbody>
</table>

</body>
</html>

<script>
  function check() {
        alert("sus_01/sus_02 추가 완료");
    }
</script>