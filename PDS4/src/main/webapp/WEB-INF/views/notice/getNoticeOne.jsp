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
			<tr>
				<th>notice Id</th>
				<th>notice File Name</th>
				<th>notice File Ext</th>
				<th>notice File Type</th>
				<th>notice File Size</th>
				<th>notice File	DownLoad</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="noticeFile" items="${noticeFileList}">
			<tr>
				<td>
					${noticeFile.noticeId}
				</td>
				<td>
					${noticeFile.noticeFileName}
				</td>
				<td>
					${noticeFile.noticeFileExt}
				</td>
				<td>
					${noticeFile.noticeFileType}
				</td>
				<td>
					${noticeFile.noticeFileSize}
				</td>
				<td>
					<a href="#">파일다운로드</a>	
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	

</body>
</html>