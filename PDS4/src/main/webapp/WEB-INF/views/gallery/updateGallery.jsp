<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>updateGallery</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<!--[if lte IE 8]><script src="./resources/assets/js/ie/html5shiv.js"></script><![endif]-->
	<link rel="stylesheet" href="./resources/assets/css/main.css" />
	<!--[if lte IE 9]><link rel="stylesheet" href="./resources/assets/css/ie9.css" /><![endif]-->
	<!--[if lte IE 8]><link rel="stylesheet" href="./resources/assets/css/ie8.css" /><![endif]-->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			/* 에러발생시 */
			${error}
			
			/* 추가버튼 클릭시 파일을 담을 수 있는 공간생성 */
			$('#add').click(function(){
				$('#upload').append('<div><input name="multipartFile" type="file"><button id="del" type="button" class="button special small">삭제</button></div>');
			});
			
			/* 지우기버튼 클릭시 해당 파일공간 전체를 지운다 */
			$(document).on('click','#del',function(){
				$(this).parent('div').remove();
			});
			
			$(document).on('click','#imgDel',function(){
				var alt = $(this).parents('div.4u').find('img').attr('alt');
				$(this).parents('form').append('<input name="deleteImg" type="hidden" value="'+alt+'">');
				$(this).parents('div.4u').remove();
			});
			
			/* 재등록버튼 클릭시 유효성 검사 */
			$('button#update').click(function(){
				var update = true;
				/* galleryTitle를 작성했는지 검사 */
				if($('input[name="galleryTitle"]').val() == ''){
					alert('galleryTitle를 작성해주세요.');
					update = false;
					return;
				}
				
				/* galleryContent를 작성했는지 검사  */
				if($('textarea[name="galleryContent"]').val() == ''){
					alert('galleryContent를 작성해주세요');
					update = false;
					return;
				}
				
				/* galleryFile 최대 3개까지 등록가능하도록 제한 */
				if($(document).find('input[type="file"]').length+$(document).find('img#dbGallery').length >= 4){
					alert('이미지파일을 최대 3개까지 등록가능합니다.');
					update = false;
					return;
				}
				
				if($(document).find('input[type="file"]').length+$(document).find('img#dbGallery').length == 0){
					alert('이미지파일을 최소 1개이상 등록해야합니다.');
					$('#upload').append('<div><input name="multipartFile" type="file"></div>');
					update = false;
					return;
				}
				
				/* 파일 공간 전체를 확인하여 등록되어있는지, 등록한 파일이 이미지파일인지 확인 */
				$('input[type="file"]').each(function(i,e){
					if($(this).val() == ''){
						alert('이미지파일을 등록해주세요.');
						update = false;
					}
					if($(this).val() != ''){
						var extension = $(this).val().split('.').pop().toLowerCase();
						console.log('extension: '+extension);
						if($.inArray(extension,['xwd','xpm','xbm','rgb','ppm','pgm','pbm','pnm','ras','tif','tiff','ief','gif','jpg','jpeg','png'])==-1){
							alert('이미지 파일만 등록가능합니다.');
							update = false;
						}
					}
				});
				
				/* insert=true이면 제출 */
				if(update){
					$('form#updateGallery').submit();
				}
			});
		});
	</script>
</head>
<body>
	<%@ include file="../module/tap.jsp" %>
	<!-- Main -->
		<div id="main">
			<div class="inner">
				<section>
					<h1>updateGallery</h1>
					<form id="updateGallery" action="${pageContext.request.contextPath}/updateGallery" method="post" enctype="multipart/form-data">
						<input type="hidden" name="galleryId" value="${galleryId}">
						<div>
							주제<br>
							<input name="galleryTitle" type="text" value="${galleryTitle}">
						</div>
						<br>
						<div>
							본문<br>
							<textarea name="galleryContent" rows="5" cols="100">${galleryContent}</textarea>
						</div>
						<br>
						<div class="box alt">
							<div class="row uniform">
								<c:forEach var="galleryFile" items="${galleryFileList}">
									<div class="4u 12u(small)">
										<span class="image fit">
											<img id="dbGallery" width="400px" height="300px" alt="${galleryFile.galleryFileName}.${galleryFile.galleryFileExt}" src="${pageContext.request.contextPath}/resources/upload/${galleryFile.galleryFileName}.${galleryFile.galleryFileExt}">
											<button id="imgDel" type="button" class="button fit small">이미지삭제</button>
										</span>
									</div>
								</c:forEach>
							</div>
						</div>
						<div id="upload">
						</div>
						<br>
						<ul class="actions fit">
							<li>
								<button id="add" type="button" class="button fit icon fa-upload">이미지추가</button>
							</li>
							<li>
								<button id="update" type="button" class="button fit icon fa-save">재등록하기</button>
							</li>				
						</ul>						
					</form>
				</section>
			</div>
		</div>
	<%@ include file="../module/bottom.jsp" %>
</body>
</html>