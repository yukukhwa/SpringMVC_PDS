<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addNotice</title>
</head>
<body>
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
			<button type="submit">공지등록하기</button>
		</fieldset>
	</form>
</body>
</html>