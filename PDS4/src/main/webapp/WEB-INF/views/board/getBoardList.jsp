<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>getBoardList</title>
</head>
<body>
	<h1>getBoardList</h1>
	<table border="2">
		<thead>
			<tr>
				<th>
					boardId
				</th>
				<th>
					boardTitle
				</th>
				<th>
					boardContent
				</th>
				<th>
					boardDetail
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="board" items="${list}">
				<tr>
					<td>
						${board.boardId}
					</td>
					<td>
						${board.boardTitle}
					</td>
					<td>
						${board.boardContent}
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/getBoardOne?boardId=${board.boardId}">상세보기</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>	
	</table>
</body>
</html>