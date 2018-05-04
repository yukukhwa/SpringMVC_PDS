<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>getGalleryOne</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<!--[if lte IE 8]><script src="./resources/assets/js/ie/html5shiv.js"></script><![endif]-->
	<link rel="stylesheet" href="./resources/assets/css/main.css" />
	<!--[if lte IE 9]><link rel="stylesheet" href="./resources/assets/css/ie9.css" /><![endif]-->
	<!--[if lte IE 8]><link rel="stylesheet" href="./resources/assets/css/ie8.css" /><![endif]-->
</head>
<body>
	<%@ include file="../module/tap.jsp" %>
	<!-- Main -->
		<div id="main">
			<div class="inner">
				<section>
					<h1>getGalleryOne</h1>
					<div>
						주제<br>
						<blockquote>${galleryTitle}</blockquote>
					</div>
					<div>
						본문<br>
						<blockquote>${galleryContent}</blockquote>
					</div>
					<div class="box alt">
						<div class="row uniform">
							<c:forEach var="galleryFile" items="${galleryFileList}">
								<div class="4u 12u(small)">
									<span class="image fit">
										<img alt="${galleryFile.galleryFileName}.${galleryFile.galleryFileExt}" src="${pageContext.request.contextPath}/resources/upload/${galleryFile.galleryFileName}.${galleryFile.galleryFileExt}">
									</span>
								</div>
							</c:forEach>
						</div>
					</div>
					<ul class="actions fit">
						<li>
							<a href="${pageContext.request.contextPath}/updateGallery?galleryId=${galleryId}" class="button fit">수정하기</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/deleteGallery?galleryId=${galleryId}" class="button fit">삭제하기</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/getGalleryList" class="button fit">목록으로</a>
						</li>					
					</ul>
				</section>
			</div>
		</div>
	<%@ include file="../module/bottom.jsp" %>
</body>
</html>