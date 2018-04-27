<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>getArticle</title>
</head>
<body>
	<h1>Article List</h1>
	<table border="1">
		<thead>
			<tr>
				<th>article ID</th>
				<th>article Title</th>
				<th>article Content</th>
				<th>article File Name</th>
				<th>article File Size</th>
				<th>보기</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}"  var="list">
				<tr>
					<td>${list.articleId}</td>
					<td>${list.articleTitle}</td>
					<td>${list.articleContent}</td>
					<td><a href="${pageContext.request.contextPath}/resources/upload/
							${list.articleFile.articleFileName}.${list.articleFile.articleFileExt}" download>
							${list.articleFile.articleFileName}.${list.articleFile.articleFileExt}</a></td>
					<td>${list.articleFile.articleFileSize} KB</td>
					<td><a href="${pageContext.request.contextPath}/getArticle?articleId=${list.articleId}">보기</a></td>
					<td><a href="${pageContext.request.contextPath}/deleteArticle?articleId=${list.articleId}">삭제</a></td>
				</tr>		
			</c:forEach>
		</tbody>	
	</table>

</body>
</html>