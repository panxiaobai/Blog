<%@ page language="java" import="java.util.*,com.white.service.*,com.white.model.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
User user=(User)session.getAttribute("user");
Essay essay=EssayService.getEssayById(Integer.valueOf(request.getParameter("essayid")));
session.setAttribute("modifyessay", essay);

%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>编辑文章</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
	</head>
	<body class="single">

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
					<header id="header">
						<h1><a href="index.jsp">panxiaobai.cn</a></h1>
						<nav class="links">
							<ul>
								<li><a href="index.jsp">主页</a></li>
								<li><a href="#">文章</a></li>
								<li><a href="#">朋友</a></li>
								<!--
								<li><a href="#">Tempus</a></li>
								<li><a href="#">Adipiscing</a></li>
								-->
							</ul>
						</nav>
						<nav class="main">
							<ul>
								<li class="search">
									<a class="fa-search" href="#search">Search</a>
									<form id="search" method="get" action="#">
										<input type="text" name="query" placeholder="Search" />
									</form>
								</li>
								<li class="menu">
									<a class="fa-bars" href="#menu">Menu</a>
								</li>
							</ul>
						</nav>
					</header>

				<!-- Menu -->
					<section id="menu">

						<!-- Search -->
							<section>
								<form class="search" method="get" action="#">
									<input type="text" name="query" placeholder="Search" />
								</form>
							</section>

						<!-- Links -->
						<%if (user==null){ %>
						<!-- Actions -->
							<section>
								<ul class="actions vertical">
									<li><a href="signIn.jsp" class="button big fit">Log In</a></li>
								</ul>
							</section>
						<%} else{%>
							<section>
								<ul class="links">
									<li>
										<a href="myIndex.jsp">
											<h3>我的主页</h3>
											<p>My Index</p>
										</a>
									</li>
									<li>
										<a href="addEssay.jsp">
											<h3>写文章</h3>
											<p>New Essay</p>
										</a>
									</li>
									<li>
										<a href="#">
											<h3>个人信息</h3>
											<p>Personal</p>
										</a>
									</li>
									<li>
										<a href="#">
											<h3>朋友</h3>
											<p>Friends</p>
										</a>
									</li>
								</ul>
							</section>
						<%} %>
					</section>

				<!-- Main -->
					<div id="main">

						<article class="post">
						<section>
									<h3>Modify Essay</h3>
									<form method="post" action="modifyEssay.action">
										<div class="row uniform">
											<div class="6u 12u$(xsmall)">
												<input type="text" name="title" id="title" value="<%=essay.getTitle() %>" placeholder="Title"/>
											</div>
											<div class="6u$ 12u$(xsmall)">
												<input type="text" name="descrption" id="descrption" value="<%=essay.getDescript() %>" placeholder="Descrption"/>
											</div>
											<div class="12u$">
												<div class="select-wrapper">
													<select name="demo-category" id="demo-category">
														<option value="">- Category -</option>
														<option value="1">Manufacturing</option>
														<option value="1">Shipping</option>
														<option value="1">Administration</option>
														<option value="1">Human Resources</option>
													</select>
												</div>
											</div>
											
											<div class="4u 12u$(small)">
												<input type="radio" id="demo-priority-low" name="type" checked>
												<label for="demo-priority-low">Private</label>
											</div>
											<div class="4u 12u$(small)">
												<input type="radio" id="demo-priority-normal" name="type">
												<label for="demo-priority-normal">Public</label>
											</div>
											<!--
											<div class="6u 12u$(small)">
												<input type="checkbox" id="demo-copy" name="demo-copy">
												<label for="demo-copy">Email me a copy</label>
											</div>
											<div class="6u$ 12u$(small)">
												<input type="checkbox" id="demo-human" name="demo-human" checked>
												<label for="demo-human">Not a robot</label>
											</div>
											-->
											<div class="12u$">
												<textarea name="content" id="content" placeholder="Content" rows="20"><%=essay.getContent() %></textarea>
											</div>
											
											<div class="12u$">
												<ul class="actions">
													<li><input type="submit" value="Submit" /></li>
													<li><input type="reset" value="Reset" /></li>
												</ul>
											</div>
										</div>
									</form>
								</section>
					</article>

					</div>

				<!-- Footer -->
					<section id="footer">
						<ul class="icons">
							<li><a href="#" class="fa-twitter"><span class="label">Twitter</span></a></li>
							<li><a href="#" class="fa-facebook"><span class="label">Facebook</span></a></li>
							<li><a href="#" class="fa-instagram"><span class="label">Instagram</span></a></li>
							<li><a href="#" class="fa-rss"><span class="label">RSS</span></a></li>
							<li><a href="#" class="fa-envelope"><span class="label">Email</span></a></li>
						</ul>
						<p class="copyright">panxiaobai.cn</a>.</p>
					</section>

			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>

	</body>
</html>