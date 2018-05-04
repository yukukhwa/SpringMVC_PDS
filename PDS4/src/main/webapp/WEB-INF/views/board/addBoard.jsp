<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>addBoard</title>
	<meta charset="utf-8" />
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
				<h1>addBoard</h1>
				<form action="${pageContext.request.contextPath}/addBoard" method="post" enctype="multipart/form-data">
					<div>
						boardTitle : <input type="text" name="boardTitle">
					</div><br>
					<div>
						boardContent : <textarea name="boardContent"></textarea>
					</div><br>
					<div>
						boardFile : <input type="file" name="multipartFile">
					</div><br>
					<button type="submit">입력</button>
				</form>
			</div>
		</div>
	<%@ include file="../module/bottom.jsp" %>		
</body>
</html>