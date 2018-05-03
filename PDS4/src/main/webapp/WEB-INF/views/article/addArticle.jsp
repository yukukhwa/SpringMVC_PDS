<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>addArticle</title>
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
	<h1>addArticle</h1>
	<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/addArticle" method="post">
		<div>ResumeTitle : <input type="text" name="articleTitle"></div>
		<div>ResumeContent : <input type="text" name="articleContent"></div>
		<div id="upload">
			<div>
				<input name="multipartFile" type="file">				
				<button id="del" type="button">삭제</button>
			</div>			
		</div>
		<button id="add" type="button">파일추가</button><br>		
		<button type="submit">등록</button>
	</form>
</body>
</html>