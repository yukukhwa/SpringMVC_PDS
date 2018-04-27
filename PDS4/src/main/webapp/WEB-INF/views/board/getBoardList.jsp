<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			if($('select#pagePerRow').val() != ${pagePerRow}){
				$('select#pagePerRow').val(${pagePerRow});
			}
			$('select#pagePerRow').change(function(){
				$(this).parent('form').submit();	
			});	
		});
	</script>
<title>getBoardList</title>
</head>
<body>
	<h1>getBoardList</h1>
	<table border="1">
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
	<form action="${pageContext.request.contextPath}/getBoardList" method="get">
		<select id="pagePerRow" name="pagePerRow">
			<option value="3">3개씩보기</option>
			<option value="5">5개씩보기</option>
			<option value="10">10개씩보기</option>	
		</select>	
	</form>
	<c:if test="${currentPage>1}">
		<a href="${pageContext.request.contextPath}/getBoardList?currentPage=1&pagePerRow=${pagePerRow}">[처음으로]</a>
		<a href="${pageContext.request.contextPath}/getBoardList?currentPage=${currentPage-1}&pagePerRow=${pagePerRow}">[이전]</a>
	</c:if>
	<c:if test="${currentPage<lastPage}">
		<a href="${pageContext.request.contextPath}/getBoardList?currentPage=${currentPage+1}&pagePerRow=${pagePerRow}">[다음]</a>
		<a href="${pageContext.request.contextPath}/getBoardList?currentPage=${lastPage}&pagePerRow=${pagePerRow}">[마지막으로]</a>
	</c:if>
</body>
</html>