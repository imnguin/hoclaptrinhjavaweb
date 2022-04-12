<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<body>
	<!-- Top News Start-->
	<div class="top-news">
		<div class="container">
			<div class="row">
				<div class="col-md-12 tn-left">
					<div class="row tn-slider">
						<c:forEach var="item" items="${model.listResult}">
							<div class="col-md-6">
								<div class="tn-img">
									<img
										src="${pageContext.request.contextPath}/template/web/img/${item.hinhanh}">
									<div class="tn-title">
										<c:url var="showDetailsURL"
											value="/san-pham/chi-tiet-san-pham">
											<c:param name="id" value="${item.id}" />
										</c:url>
										<a href='${showDetailsURL}'>${item.tensp}</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Top News End-->

	<!-- Category News Start-->
	<div class="cat-news">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<h2>Sản phẩm mới</h2>
					<div class="row cn-slider">
						<c:forEach var="item" items="${spmoi.listResult}">
							<div class="col-md-6">
								<div class="cn-img">
									<img
										src="${pageContext.request.contextPath}/template/web/img/${item.hinhanh}">

									<div class="cn-title">
										<c:url var="showDetailsURL"
											value="/san-pham/chi-tiet-san-pham">
											<c:param name="id" value="${item.id}" />
										</c:url>
										<a href='${showDetailsURL}'>${item.tensp}</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="col-md-6">
					<h2>Nổi Bật</h2>
					<div class="row cn-slider">
						<c:forEach var="item" items="${spnoibat.listResult}">
							<div class="col-md-6">
								<div class="cn-img">
									<img
										src="${pageContext.request.contextPath}/template/web/img/${item.hinhanh}">

									<div class="cn-title">
										<c:url var="showDetailsURL"
											value="/san-pham/chi-tiet-san-pham">
											<c:param name="id" value="${item.id}" />
										</c:url>
										<a href='${showDetailsURL}'>${item.tensp}</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Category News End-->
	<!-- Tab News Start-->
	<div class="tab-news">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<ul class="nav nav-pills nav-justified">
						<li class="nav-item"><a class="nav-link active"
							data-toggle="pill" href="#featured">Mi</a></li>
						<li class="nav-item"><a class="nav-link" data-toggle="pill"
							href="#popular">Redmi</a></li>
						<li class="nav-item"><a class="nav-link" data-toggle="pill"
							href="#latest">BlackShark</a></li>
					</ul>
					<div class="tab-content">
						<div id="featured" class="container tab-pane active">
							<c:forEach var="item" items="${model.listResult}">
								<c:if test="${item.categoryCode == 'MI' }">
									<div class="tn-news">
										<div class="tn-img">
											<img
												src="${pageContext.request.contextPath}/template/web/img/${item.hinhanh}">

										</div>
										<div class="tn-title">
											<c:url var="showDetailsURL"
												value="/san-pham/chi-tiet-san-pham">
												<c:param name="id" value="${item.id}" />
											</c:url>
											<a href='${showDetailsURL}'>${item.tensp}</a>
										</div>
									</div>
								</c:if>
							</c:forEach>
						</div>
						<div id="popular" class="container tab-pane fade">
							<c:forEach var="item" items="${model.listResult}">
								<c:if test="${item.categoryCode == 'REDMI' }">
									<div class="tn-news">
										<div class="tn-img">
											<img
												src="${pageContext.request.contextPath}/template/web/img/${item.hinhanh}">

										</div>
										<div class="tn-title">
											<c:url var="showDetailsURL"
												value="/san-pham/chi-tiet-san-pham">
												<c:param name="id" value="${item.id}" />
											</c:url>
											<a href='${showDetailsURL}'>${item.tensp}</a>
										</div>
									</div>
								</c:if>
							</c:forEach>
						</div>
						<div id="latest" class="container tab-pane fade">
							<c:forEach var="item" items="${model.listResult}">
								<c:if test="${item.categoryCode == 'BLACKSHARK' }">
									<div class="tn-news">
										<div class="tn-img">
											<img
												src="${pageContext.request.contextPath}/template/web/img/${item.hinhanh}">

										</div>
										<div class="tn-title">
											<c:url var="showDetailsURL"
												value="/san-pham/chi-tiet-san-pham">
												<c:param name="id" value="${item.id}" />
											</c:url>
											<a href='${showDetailsURL}'>${item.tensp}</a>
										</div>
									</div>
								</c:if>
							</c:forEach>
						</div>
					</div>
				</div>

				<div class="col-md-6">
					<ul class="nav nav-pills nav-justified">
						<li class="nav-item"><a class="nav-link active"
							data-toggle="pill" href="#m-viewed">Video</a></li>
					</ul>

					<div class="tab-content">
						<div id="m-viewed" class="container tab-pane active">
							<c:forEach var="item" items="${video.listResult}">
								<div>
									<div>
										<iframe width="480" height="270" src="${item.lienket}"
											title="YouTube video player" frameborder="0"
											allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
											allowfullscreen></iframe>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="main-news">
		<div class="container">
			<div class="row">

				<div class="col-lg-12">
					<div class="mn-list">
						<h2>Tin Tức</h2>
						<ul>
							<c:forEach var="item" items="${news.listResult }">

								<li><c:url var="newsURL"
										value="/new">
										<c:param name="id" value="${item.id}" />
									</c:url> <a href='${newsURL}'>${item.tieude}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>