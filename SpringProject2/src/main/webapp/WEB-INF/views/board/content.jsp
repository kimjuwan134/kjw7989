<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="board" value="${requestScope.getBoard}"/>
<title>${board.subject}</title>
</head>
<body>
<c:if test="${!empty board}">
	<h1>제목 : ${board.subject}</h1>
	로그인 : ${board.name}<br>
	<table border="1">
	<tr><th>글번호</th><td>${board.num}</td></tr>
	<tr><th>글쓴이</th><td>${board.name}</td></tr>
	<tr><th>조회수</th><td>${board.readCount}</td></tr>
	<tr><th>글쓴날짜</th><td>${board.date}</td></tr>
	<tr><th>글제목</th><td>${board.subject}</td></tr>
	<tr><th>글내용</th><td>${board.content}</td></tr>
	<tr><th colspan="2">
	<c:if test="${board.name eq sessionScope.id}">
		<a href="update.bo?num=${board.num}">글수정</a>
		<a href="delete.bo?num=${board.num}">글삭제</a>
	</c:if>
	<a href="list.bo">글목록</a></th></tr>
	</table>
</c:if>
</body>
</html>