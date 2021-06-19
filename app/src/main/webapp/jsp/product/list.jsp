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
  <td><form action="put" method="post">
    <input type="number" name="no" value="${p.no}">
    <input type='submit' value='sus_01추가' onclick="check()">
  </form></td>
<%--  <td><a href='put?no=${p.no}'>sus_01추가</a></td>--%>
</tr>
</c:forEach>
</tbody>
</table>

<form action='list' method='get'>
<input type='search' name='keyword' value='${param.keyword}'>
<button>검색</button>
</form>

</body>
</html>

<script>
  function check() {
        alert("sus_01 추가 완료");
    }
</script>