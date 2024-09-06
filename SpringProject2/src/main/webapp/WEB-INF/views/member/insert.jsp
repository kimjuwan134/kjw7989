<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
<h1>회원 가입</h1>
<form action="${pageContext.request.contextPath}/member/insertPro" method="post">
<table border="1">
<tr><th>아이디</th><td><input type="text" name="id"></td></tr>
<tr><th>비밀번호</th><td><input type="password" name="pass"></td></tr>
<tr><th>이름</th><td><input type="text" name="name"></td></tr>
<tr><th colspan="2"><input type="submit" value="회원가입"></th></tr>
</table>
<a href="${pageContext.request.contextPath}/member/login">로그인</a>
</form>
</body>
</html>