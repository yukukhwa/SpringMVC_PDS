<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>addResume</title>
</head>
<body>
	<h1>addResume</h1>
	<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/addResume" method="post">
		<div>ResumeTitle : <input type="text" name="ResumeTitle"></div>
		<div>ResumeContent : <input type="text" name="ResumeContent"></div>
		<div>Multipartfile : <input type="file" name="Multipartfile"></div>
		<button type="submit">등록</button>
	</form>
</body>
</html>