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
		<table border="1">
			<caption>getNoticeList</caption>
				<c:forEach var="notice" items="${list}">
					<thead>
						<tr>
							<th>Notice Id</th>
							<th>Notice Title</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								${notice.noticeId}
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/getNoticeOne?noticeId=${notice.noticeId}">${notice.noticeTitle}</a>
							</td>
						</tr>
				</c:forEach>
		</table>
		<!-- 페이징 -->
		<c:if test="${currnetPage>=1}">
			<a href="${pageContext.request.contextPath}/getNoticeList?currentPage=1">[처음으로]</a>
			<a href="${pageContext.request.contextPath}/getNoticeList?currentPage=${currentPage-1}">[◀]</a>
		</c:if>
		<c:if test="${currentPage!=lastPage && currentPage<=1}">
			<a href="${pageContext.request.contextPath}/getNoticeList?currentPage=${currentPage+1}">[▶]</a>
		</c:if>
		<c:if test="${currentPage!=lastPage}">
			<a href="${pageCottext.request.contextPath}/getNoticeList?lastPage=${lastPage}">[마지막으로]</a>
		</c:if>
</body>
</html>