<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>getBoardOne</title>
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
				<h1>getBoardOne</h1>
				<div>
					boardTitle<br>
					<input type="text" name="boardTitle" value="${board.boardTitle}">
				</div>	
				<div>
					boardContent<br>
					<textarea name="boardContent">${board.boardContent}</textarea>
				</div>
				<c:forEach var="boardFileList" items="${boardFileList}">
				<div>
					boardFile <br>
					<a href="${pageContext.request.contextPath}/resources/upload/${boardFileList.boardFileName}.${boardFileList.boardFileExt}">${boardFileList.boardFileName}.${boardFileList.boardFileExt}</a>
				</div>
				</c:forEach>
				<div>
					<a href="#">수정</a>
				</div>
				<div>
					<a href="#">삭제</a>
				</div>
			</div>
		</div>
	<%@ include file="../module/bottom.jsp" %>
</body>
</html>