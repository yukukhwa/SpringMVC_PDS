<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>getGalleryOne</title>
</head>
<body>
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
</body>
</html>