<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>getResumeOne</title>
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
			<h1>getResumeOne</h1>
			<div><a href="${pageContext.request.contextPath}/getResumeList">목록으로 돌아가기</a></div>
			<div>작성자 : <input name="resumeId" type="text" value="${resume.resumeId}" readonly></div>
			<div>제목 : <input name="resumeTitle" type="text" value="${resume.resumeTitle}" readonly></div>
			<div>내용<br>
			<textarea name="resumeContent" rows="5" cols="80" readonly>${resume.resumeContent}</textarea></div>
			<div>첨부파일 : <a href="${pageContext.request.contextPath}/resources/upload/${resume.resumeFile.resumeFileName}.${resume.resumeFile.resumeFileExt}"
					download>${resume.resumeFile.resumeFileName}.${resume.resumeFile.resumeFileExt}</a></div>
			<a href="${pageContext.request.contextPath}/updateResume?resumeId=${resume.resumeId}">수정</a>
			<a href="${pageContext.request.contextPath}/deleteResume?resumeId=${resume.resumeId}">삭제</a>
		</div>
	</div>
	<%@ include file="../module/bottom.jsp" %>
</body>
</html>