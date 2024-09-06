<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>
<h1>글 목록</h1>
<a href="write.bo">글 쓰기</a><br>
<c:set var="pageDTO" value="${requestScope.pageDTO}"/>
<h2>글 목록 [ 글 개수 : ${pageDTO.count}]</h2>
<c:if test="${empty sessionScope.id}">
	<c:redirect url="login.me"/>
</c:if>
<table border="1">
<tr><th>글번호</th><th>글제목</th><th>글쓴이</th><th>글쓴날짜</th><th>조회수</th></tr>
<c:forEach var="list" items="${requestScope.boardList}">
	<tr>
		<td>${list.num}</td>
	    <td><a href ="content.bo?num=${list.num}">
	    	${list.subject}</a></td>
	    <td>${list.name}</td>
	    <td>${list.date}</td>
	    <td>${list.readCount}</td>
	</tr>
</c:forEach>
</table>
<br>
<c:if test="${pageDTO.startPage > pageDTO.pageBlock}">
<a href="list.bo?pageNum=${pageDTO.startPage - pageDTO.pageBlock}">[이전]</a>
</c:if>
<c:forEach var="i" begin="${pageDTO.startPage}" end="${pageDTO.endPage}" step="1">
	<a href="list.bo?pageNum=${i}">${i}</a>
</c:forEach>
<c:if test="${pageDTO.endPage < pageDTO.pageCount}">
<a href="list.bo?pageNum=${pageDTO.startPage + pageDTO.pageBlock}">[다음]</a>
</c:if>
<br><br>	
<a href="main.me">메인 화면 이동</a>
</body>
</html>