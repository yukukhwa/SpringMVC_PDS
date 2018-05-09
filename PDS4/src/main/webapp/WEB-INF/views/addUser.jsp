<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>addUser</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$('#btnConfirm').click(function(){
					$.post({
				      url: "/pds/idCheck",
				      data: { id : $('#id').val()},
				      success:function( json ) {// result : String, XML, JSON
				      	//alert(json);
				      	if(json == 'T'){
				      		alert('사용가능한 아이디가 맞습니다');
				      	}else{
				      		alert('사용가능한 아이디가 아닙니다');
				      	}
				      }
				    });
				});
			   
			});
		</script>
	</head>
	<body>
		<h1>ADD USER PAGE</h1>
		<form action="${pageContext.request.contextPath}/addUser" method="post">
			<div>
				ID : <input type="text" name="id" id="id">
				<button type="button" id="btnConfirm">ID확인</button>
			</div>
			<div>
				NAME : <input type="text" name="name">
			</div>
			<div>
				<button type="submit">회원가입</button>
			</div>
		</form>
	</body>
</html>