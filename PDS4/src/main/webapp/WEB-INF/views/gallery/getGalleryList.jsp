<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
	<title>getGalleryList</title>
	<meta charset="utf-8" />
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
				$('form#pagePerRow').submit();
			});
		});
	</script>
</head>
<body>
	<%@ include file="../module/tap.jsp" %>
		
		<!-- Main -->
		<div id="main">
			<div class="inner">
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
				<form id="pagePerRow" action="${pageContext.request.contextPath}/getGalleryList" method="get">
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
			</div>
		</div>
	
	<%@ include file="../module/bottom.jsp" %>
</body>
</html>