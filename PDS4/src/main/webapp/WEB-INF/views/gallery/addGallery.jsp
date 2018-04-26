<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>addGallery</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			${error};
			$('#add').click(function(){
				$('#upload').append('<div><input name="multipartFile" type="file"><button id="del" type="button">삭제</button></div>');
			});
			$(document).on('click','#del',function(){
				$(this).parent('div').remove();
			});
		});
	</script>
</head>
<body>
	<h1>addGallery</h1>
	<form action="${pageContext.request.contextPath}/addGallery" method="post" enctype="multipart/form-data">
		<div>
			주제<br>
			<input name="galleryTitle" type="text" value="${galleryTitle}" placeholder="등록하고자하는 이미지의 타이틍을 입력해주세요">
		</div>
		<div>
			본문<br>
			<textarea name="galleryContent" rows="5" cols="100" placeholder="등록한 이미지에 관한 부연설명을 입력해주세요">${galleryContent}</textarea>
		</div>
		<div id="upload">
			이미지업로드
			<div><input name="multipartFile" type="file"></div>
		</div>
		<button id="add" type="button">추가</button>
		<br><button type="submit">Gallery등록</button>
	</form>
</body>
</html>