<%@ page language="java" import="java.util.*,com.white.service.*,com.white.model.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
User user=UserService.getUserById(1);
User u=(User)session.getAttribute("user");
Blog blog=user.getBlog();
List<Essay> essays=blog.getEssays();

%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>潘小白的主页</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
	</head>
	<body>

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
						<% if(u==null){ %>
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

				<!-- 文章列表 -->
					<div id="main">

						<%
						if(essays!=null&&!essays.isEmpty()){
						for(int i=0;i<essays.size();i++){
							Essay essay=essays.get(i);
						 %>
						<!-- Post -->
							<article class="post">
								<header>
									<div class="title">
										<!-- 标题 -->
										<h2><a href="essay.jsp?essayid=<%=essay.getId() %>"><%=essay.getTitle() %></a></h2>
										<!-- 描述 -->
										<p><%=essay.getDescript() %></p>
									</div>
									<div class="meta">
										<!-- 日期 -->
										<time class="published" datetime="2015-11-01"><%=essay.getDate() %></time>
										<!-- 作者 -->
										<a href="#" class="author"><span class="name"><%=user.getName() %></span><img src="images/avatar.jpg" alt="" /></a>
									</div>
								</header>
								<!-- 配图-->
								<a href="essay.jsp?essayid=<%=essay.getId() %>" class="image featured"><img src="images/pic01.jpg" alt="" /></a>
								<!-- 内容 -->
								<p><%=essay.getContent() %></p>
								<footer>
									<ul class="actions">
										<li><a href="essay.jsp?essayid=<%=essay.getId() %>" class="button big">Continue Reading</a></li>
									</ul>
									<ul class="stats">
										<!-- 类型 -->
										<li><a href="#"><%=essay.getType() %></a></li>
										<!-- 点赞数 -->
										<li><a href="#" class="icon fa-heart"><%=essay.getPraiseNum() %></a></li>
										<!-- 评论数 -->
										<li><a href="#" class="icon fa-comment">128</a></li>
									</ul>
								</footer>
							</article>
						<%
						}
						}
						 %>
						


						<!-- Pagination -->
							<ul class="actions pagination">
								<!-- 前一页 -->
								<li><a href="" class="disabled button big previous">Previous Page</a></li>
								<!-- 后一页 -->
								<li><a href="#" class="button big next">Next Page</a></li>
							</ul>

					</div>

				<!-- Sidebar -->
					<section id="sidebar">

						<!-- Intro -->
							<section id="intro">
								<a href="#" class="logo"><img src="images/logo.jpg" alt="" /></a>
								<header>
									<h2>潘小白</h2>
									<p>panxiaobai.cn</a></p>
								</header>
							</section>


						<!-- 推荐文章 -->
							<section>
								<div class="mini-posts">
									
									
									<!-- Mini Post -->
										<article class="mini-post">
											<header>
												<h3><a href="#">Vitae sed condimentum</a></h3>
												<time class="published" datetime="2015-10-20">October 20, 2015</time>
												<a href="#" class="author"><img src="images/avatar.jpg" alt="" /></a>
											</header>
											<a href="#" class="image"><img src="images/pic04.jpg" alt="" /></a>
										</article>

									

								</div>
							</section>


						<!-- Posts List -->
							<section>
								<ul class="posts">
									<li>
										<article>
											<header>
												<h3><a href="#">Lorem ipsum fermentum ut nisl vitae</a></h3>
												<time class="published" datetime="2015-10-20">October 20, 2015</time>
											</header>
											<a href="#" class="image"><img src="images/pic08.jpg" alt="" /></a>
										</article>
									</li>
									
								</ul>
							</section>

						<!-- About -->
							<section class="blurb">
								<h2>About</h2>
								<p>If you have any question.<br>Please contact panxiaobai@panxiaobai.cn</p>
								<ul class="actions">
									<li><a href="#" class="button">Learn More</a></li>
								</ul>
							</section>

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
