<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
</head>
<body>
<form action="updatePro.bo" method="post">
<c:set var="board" value="${requestScope.getBoard}"/>
<table border="1">
<tr><td>글번호</td><td><input type="text" name="num" value="${board.num}" readonly></td></tr>
<tr><td>글쓴이</td><td><input type="text" name="name" value="${board.name}" readonly></td></tr>
<tr><td>글제목</td><td><input type="text" name="subject" value="${board.subject}"></td></tr>
<tr><td>글내용</td><td><textarea cols="20" rows="10" name="content">${board.content}</textarea></td></tr>
<tr><td colspan="2"><input type="submit" value="글수정"></td></tr>
</table>
</form>
<a href="list.bo">글 목록</a>
</body>
</html>