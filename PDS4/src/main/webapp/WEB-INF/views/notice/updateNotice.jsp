<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>update Notice</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<!--[if lte IE 8]><script src="./resources/assets/js/ie/html5shiv.js"></script><![endif]-->
	<link rel="stylesheet" href="./resources/assets/css/main.css" />
	<!--[if lte IE 9]><link rel="stylesheet" href="./resources/assets/css/ie9.css" /><![endif]-->
	<!--[if lte IE 8]><link rel="stylesheet" href="./resources/assets/css/ie8.css" /><![endif]-->
</head>
<body>
	<%@ include file="../module/tap.jsp" %>
	<div id="main">
		<div class="inner">
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
								<input type="text" name="noticeTitle" value="${noticeTitle}">
							</td>
						</tr>
						<tr>
							<th> Notice Content : </th>
							<td>
								<textarea rows="20" cols="80" name="noticeContent">${noticeContent}</textarea>
							</td>
						</tr>						<tr>
							<th> Notice File : </th>
							<td>
								${noticeFile.noticeFileName}.${noticeFile.noticeFileExt}
							</td>
						</tr>

					</tbody>
				</table>
				<button type="submit">수정하기</button>
			</form>
		</div>
	</div>	
	<%@ include file="../module/bottom.jsp" %>
</body>
</html>