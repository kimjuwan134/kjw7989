<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 조회</title>
</head>
<body>
<h1>내 정보 조회</h1>
<c:set var="memberDTO" value="${requestScope.memberDTO}"/>
<c:choose>
	<c:when test="${!empty memberDTO}">
		아이디 : ${memberDTO.id}<br>
		비밀번호 : ${memberDTO.pass}<br>
		이름 : ${memberDTO.name}<br>
		가입 날짜 및 시간 : ${memberDTO.date}<br>
	</c:when>
	<c:otherwise>
		<c:redirect url="${pageContext.request.contextPath}/member/login"/>
	</c:otherwise>
</c:choose>
<a href="${pageContext.request.contextPath}/member/main">메인 페이지 이동</a>
</body>
</html>