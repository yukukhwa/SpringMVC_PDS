<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>addNotice</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<!--[if lte IE 8]><script src="./resources/assets/js/ie/html5shiv.js"></script><![endif]-->
	<link rel="stylesheet" href="./resources/assets/css/main.css" />
	<!--[if lte IE 9]><link rel="stylesheet" href="./resources/assets/css/ie9.css" /><![endif]-->
	<!--[if lte IE 8]><link rel="stylesheet" href="./resources/assets/css/ie8.css" /><![endif]-->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#addFile")(function(){
				
			})
		})
	</script>
</head>
<body>
	<%@ include file="../module/tap.jsp" %>
	<div id="main">
		<div class="inner">
			<h1>addNotice</h1>
			<form action="${pageContext.request.contextPath}/addNotice" method="post" enctype="multipart/form-data">
				<fieldset>
					<table>
						<tr>
							<th>notice Title: </th>
							<td><input type="text" name="noticeTitle" placeholder="제목을 입력해주세요"></td>
						</tr>
						<tr>
							<th>notice Content: </th>
							<td>
								<textarea rows="20" cols="20" name="noticeContent" placeholder="내용을 입력해주세요"></textarea>
							</td>
						</tr>
						<tr>
							<th>notice file: </th>
							<td><input type="file" name="multipartFile"></td>
						</tr>
						<tr>
							<th>notice file2: </th>
							<td><input type="file" name="multipartFile"></td>
						</tr>
					</table>
					<button type="button" id="addFile">파일추가하기</button>
					<button type="submit">공지등록하기</button>
				</fieldset>
			</form>
		</div>
	</div>
	<%@ include file="../module/bottom.jsp" %>
</body>
</html>