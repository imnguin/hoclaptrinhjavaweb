<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<body>
	<div class="top-news">
		<div class="main-news">
			<div class="container">
				<div class="row">
					<div class="col-lg-9">
						<div class="row">
							<c:if test="${empty model.listResult}">
								<h1>Không tìm thấy sản phẩm</h1>
							</c:if>
							<c:if test="${not empty model.listResult}">
								<c:forEach items="${model.listResult}" var="item">
								<div class="col-md-4">
									<div class="mn-img">
										<img
											src="${pageContext.request.contextPath}/template/web/img/${item.hinhanh}">

										<div class="mn-title">
											<c:url var="showDetailsURL"
												value="/san-pham/chi-tiet-san-pham">
												<c:param name="id" value="${item.id}" />
											</c:url>
											<a href='${showDetailsURL}'>${item.tensp}</a>
										</div>
									</div>
								</div>
							</c:forEach>
							</c:if>
						</div>
					</div>

					<div class="col-lg-3">
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
	</div>

</body>