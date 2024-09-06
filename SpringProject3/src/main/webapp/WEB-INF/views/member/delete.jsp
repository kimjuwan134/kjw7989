<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 아이디 삭제</title>
</head>
<body>
<h1>회원 아이디 삭제</h1>
<form action="${pageContext.request.contextPath}/member/deletePro" method="post">
아이디 : <input type="text" name="id" value="${sessionScope.id}" readonly><br>
비밀번호 : <input type="password" name="pass"><br>
<input type="submit" value="삭제">
</form>
<a href="${pageContext.request.contextPath}/member/main">메인 화면 이동</a>
</body>
</html>