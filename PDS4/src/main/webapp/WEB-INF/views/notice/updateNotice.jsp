<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>update Notice</title>
</head>
<body>
	<h1>update Notice Form</h1>
	<form method="post" action="${pageContext.request.contextPath}/updateNotice">
		<table>
			<thead>
				<cation>update Form</cation>
			</thead>
			<tbody>
				<tr>
					<th> Notice Title : </th>
					<td>
						<input type="text" name="noticeTitle" value="">
					</td>
				</tr>
				<tr>
					<th> Notice Content : </th>
					<td>
						<textarea rows="20" cols="80" name="noticeContent"></textarea>
					</td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="수정하기">
	</form>
</body>
</html>