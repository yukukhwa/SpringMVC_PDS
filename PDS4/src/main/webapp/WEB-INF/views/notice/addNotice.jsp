<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addNotice</title>
</head>
<body>
	<h1>addNotice</h1>
	<form action="${pageContext.request.contextPath}/addNotice" method="post" enctype="multipart/form-data">
		<div>
			notice Title: <input type="text" name="noticeTitle">
		</div>
		<div>
			notice Content: <textarea name="noticeContent"></textarea>
		</div>
		<div>
			notice file: <input type="file" name="multipartFile">
		</div>
		<button type="submit">공지등록하기</button>
	</form>
</body>
</html>