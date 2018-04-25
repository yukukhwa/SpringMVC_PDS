<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>addGallery</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			if(${error} != null){
				alret(error);
			}
		});
	</script>
</head>
<body>
	<h1>addGallery</h1>
	<form action="${pageContext.request.contextPath}/addGallery" method="post" enctype="multipart/form-data">
		<div>주제: <input name="galleryTitle" type="text" placeholder="등록하고자하는 이미지의 타이틍을 입력해주세요"></div>
		<div>본문: <textarea name="galleryContent" rows="5" cols="100" placeholder="등록한 이미지에 관한 부연설명을 입력해주세요"></textarea></div>
		<div>이미지 업로드: <input name="multipartFile" type="file"></div>
		<button type="submit">Gallery등록</button>
	</form>
</body>
</html>