<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>getNoticeList</title>
</head>
<body>
	<h1>getNoticeList</h1>
	<fieldset>
		<table border="1">
			<caption>getNoticeList</caption>
				<c:forEach var="notice" items="${list}">
					<thead>
						<tr>
							<th>Notice Title</th>
							<th>Notice Content</th>
							<th>Notice File</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${notice.noticeTitle}</td>
							<td>${notice.noticeContent}</td>
							<td></td>
							<td><a href="#">삭제</a></td>
						</tr>
				</c:forEach>
		</table>
	</fieldset>
	
</body>
</html>