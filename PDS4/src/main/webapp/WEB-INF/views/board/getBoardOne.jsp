<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>getBoardOne</title>
</head>
<body>
	<h1>getBoardOne</h1>
	<form action="">
		<table border="1">
			<thead>
				<tr>
					<td>
						boardId
					</td>
					<td>
						boardFileName
					</td>
					<td>
						boardFileExt
					</td>
					<td>
						baordFileType
					</td>
					<td>
						boardFileSize
					</td>	
					<td>
						수정
					</td>	
					<td>
						삭제
					</td>				
				</tr>
			</thead>
			<tbody>
				<c:forEach var="boardFile" items="${boardFileList}">
					<tr>
						<td>
							${boardFile.boardId}
						</td>
						<td>
							${boardFile.boardFileName}
						</td>
						<td>
							${boardFile.boardFileExt}
						</td>
						<td>
							${boardFile.boardFileType}
						</td>
						<td>
							${boardFile.boardFileSize}
						</td>
						<td>
							<a href="#">수정</a>
						</td>
						<td>
							<a href="${pageContext.request.contextPath}/getBoardOne?boardId=${boardFile.boardId}">삭제</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>