<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>updateGallery</title>
</head>
<body>
	<h1>updateGallery</h1>
	<form action="${pageContext.request.contextPath}/updateGallery" method="post">
		<div>
			주제<br>
			<input name="galleryTitle" type="text" value="${galleryTitle}">
		</div>
		<div>
			본문<br>
			<textarea name="galleryContent" rows="5" cols="100">${galleryContent}</textarea>
		</div>
		<div>
			<c:forEach var="galleryFile" items="${galleryFileList}">
				<img width="400px" height="300px" alt="${galleryFile.galleryFileName}.${galleryFile.galleryFileExt}" src="${pageContext.request.contextPath}/resources/upload/${galleryFile.galleryFileName}.${galleryFile.galleryFileExt}">
				<input type="file"  value="${pageContext.request.contextPath}/resources/upload/${galleryFile.galleryFileName}.${galleryFile.galleryFileExt}">
			</c:forEach>
		</div>
		<button id="update" type="submit">등록하기</button>
	</form>
</body>
</html>