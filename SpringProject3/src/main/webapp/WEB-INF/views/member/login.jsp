<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
<h1>로그인 페이지</h1>
<form action="${pageContext.request.contextPath}/member/loginPro" method="post">
<table border="1">
<tr><th>아이디</th><td><input type="text" name="id"></td></tr>
<tr><th>비밀번호</th><td><input type="password" name="pass"></td></tr>
<tr><th colspan="2"><input type="submit" value="로그인"></th></tr>
</table>
</form>
<a href="${pageContext.request.contextPath}/member/insert">회원가입</a>
</body>
</html>