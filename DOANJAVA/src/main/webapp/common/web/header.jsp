<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="top-bar">
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<div class="tb-contact">
					<p>
						<i class="fas fa-envelope"></i>rvsmartphone@mail.com
					</p>
					<p>
						<i class="fas fa-phone-alt"></i>0332 093 438
					</p>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Top Bar Start -->

<!-- Brand Start -->
<div class="brand">
	<div class="container">
		<div class="row align-items-center">
			<div class="col-lg-3 col-md-4">
				<div class="b-logo">
					<a href="trang-chu"> <img
						src="<c:url value='/template/web/img/logo.jpg'/>" alt="Logo">
					</a>
				</div>
			</div>

			<div class="col-lg-3 col-md-4">
				<div class="b-search">
					<form action="<c:url value='/search'/>">
						<input type="text" name="keyword" id="keyword"
							placeholder="Tìm kiếm" value="${keyword}" required /> &nbsp;
						<button type="submit">
							<i class="fa fa-search"></i>
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Brand End -->

<!-- Nav Bar Start -->
<div class="nav-bar">
	<div class="container">
		<nav class="navbar navbar-expand-md bg-dark navbar-dark">
			<a href="#" class="navbar-brand">MENU</a>
			<button type="button" class="navbar-toggler" data-toggle="collapse"
				data-target="#navbarCollapse">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse justify-content-between"
				id="navbarCollapse">
				<div class="navbar-nav mr-auto">
					<a href="<c:url value ='/trang-chu'/>"
						class="nav-item nav-link active">Trang chủ</a> <a
						href="<c:url value ='/lien-he'/>" class="nav-item nav-link">Liên
						hệ</a> <a href="<c:url value ='/dang-nhap'/>"
						class="nav-item nav-link">Đăng Nhập</a>
				</div>
				<div class="social ml-auto">
					<a href=""><i class="fab fa-twitter"></i></a> <a
						href="https://www.facebook.com/lxn310700/"><i
						class="fab fa-facebook-f"></i></a> <a href=""><i
						class="fab fa-linkedin-in"></i></a> <a href=""><i
						class="fab fa-instagram"></i></a> <a href=""><i
						class="fab fa-youtube"></i></a>
				</div>
			</div>
		</nav>
	</div>
</div>
<!-- Nav Bar End -->
