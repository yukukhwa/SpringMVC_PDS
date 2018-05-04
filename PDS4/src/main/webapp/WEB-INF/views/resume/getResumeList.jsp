<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>getResumeList</title>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<!--[if lte IE 8]><script src="./resources/assets/js/ie/html5shiv.js"></script><![endif]-->
	<link rel="stylesheet" href="./resources/assets/css/main.css" />
	<!--[if lte IE 9]><link rel="stylesheet" href="./resources/assets/css/ie9.css" /><![endif]-->
	<!--[if lte IE 8]><link rel="stylesheet" href="./resources/assets/css/ie8.css" /><![endif]-->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('select').val(${pagePerRow});
			$('select').change(function(){
				$('form').submit();
			});
		});
	</script>
</head>
<body>
	<%@ include file="../module/tap.jsp" %>
	<!-- Main -->
	<div id="main">
		<div class="inner">
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
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}"  var="resume">
						<tr>
							<td>${resume.resumeId}</td>
							<td><a href="${pageContext.request.contextPath }/getResumeOne?resumeId=${resume.resumeId}">${resume.resumeTitle}</a></td>
							<td>${resume.resumeContent}</td>
						</tr>
					</c:forEach>
				</tbody>	
			</table>
			<c:if test="${currentPage > 1}">
				<a href="${pageContext.request.contextPath}/getResumeList?currentPage=1&pagePerRow=${pagePerRow}">[처음]</a>
				<a href="${pageContext.request.contextPath}/getResumeList?currentPage=${currentPage - 1}&pagePerRow=${pagePerRow}">[이전]</a>
			</c:if>
			<c:forEach var="i" items="${pageList}">
				<a href="${pageContext.request.contextPath}/getResumeList?currentPage=${i}&pagePerRow=${pagePerRow}">[${i}]</a>
			</c:forEach>
			<c:if test="${currentPage < totalPage}">
				<a href="${pageContext.request.contextPath}/getResumeList?currentPage=${currentPage + 1}&pagePerRow=${pagePerRow}">[다음]</a>
				<a href="${pageContext.request.contextPath}/getResumeList?currentPage=${totalPage}&pagePerRow=${pagePerRow}">[마지막]</a>
			</c:if>
		</div>
	</div>
	<%@ include file="../module/bottom.jsp" %>
</body>
</html>