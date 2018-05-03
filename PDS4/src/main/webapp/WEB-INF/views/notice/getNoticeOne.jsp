<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>getNoticeOne</title>
</head>
<body>
	<h1>get Notice One</h1>
	<table>
		<thead>
			<caption>getNoticeOne</caption>
		</thead>
		<tbody>
			<c:forEach var="notice" items="${list}">
				<tr>
					<th>noticeTitle : </th>
					<td><input type="text" name="noticeTitle" value="${notice.noticeTitle}" readonly="readonly"></td>
				</tr>
				<tr>
					<th>noticeContent : </th>
					<td><textarea rows="20" cols="80" readonly="readonly" name="noticeContent">${notice.noticeContent}</textarea> </td>
				</tr>
				<tr>
					<th>notice File Name : </th>
					<td>${notice.noticeFile.noticeFileName}</td>
				</tr>
				<tr>
					<th>notice File Ext : </th>
					<td>${notice.noticeFile.noticeFileExt}</td>
				</tr>
				<tr>
					<th>notice File Type : </th>
					<td>${notice.noticeFile.noticeFileType}</td>
				</tr>
				<tr>
					<th>notice File Size : </th>
					<td>${notice.noticeFile.noticeFileSize}</td>
				</tr>
				<tr>
					<th>notice File	DownLoad : </th>
					<td><a href="${pageContext.request.contextPath}/resources/upload/${notice.noticeFile.noticeFileName}.${notice.noticeFile.noticeFileExt}" download>${notice.noticeFile.noticeFileName}.${notice.noticeFile.noticeFileExt}</a></td>
				</tr>
				<tr>
					<td>
						<a href="${pageContext.request.contextPath}/getNoticeList">[리스트로 돌아가기]</a>
						<a href="${pageContext.request.contextPath}/updateNoticeForm?noticeId=${notice.noticeId}">[수정]</a>
						<a href="${pageContext.request.contextPath}/deleteNotice?noticeId=${notice.noticeId}">[삭제]</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	

</body>
</html>