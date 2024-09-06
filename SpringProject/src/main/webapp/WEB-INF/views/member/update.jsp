<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
<h1>회원 정보 수정</h1>
<c:set var="memberDTO" value="${requestScope.memberDTO}"/>
<c:choose>
	<c:when test="${!empty memberDTO}">
		<form action="${pageContext.request.contextPath}/member/updatePro" method="post">
			아이디 : <input type="text" name="id" value="${memberDTO.id}" readonly><br>
			비밀번호 : <input type="password" name="pass"><br>
			이름 : <input type="text" name="name" value="${memberDTO.name}"><br>
			<input type="submit" value="회원 정보 수정">
		</form>
	</c:when>
	<c:otherwise>
		<c:redirect url="${pageContext.request.contextPath}/member/login"/>
	</c:otherwise>
</c:choose>
<a href="${pageContext.request.contextPath}/member/main">메인 페이지 이동</a>
</body>
</html>