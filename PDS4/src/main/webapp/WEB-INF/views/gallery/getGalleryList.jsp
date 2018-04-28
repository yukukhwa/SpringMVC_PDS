<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>getGalleryList</title>
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
	<h1>getGalleryList</h1>
	<table border="1">
		<thead>
			<tr>
				<th>
					GalleryId
				</th>
				<th>
					GalleryTitle
				</th>
				<th>
					GalleryContent
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="gallery" items="${list}">
				<tr>
					<td>
						${gallery.galleryId}
					</td>
					<td>
						${gallery.galleryTitle}
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/getGalleryOne?galleryId=${gallery.galleryId}">${f:substring(gallery.galleryContent,0,3)}...</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form action="${pageContext.request.contextPath}/getGalleryList" method="get">
		<input type="hidden" name="currentPage" value="${currentPage}">
		<select name="pagePerRow">
			<option value="3">3줄씩보기
			<option value="5">5줄씩보기
			<option value="10">10줄씩보기
			<option value="20">20줄씩보기
		</select>
	</form>
	<c:if test="${currentPage > 1}">
		<a href="${pageContext.request.contextPath}/getGalleryList?currentPage=1&pagePerRow=${pagePerRow}">[처음으로]</a>
		<a href="${pageContext.request.contextPath}/getGalleryList?currentPage=${currentPage - 1}&pagePerRow=${pagePerRow}">[이전]</a>
	</c:if>
	<c:forEach var="i" items="${pageList}">
		<a href="${pageContext.request.contextPath}/getGalleryList?currentPage=${i}&pagePerRow=${pagePerRow}">[${i}]</a>
	</c:forEach>
	<c:if test="${currentPage < totalPage}">
		<a href="${pageContext.request.contextPath}/getGalleryList?currentPage=${currentPage + 1}&pagePerRow=${pagePerRow}">[다음]</a>
		<a href="${pageContext.request.contextPath}/getGalleryList?currentPage=${totalPage}&pagePerRow=${pagePerRow}">[마지막으로]</a>
	</c:if>
</body>
</html>