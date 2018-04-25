<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>insertArticle</title>
</head>
<body>
	<h1>insertArticle</h1>
	<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/addArticle" method="post">
		<div>articleTitle : <input type="text" name="articleTitle"></div>
		<div>articleContent : <input type="text" name="articleContent"></div>
		<div>articleFile : <input type="file" name="multipartFile"></div>
		<button type="submit">입력</button>
	</form>
</body>
</html>