<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>updateResumeOne</title>
</head>
<body>
	<h1>updateResumeOne</h1>
	<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/updateResume" method="post">
		<div>작성자 : <input name="resumeId" type="text" value="${resume.resumeId}" readonly></div>
		<div>제목 : <input name="resumeTitle" type="text" value="${resume.resumeTitle}"></div>
		<div>내용<br>
		<textarea name="resumeContent" rows="5" cols="80">${resume.resumeContent}</textarea></div>
		<div>첨부파일 : ${resume.resumeFile.resumeFileName}.${resume.resumeFile.resumeFileExt}</div>
		<!-- <button id="fileDelete" type="button">파일삭제</button><br> -->
		<button type="submit">수정완료</button>
		<!-- <button type="submit" name="cancle">취소</button> -->
	</form>
</body>
</html>