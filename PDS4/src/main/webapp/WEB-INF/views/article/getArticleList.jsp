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
				<td>article ID</td>
				<td>article Title</td>
				<td>article Content</td>
				<td>article File Name</td>
				<td>article File Size</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}"  var="list">
				<tr>
					<td>${list.articleId }</td>
					<td>${list.articleTitle }</td>
					<td>${list.articleContent }</td>
					<td>${list.articleFile.articleFileName }.${list.articleFile.articleFileExt }</td>
					<td>${list.articleFile.articleFileSize } KB</td>
				</tr>		
			</c:forEach>
		</tbody>	
	</table>

</body>
</html>