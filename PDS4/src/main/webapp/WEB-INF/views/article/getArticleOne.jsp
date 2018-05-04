<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>getArticleOne</title>
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
			<h1>getArticleOne</h1>
			<div><a href="${pageContext.request.contextPath}/getArticleList">목록으로 돌아가기</a></div>
			<div>작성자 : <input name="articleId" type="text" value="${articleId}" readonly></div>
			<div>제목 : <input name="articleTitle" type="text" value="${articleTitle}" readonly></div>
			<div>내용<br>
			<textarea name="articleContent" rows="5" cols="80" readonly>${articleContent}</textarea></div>
			<c:forEach items="${articleFilelist}" var="articleFile">
				<div>
					첨부파일 : <a href="${pageContext.request.contextPath}/resources/upload/
									${articleFile.articleFileName}.${articleFile.articleFileExt}" download>
									${articleFile.articleFileName}.${articleFile.articleFileExt}</a>
				</div>
			</c:forEach>
			<a href="${pageContext.request.contextPath}/updateArticle?articleId=${articleId}">수정</a>
			<a href="${pageContext.request.contextPath}/deleteArticle?articleId=${articleId}">삭제</a>
		</div>
	</div>
	<%@ include file="../module/bottom.jsp" %>
</body>
</html>