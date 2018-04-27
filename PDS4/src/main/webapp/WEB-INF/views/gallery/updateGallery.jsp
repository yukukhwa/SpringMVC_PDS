<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>updateGallery</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			/* 추가버튼 클릭시 파일을 담을 수 있는 공간생성 */
			$('#add').click(function(){
				$('#upload').append('<div><input name="multipartFile" type="file"><button id="del" type="button">삭제</button></div>');
			});
			
			/* 지우기버튼 클릭시 해당 파일공간 전체를 지운다 */
			$(document).on('click','#del',function(){
				$(this).parent('div').remove();
			});
		});
	</script>
</head>
<body>
	<h1>updateGallery</h1>
	<form action="${pageContext.request.contextPath}/updateGallery" method="post" enctype="multipart/form-data">
		<input type="hidden" name="galleryId" value="${galleryId}">
		<div>
			주제<br>
			<input name="galleryTitle" type="text" value="${galleryTitle}">
		</div>
		<div>
			본문<br>
			<textarea name="galleryContent" rows="5" cols="100">${galleryContent}</textarea>
		</div>
		<c:forEach var="galleryFile" items="${galleryFileList}">
			<div>
				<img width="400px" height="300px" alt="${galleryFile.galleryFileName}.${galleryFile.galleryFileExt}" src="${pageContext.request.contextPath}/resources/upload/${galleryFile.galleryFileName}.${galleryFile.galleryFileExt}">
			</div>
		</c:forEach>
		<div id="upload">
		</div>
		<button id="add" type="button">이미지추가</button>
		<br><button id="update" type="submit">등록하기</button>
	</form>
</body>
</html>