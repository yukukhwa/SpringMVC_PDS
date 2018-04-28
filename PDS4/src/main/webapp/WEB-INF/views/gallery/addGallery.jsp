<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>addGallery</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			/* 컨트롤러에 넘긴 데이터가 이미지가 아닐경우 경고문구가 넘어온다 */
			${error};
			
			/* 추가버튼 클릭시 파일을 담을 수 있는 공간생성 */
			$('#add').click(function(){
				$('#upload').append('<div><input name="multipartFile" type="file"><button id="del" type="button">삭제</button></div>');
			});
			
			/* 지우기버튼 클릭시 해당 파일공간 전체를 지운다 */
			$(document).on('click','#del',function(){
					if($(document).find('input[type="file"]').length == 1){
					alert('이미지파일 1개 이상은 등록해주세요.');
					return;
				}
				$(this).parent('div').remove();
			});
			
			/* Gallery등록버튼 클릭시 유효성 검사 */
			$('button#insert').click(function(){
				var insert = true;
				/* galleryTitle를 작성했는지 검사 */
				if($('input[name="galleryTitle"]').val() == ''){
					alert('galleryTitle를 작성해주세요.');
					insert = false;
					return;
				}
				
				/* galleryContent를 작성했는지 검사  */
				if($('textarea[name="galleryContent"]').val() == ''){
					alert('galleryContent를 작성해주세요');
					insert = false;
					return;
				}
				
				/* galleryFile 최대 3개까지 등록가능하도록 제한 */
				if($(document).find('input[type="file"]').length >= 4){
					alert('이미지파일을 최대 3개까지 등록가능합니다.');
					insert = false;
					return;
				}
				
				/* 파일 공간 전체를 확인하여 등록되어있는지, 등록한 파일이 이미지파일인지 확인 */
				$('input[type="file"]').each(function(i,e){
					if($(this).val() == ''){
						alert('이미지파일을 등록해주세요.');
						insert = false;
					}
					if($(this).val() != ''){
						var extension = $(this).val().split('.').pop().toLowerCase();
						console.log('extension: '+extension);
						if($.inArray(extension,['xwd','xpm','xbm','rgb','ppm','pgm','pbm','pnm','ras','tif','tiff','ief','gif','jpg','jpeg','png'])==-1){
							alert('이미지 파일만 등록가능합니다.');
							insert = false;
						}
					}
				});
				
				/* insert=true이면 제출 */
				if(insert){
					$('form').submit();
				}
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
			<div><input name="multipartFile" type="file"><button id="del" type="button">삭제</button></div>
		</div>
		<button id="add" type="button">이미지추가</button>
		<br><button id="insert" type="button">Gallery등록</button>
	</form>
</body>
</html>