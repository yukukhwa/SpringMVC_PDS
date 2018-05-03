<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>getGalleryOne</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<!--[if lte IE 8]><script src="./resources/assets/js/ie/html5shiv.js"></script><![endif]-->
	<link rel="stylesheet" href="./resources/assets/css/main.css" />
	<!--[if lte IE 9]><link rel="stylesheet" href="./resources/assets/css/ie9.css" /><![endif]-->
	<!--[if lte IE 8]><link rel="stylesheet" href="./resources/assets/css/ie8.css" /><![endif]-->
</head>
<body>
	<%@ include file="../module/tap.jsp" %>
	<!-- Main -->
		<div id="main">
			<div class="inner">
				<h1>getGalleryOne</h1>
				<div>
					주제<br>
					<input name="galleryTitle" type="text" value="${galleryTitle}" disabled="disabled">
				</div>
				<div>
					본문<br>
					<textarea name="galleryContent" rows="5" cols="100" disabled="disabled">${galleryContent}</textarea>
				</div>
				<c:forEach var="galleryFile" items="${galleryFileList}">
					<div>
						<img width="400px" height="300px" alt="${galleryFile.galleryFileName}.${galleryFile.galleryFileExt}" src="${pageContext.request.contextPath}/resources/upload/${galleryFile.galleryFileName}.${galleryFile.galleryFileExt}">
					</div>
				</c:forEach>
				<a href="${pageContext.request.contextPath}/updateGallery?galleryId=${galleryId}">수정하기</a>
				<a href="${pageContext.request.contextPath}/deleteGallery?galleryId=${galleryId}">삭제하기</a>
				<a href="${pageContext.request.contextPath}/getGalleryList">목록으로</a>
			</div>
		</div>
	<%@ include file="../module/bottom.jsp" %>
</body>
</html>