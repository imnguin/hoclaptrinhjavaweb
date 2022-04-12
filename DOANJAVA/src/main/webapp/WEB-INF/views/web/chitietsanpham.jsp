<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<body>
	<div class="single-news">
		<div class="container">
			<div class="row">
				<div class="col-lg-14">
					<div class="sn-container">
						<div class="sn-content">
							<h1 class="sn-title">Thông tin chi tiết sản phẩm: ${model.tensp}</h1>
						</div>
						<div class="sn-img">
							<img
								src="${pageContext.request.contextPath}/template/web/img/${model.hinhanh}" />
						</div>
						<div class="sn-content"><h3>Chi Tiết:</h3>
						${model.mota}
						</div>
					</div>
				</div>
			</div>
		</div>
</body>