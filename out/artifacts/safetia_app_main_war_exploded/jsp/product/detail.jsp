<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>상품 상세</title>
</head>
<body>
<h1>상품 상세보기</h1>

<c:if test="${not empty product}">
	<c:if test="${not empty product.photo}">
		<c:set var="photo80x80Url">../../upload/${product.photo}_80x80.jpg</c:set>
		<c:set var="photoUrl">../upload/${product.photo}</c:set>
	</c:if>
	<c:if test="${empty product.photo}">
		<c:set var="photo80x80Url">../../images/x_80x80.jpg</c:set>
		<c:set var="photoUrl"></c:set>
	</c:if>

<form action='update' method='post' enctype='multipart/form-data'>
<table border='1'>
	<tbody>
		<tr><th>번호</th><td><input type='number' name='no' value='${product.no}' readonly></td></tr>
		<tr><th>상품명</th> <td><input name='model' type='text' value='${product.model}'></td></tr>
		<tr><th>가격</th> <td><input name='price' type='number' value='${product.price}'> 원</td></tr>
		<tr><th>제조사</th> <td><input name='company' type='text' value='${product.company}'></td></tr>
		<tr><th>사진</th> <td><a href='${photo80x80Url}'>
			<img src='${photo80x80Url}'></a><br>
			<input name='photo' type='file'></td></tr>

		<tr><th>영양정보</th></tr>
		<tr><th>나트륨</th> <td><input name='salt' type='number' value='${product.salt}'></td></tr>
		<tr><th>탄수화물</th> <td><input name='carbohydrate' type='number' value='${product.carbohydrate}'></td></tr>
		<tr><th>당류</th> <td><input name='sugar' type='number' value='${product.sugar}'></td></tr>
		<tr><th>트랜스지방</th> <td><input name='transFat' type='number' value='${product.transFat}'></td></tr>
		<tr><th>포화지방</th> <td><input name='saturatedFat' type='number' value='${product.saturatedFat}'></td></tr>
		<tr><th>콜레스테롤</th> <td><input name='cholesterol' type='number' value='${product.cholesterol}'></td></tr>
		<tr><th>단백질</th> <td><input name='protein' type='number' value='${product.protein}'></td></tr>
	</tbody>

	<tfoot>
	<tr>
	  <td colspan='2'>
	    <input type='submit' value='변경'> <a href='delete?no=${product.no}'>삭제</a>
	  </td>
	</tr>
	</tfoot>    

</table>
</form>

</c:if>

<c:if test="${empty product}">
<p>해당 번호의 제품이 없습니다.</p>
</c:if>

<p><a href='list'>목록</a></p>
</body>
</html>