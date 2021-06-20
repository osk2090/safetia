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
<form action="add" method="post" enctype="multipart/form-data">
    상품명: <input type="text" name="model"><br>
    가격(원 단위): <input type="number" name="price" min="0"><br>
    제조사: <input type="text" name="company"><br>
    사진: <input type="file" name="photo"><br>

    <h2>영양정보</h2>
    나트륨: <input type="number" name="salt" min="0"><br>
    탄수화물: <input type="number" name="carbohydrate" min="0"><br>
    당류: <input type="number" name="sugar" min="0"><br>
    트랜스지방: <input type="number" name="transFat" min="0"><br>
    포화지방: <input type="number" name="saturatedFat" min="0"><br>
    콜레스테롤: <input type="number" name="cholesterol" min="0"><br>
    단백질: <input type="number" name="protein" min="0"><br>
<input type="submit" value="등록">
</form>
</body>
</html>