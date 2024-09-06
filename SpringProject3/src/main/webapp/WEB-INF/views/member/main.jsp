<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 화면</title>
</head>
<body>
<h1>메인 화면</h1>
<%-- <c:if test="${empty sessionScope.id}"> --%>
<%-- 	<c:redirect url="login.me"/> --%>
<%-- </c:if> --%>
${sessionScope.id} 님 로그인 하셨습니다.<br>
<a href="${pageContext.request.contextPath}/member/info">나의 정보 조회</a><br>
<a href="${pageContext.request.contextPath}/member/update">나의 정보 수정</a><br>
<a href="${pageContext.request.contextPath}/member/delete">나의 정보 삭제</a><br>
<a href="${pageContext.request.contextPath}/board/write">글쓰기</a><br>
<a href="${pageContext.request.contextPath}/board/list">글목록</a><br>
<a href="${pageContext.request.contextPath}/member/logout">로그아웃</a><br>
<c:if test="${!empty sessionScope.id}">
	<c:if test="${sessionScope.id eq 'admin'}">
		<a href="${pageContext.request.contextPath}/member/list">회원 목록</a><br>
	</c:if>
</c:if>
</body>
</html>