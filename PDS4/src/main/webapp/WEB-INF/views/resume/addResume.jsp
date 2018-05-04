<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>addResume</title>
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
			<h1>addResume</h1>
			<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/addResume" method="post">
				<div>ResumeTitle : <input type="text" name="ResumeTitle"></div>
				<div>ResumeContent : <input type="text" name="ResumeContent"></div>
				<div>Multipartfile : <input type="file" name="Multipartfile"></div>
				<button type="submit">등록</button>
			</form>
		</div>
	</div>
	<%@ include file="../module/bottom.jsp" %>
</body>
</html>