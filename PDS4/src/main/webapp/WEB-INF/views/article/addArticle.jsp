<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>addArticle</title>
</head>
<body>
	<h1>addArticle</h1>
	<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/addArticle" method="post">
		<div>articleTitle : <input type="text" name="articleTitle"></div>
		<div>articleContent : <input type="text" name="articleContent"></div>
		<div>articleFile1 : <input type="file" name="multipartFile"></div>
		<div>articleFile2 : <input type="file" name="multipartFile"></div>
		<div>articleFile3 : <input type="file" name="multipartFile"></div>
		<button type="submit">등록</button>
	</form>
</body>
</html>