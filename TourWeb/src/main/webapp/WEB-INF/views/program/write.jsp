<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html lang="ko">
<head>
<title> 프로그램 소개 | 상품투어 | 투어리스트인투어 </title>
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/common.js"></script>  
<script src="${pageContext.request.contextPath}/resources/js/jquery.smooth-scroll.min.js"></script> 
<!--[if lte IE 9]>
    <script src="js/html5shiv.js"></script>
	<script src="js/placeholders.min.js"></script>
<![endif]-->
</head>

<body>
<ul class="skipnavi">
    <li><a href="#container">본문내용</a></li>
</ul>
<!-- wrap -->
<div id="wrap">

	<jsp:include page="../inc/top.jsp"/>
	
	<div id="container">
		<!-- location_area -->
		<div class="location_area package">
			<div class="box_inner">
				<h2 class="tit_page">TOURIST <span class="in">in</span> TOUR</h2>
				<p class="location">상품투어 <span class="path">/</span> 프로그램 소개</p>
				<ul class="page_menu clear">
					<li><a href="javascript:;" class="on">프로그램 소개</a></li>
					<li><a href="javascript:;">여행 자료</a></li>
				</ul>
			</div>
		</div>	
		<!-- //location_area -->

		<!-- bodytext_area -->
		<div class="bodytext_area place_area box_inner">
		<form action="${pageContext.request.contextPath}/program/writePro" class="appForm" method="post" name="fr" enctype="multipart/form-data">
			<ul class="bbsview_list">
				<li class="bbs_title">
					글제목 : <input type="text" name="subject">
				</li>
				<li class="bbs_title">
					작성자 : <input type="text" name="name" value="${sessionScope.id}" readonly>
				</li>
				<li class="bbs_title">
					사진 첨부 : <input type="file" name="file">
				</li>
				<li class="bbs_title">
					전시 날짜 : <input type="date" name="startDate">
							  <input type="date" name="endDate">
				</li>
				<li class="bbs_content">
					<div class="editer_content">
					    글내용 : <textarea name="content" rows="10" cols="30"></textarea>
                    </div>
				</li>
			</ul>
			<p class="btn_line txt_right">
				<a href="javascript:document.fr.submit();" class="btn_bbs">글쓰기</a>
				<a href="${pageContext.request.contextPath}/program/program" class="btn_bbs">글목록</a>
			</p>
		</form>
		</div>
		<!-- //bodytext_area -->

	</div>
	<!-- //container -->

	<jsp:include page="../inc/bottom.jsp"/>

</div>
<!-- //wrap -->

<jsp:include page="../inc/popup.jsp"/>

</body>
</html>
