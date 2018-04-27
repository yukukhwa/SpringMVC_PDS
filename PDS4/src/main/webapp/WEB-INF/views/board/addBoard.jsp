<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>addBoard</title>
</head>
<body>
	<h1>addBoard</h1>
	<form action="${pageContext.request.contextPath}/addBoard" method="post" enctype="multipart/form-data">
		<div>
			boardTitle : <input type="text" name="boardTitle">
		</div><br>
		<div>
			boardContent : <textarea name="boardContent"></textarea>
		</div><br>
		<div>
			boardTitleFile : <input type="file" name="multipartFile">
		</div><br>
		<div>
			boardTitleFile : <input type="file" name="multipartFile">
		</div><br>
		<div>
			boardTitleFile : <input type="file" name="multipartFile">
		</div><br>
		<button type="submit">입력</button>
	</form>
</body>
</html>