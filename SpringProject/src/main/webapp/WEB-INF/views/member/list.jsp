<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
<c:set var="pageDTO" value="${requestScope.pageDTO}"/>
<h1>회원 목록 [ 회원 수 : ${pageDTO.count}]</h1>
<%-- <c:if test="${empty sessionScope.id}"> --%>
<%-- 	<c:redirect url="member/login"/> --%>
<%-- </c:if> --%>
<%-- <c:if test="${!empty sessionScope.id}"> --%>
<%-- 	<c:if test="${!(sessionScope.id eq 'admin')}"> --%>
<%-- 		<c:redirect url="member/main"/> --%>
<%-- 	</c:if> --%>
<%-- </c:if> --%>
<table border="1">
<tr><th>아이디</th><th>비밀번호</th><th>이름</th><th>가입 날짜</th></tr>
<c:forEach var="array" items="${requestScope.arrayList}">
	<tr>
		<td>${array.id}</td>
		<td>${array.pass}</td>
		<td>${array.name}</td>
		<td>${array.date}</td>
	</tr>
</c:forEach>
</table>
<c:if test="${pageDTO.startPage > pageDTO.pageBlock}">
<a href="${pageContext.request.contextPath}/member/list?pageNum=${pageDTO.startPage - pageDTO.pageBlock}">[이전]</a>
</c:if>
<c:forEach var="i" begin="${pageDTO.startPage}" end="${pageDTO.endPage}" step="1">
	<a href="${pageContext.request.contextPath}/member/list?pageNum=${i}">${i}</a>
</c:forEach>
<c:if test="${pageDTO.endPage < pageDTO.pageCount}">
<a href="${pageContext.request.contextPath}/member/list?pageNum=${pageDTO.startPage + pageDTO.pageBlock}">[다음]</a>
</c:if>
<br>
<a href="${pageContext.request.contextPath}/member/main">메인 화면 이동</a>
</body>
</html>