<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새제품 등록</title>
</head>
<body>
<h1>새제품</h1>
<form action="add" method="post">
    상품명: <input type="text" name="model"><br>
    가격: <input type="number" name="price"><br>
    제조사: <input type="text" name="company"><br>
    사진: <input type="file" name="photo"><br>

    <h2>영양정보</h2>
    나트륨: <input type="number" name="salt"><br>
    탄수화물: <input type="number" name="carbohydrate"><br>
    당류: <input type="number" name="sugar"><br>
    트랜스지방: <input type="number" name="transFat"><br>
    포화지방: <input type="number" name="saturatedFat"><br>
    콜레스테롤: <input type="number" name="cholesterol"><br>
    단백질: <input type="number" name="protein"><br>
<input type="submit" value="등록">
</form>
</body>
</html>