<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>getGalleryList</title>
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
</body>
</html>