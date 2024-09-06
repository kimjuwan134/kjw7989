<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
<h1>글쓰기</h1>
<form action="writePro.bo" method="post">
<table border="1">
<tr><td>글쓴이</td><td><input type="text" name="name" value="${sessionScope.id}" readonly></td></tr>
<tr><td>글제목</td><td><input type="text" name="subject"></td></tr>
<tr><td>글내용</td><td><textarea cols="20" rows="10" name="content"></textarea></td></tr>
<tr><td colspan="2"><input type="submit" value="글쓰기"></td></tr>
</table>
<a href="main.me">메인 화면 이동</a>
</form>
</body>
</html>