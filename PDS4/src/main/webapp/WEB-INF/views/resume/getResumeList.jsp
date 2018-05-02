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
	<form action="${pageContext.request.contextPath}/getResumeList" method="get">
		<select name="pagePerRow">
			<option value="3">3줄씩보기
			<option value="5">5줄씩보기
			<option value="10">10줄씩보기
		</select>
	</form>
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
			<c:forEach items="${list}"  var="list">
				<tr>
					<td>${list.resumeId}</td>
					<td>${list.resumeTitle}</td>
					<td>${list.resumeContent}</td>
					<td><a href="${pageContext.request.contextPath}/resources/upload/
							${list.resumeFile.resumeFileName}.${list.resumeFile.resumeFileExt}" download>
							${list.resumeFile.resumeFileName}.${list.resumeFile.resumeFileExt}</a></td>
					<td>${list.resumeFile.resumeFileSize } KB</td>
				</tr>
			</c:forEach>
		</tbody>	
	</table>
	<%-- <c:if test="${currentPage > 1}">
		<a href="${pageContext.request.contextPath}/getResumeList?currentPage=1&pagePerRow=${pagePerRow}">[처음]</a>
		<a href="${pageContext.request.contextPath}/getResumeList?currentPage=${currentPage - 1}&pagePerRow=${pagePerRow}">[이전]</a>
	</c:if>
	<c:forEach var="i" items="${pageList}">
		<a href="${pageContext.request.contextPath}/getResumeList?currentPage=${i}&pagePerRow=${pagePerRow}">[${i}]</a>
	</c:forEach>
	<c:if test="${currentPage < totalPage}">
		<a href="${pageContext.request.contextPath}/getResumeList?currentPage=${currentPage + 1}&pagePerRow=${pagePerRow}">[다음]</a>
		<a href="${pageContext.request.contextPath}/getResumeList?currentPage=${totalPage}&pagePerRow=${pagePerRow}">[마지막]</a>
	</c:if> --%>
</body>
</html>