<%@ page language="java" import="java.util.*,com.white.service.*,com.white.model.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
User user=(User)session.getAttribute("user");
Essay essay=EssayService.getEssayById(Integer.valueOf(request.getParameter("essayid")));

%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>文章</title>
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
						<% if(user==null){ %>
						<!-- Actions -->
							<section>
								<ul class="actions vertical">
									<li><a href="signIn.jsp" class="button big fit">Log In</a></li>
								</ul>
							</section>
						<%}else{ %>
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

						<!-- Post -->
							<article class="post">
								<header>
									<div class="title">
										<h2><a href="#"><%=essay.getTitle() %></a></h2>
										<p><%=essay.getDescript() %></p>
									</div>
									<div class="meta">
										<time class="published" datetime="2015-11-01"><%=essay.getDate() %></time>
										<a href="#" class="author"><span class="name"><%=essay.getBlog().getUser().getName() %></span><img src="images/avatar.jpg" alt="" /></a>
									</div>
								</header>
								<span class="image featured"><img src="images/pic01.jpg" alt="" /></span>
								<p><%=essay.getContent() %></p>
								<p></p>
								<footer>
									<ul class="stats">
										<li><a href="#"><%=essay.getType() %></a></li>
										<li><a href="#" class="icon fa-heart"><%=essay.getPraiseNum() %></a></li>
										<li><a href="#" class="icon fa-comment">128</a></li>
										<% if(user==essay.getBlog().getUser()){ %>
										<!-- 删除 -->
										<li><a href="deleteEssay.action?essayId=<%=essay.getId() %>">Delete</a></li>
										<!-- 编辑 -->
										<li><a href="modifyEssay.jsp?essayid=<%=essay.getId() %>">Edit</a></li>
										<%} %>
									</ul>
								</footer>
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