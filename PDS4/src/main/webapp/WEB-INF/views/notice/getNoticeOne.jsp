<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>getNoticeOne</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<!--[if lte IE 8]><script src="./resources/assets/js/ie/html5shiv.js"></script><![endif]-->
	<link rel="stylesheet" href="./resources/assets/css/main.css" />
	<!--[if lte IE 9]><link rel="stylesheet" href="./resources/assets/css/ie9.css" /><![endif]-->
	<!--[if lte IE 8]><link rel="stylesheet" href="./resources/assets/css/ie8.css" /><![endif]-->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#goList").click(function(){
				location.href = "getNoticeList";
			})
			$("#updateForm").click(function(){
				location.href = "updateNotice?noticeId=${noticeId}";
			})
			$("#deleteNo").click(function(){
				location.href = "deleteNotice?noticeId=${noticeId}";
			})
		})
	</script>
</head>
<body>
	<%@ include file="../module/tap.jsp" %>
	<div id="main">
		<div class="inner">
		<h1>get Notice One</h1>
		<table>
			<thead>
				<caption>getNoticeOne</caption>
			</thead>
			<tbody>
				<tr>
					<th>noticeId : </th>
					<td>
						<input type="text" name="noticeId" value="${noticeId}" readonly="readonly">
					</td>
				</tr>
				<tr>
					<th>noticeTitle : </th>
					<td><input type="text" name="noticeTitle" value="${noticeTitle}" readonly="readonly"></td>
				</tr>
				<tr>
					<th>noticeContent : </th>
					<td><textarea rows="20" cols="80" readonly="readonly" name="noticeContent">${noticeContent}</textarea> </td>
				</tr>
				<c:forEach var="noticeFile" items="${noticeFile}">
					<tr>
						<th>notice File Name : </th>
						<td>${noticeFile.noticeFileName}</td>
					</tr>
					<tr>
						<th>notice File Ext : </th>
						<td>${noticeFile.noticeFileExt}</td>
					</tr>
					<tr>
						<th>notice File Type : </th>
						<td>${noticeFile.noticeFileType}</td>
					</tr>
					<tr>
						<th>notice File Size : </th>
						<td>${noticeFile.noticeFileSize}</td>
					</tr>
					<tr>
						<th>notice File	DownLoad : </th>
						<td><a href="${pageContext.request.contextPath}/resources/upload/${noticeFile.noticeFileName}.${noticeFile.noticeFileExt}" download>${noticeFile.noticeFileName}.${noticeFile.noticeFileExt}</a></td>
					</tr>
				</c:forEach>	
				<tr>
					<td>
						<a href="${pageContext.request.contextPath}/updateNotice?noticeId=${noticeId}">[수정]</a>
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/deleteNotice?noticeId=${noticeId}">[삭제]</a>
					</td>
				</tr>
			</tbody>
		</table>
		<button type="button" id="goList">리스트로 돌아가기</button>
		<button type="button" id="updateForm">수정하기</button>
		<button type="button" id="deleteNo">삭제하기</button>
		</div>
	</div>
	<%@ include file="../module/bottom.jsp" %>
</body>
</html>