<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>getArticleOne</title>
</head>
<body>
	<h1>getArticleOne</h1>
	<div><a href="${pageContext.request.contextPath}/getArticleList">목록으로 돌아가기</a></div>
	<div>작성자 : <input name="articleId" type="text" value="${article.articleId}" readonly></div>
	<div>제목 : <input name="articleTitle" type="text" value="${article.articleTitle}" readonly></div>
	<div>내용<br>
	<textarea name="articleContent" rows="5" cols="80" readonly>${article.articleContent}</textarea></div>
	<div>첨부파일 : <a href="${pageContext.request.contextPath}/resources/upload/${article.articleFile.articleFileName}.${article.articleFile.articleFileExt}"
			download>${article.articleFile.articleFileName}.${article.articleFile.articleFileExt}</a></div>
	<a href="${pageContext.request.contextPath}/updateArticle?articleId=${article.articleId}">수정</a>
	<a href="${pageContext.request.contextPath}/deleteArticle?articleId=${article.articleId}">삭제</a>
</body>
</html>