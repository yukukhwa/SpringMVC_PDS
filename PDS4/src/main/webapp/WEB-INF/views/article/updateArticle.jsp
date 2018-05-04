<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>updateArticleOne</title>
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
			<h1>updateArticleOne</h1>
			<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/updateArticle" method="post">
				<div>작성자 : <input name="articleId" type="text" value="${articleId}" readonly></div>
				<div>제목 : <input name="articleTitle" type="text" value="${articleTitle}"></div>
				<div>내용<br>
				<textarea name="articleContent" rows="5" cols="80">${articleContent}</textarea></div>
				<c:forEach items="${articleFilelist}" var="articleFile">
					<div>
						첨부파일 : ${articleFile.articleFileName}.${articleFile.articleFileExt}
					</div>
				</c:forEach>
				<!-- <button id="fileDelete" type="button">파일삭제</button><br> -->
				<button type="submit">수정완료</button>
				<!-- <button type="submit" name="cancle">취소</button> -->
			</form>
		</div>
	</div>
	<%@ include file="../module/bottom.jsp" %>
</body>
</html>