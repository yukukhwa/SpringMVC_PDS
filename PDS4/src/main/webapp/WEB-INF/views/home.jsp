<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!DOCTYPE HTML>
<!--
	Phantom by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>PDS4</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="./resources/assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="./resources/assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="./resources/assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="./resources/assets/css/ie8.css" /><![endif]-->
	</head>
	<body>
		<%@ include file="../views/module/tap.jsp" %>

				<!-- Main -->
					<div id="main">
						<div class="inner">
							<header>
								<h1><a href="http://www.ksmart.or.kr/" target="_blank">한국스마트정보교육원</a><br />
								Team by <a href="https://github.com/yukukhwa/SpringMVC_PDS.git" target="_blank">SPAM</a>.</h1>
								<p>팀장 : 유국화 / 팀원 : 김재희, 배건혜, 나성수</p>
							</header>
							<section class="tiles">
								<article class="style1">
									<span class="image">
										<img src="./resources/images/pic01.jpg" alt="" />
									</span>
									<a>
										<h2>유국화</h2>
										<div class="content">
											<p>팀장/Article담당</p>
										</div>
									</a>
								</article>
								<article class="style2">
									<span class="image">
										<img src="./resources/images/pic02.jpg" alt="" />
									</span>
									<a href="${pageContext.request.contextPath}/addArticle">
										<h2>Article</h2>
										<div class="content">
											<p>article를 추가해보세요</p>
										</div>
									</a>
								</article>
								<article class="style3">
									<span class="image">
										<img src="./resources/images/pic03.jpg" alt="" />
									</span>
									<a>
										<h2>지정안됨</h2>
										<div class="content">
											<p>내용을 지정해주세요</p>
										</div>
									</a>
								</article>
								<article class="style4">
									<span class="image">
										<img src="./resources/images/pic04.jpg" alt="" />
									</span>
									<a>
										<h2>유국화</h2>
										<div class="content">
											<p>팀장/Resume담당</p>
										</div>
									</a>
								</article>
								<article class="style5">
									<span class="image">
										<img src="./resources/images/pic05.jpg" alt="" />
									</span>
									<a href="${pageContext.request.contextPath}/addResume">
										<h2>Resume</h2>
										<div class="content">
											<p>resume을 추가해보세요</p>
										</div>
									</a>
								</article>
								<article class="style6">
									<span class="image">
										<img src="./resources/images/pic06.jpg" alt="" />
									</span>
									<a>
										<h2>지정안됨</h2>
										<div class="content">
											<p>내용을 지정해주세요</p>
										</div>
									</a>
								</article>
								<article class="style1">
									<span class="image">
										<img src="./resources/images/pic01.jpg" alt="" />
									</span>
									<a>
										<h2>김재희</h2>
										<div class="content">
											<p>팀원/Notice담당</p>
										</div>
									</a>
								</article>
								<article class="style2">
									<span class="image">
										<img src="./resources/images/pic02.jpg" alt="" />
									</span>
									<a href="${pageContext.request.contextPath}/addNotice">
										<h2>Notice</h2>
										<div class="content">
											<p>notice를 추가해보세요</p>
										</div>
									</a>
								</article>
								<article class="style3">
									<span class="image">
										<img src="./resources/images/pic03.jpg" alt="" />
									</span>
									<a>
										<h2>지정안됨</h2>
										<div class="content">
											<p>내용을 지정해주세요</p>
										</div>
									</a>
								</article>
								<article class="style4">
									<span class="image">
										<img src="./resources/images/pic04.jpg" alt="" />
									</span>
									<a>
										<h2>배건혜</h2>
										<div class="content">
											<p>팀원/Board담당</p>
										</div>
									</a>
								</article>
								<article class="style5">
									<span class="image">
										<img src="./resources/images/pic05.jpg" alt="" />
									</span>
									<a href="${pageContext.request.contextPath}/addBoard">
										<h2>Board</h2>
										<div class="content">
											<p>board를 추가해보세요</p>
										</div>
									</a>
								</article>
								<article class="style6">
									<span class="image">
										<img src="./resources/images/pic06.jpg" alt="" />
									</span>
									<a>
										<h2>지정안됨</h2>
										<div class="content">
											<p>내용을 지정해주세요</p>
										</div>
									</a>
								</article>
								<article class="style1">
									<span class="image">
										<img src="./resources/images/pic01.jpg" alt="" />
									</span>
									<a>
										<h2>나성수</h2>
										<div class="content">
											<p>팀원/Gallery파트 담당</p>
										</div>
									</a>
								</article>
								<article class="style2">
									<span class="image">
										<img src="./resources/images/pic02.jpg" alt="" />
									</span>
									<a href="${pageContext.request.contextPath}/addGallery">
										<h2>Gallery</h2>
										<div class="content">
											<p>gallery를 추가해보세요</p>
										</div>
									</a>
								</article>
								<article class="style6">
									<span class="image">
										<img src="./resources/images/pic06.jpg" alt="" />
									</span>
									<a>
										<h2>지정안됨</h2>
										<div class="content">
											<p>내용을 지정해주세요</p>
										</div>
									</a>
								</article>
							</section>
						</div>
					</div>

		<%@ include file="../views/module/bottom.jsp" %>
	</body>
</html>