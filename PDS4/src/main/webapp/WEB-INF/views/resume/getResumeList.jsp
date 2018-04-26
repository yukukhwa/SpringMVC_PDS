<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>getResumeList</title>
</head>
<body>
	<h1>Resume List</h1>
	<table border="1">
		<thead>
			<tr>
				<td>resume ID</td>
				<td>resume Title</td>
				<td>resume Content</td>
				<td>resume File Name</td>
				<td>resume File Size</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}"  var="resume">
				<tr>
					<td>${resume.resumeId }</td>
					<td>${resume.resumeTitle }</td>
					<td>${resume.resumeContent }</td>
					<td>${resume.resumeFileName }.${resume.resumeFileExt }</td>
					<td>${resume.resumeFileSize }</td>
				</tr>		
			</c:forEach>
		</tbody>	
	</table>
</body>
</html>