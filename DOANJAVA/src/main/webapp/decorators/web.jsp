
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="Bootstrap News Template - Free HTML Templates"
	name="keywords">
<meta content="Bootstrap News Template - Free HTML Templates"
	name="description">

<!-- Favicon -->
<link href="<c:url value='/template/web/img/favicon.ico'/>" rel="icon">
<!-- Google Fonts -->
<link
	href="<c:url value='https://fonts.googleapis.com/css?family=Montserrat:400,600&display=swap'/>"
	rel="stylesheet">
<!-- CSS Libraries -->
<link
	href="<c:url value='https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css'/>"
	rel="stylesheet">
<link
	href="<c:url value='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css'/>"
	rel="stylesheet">
<link href="<c:url value='/template/web/lib/slick/slick.css'/>"
	rel="stylesheet">
<link href="<c:url value='/template/web/lib/slick/slick-theme.css'/>"
	rel="stylesheet">

<!-- Template Stylesheet -->
<link href="<c:url value='/template/web/css/style.css'/>"
	rel="stylesheet">
<body>
	<%@include file="/common/web/header.jsp"%>
	<dec:body />
	<%@include file="/common/web/footer.jsp"%>
	<!-- Footer Bottom End -->

	<!-- Back to Top -->
	<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>

	<script src="<c:url value='/template/web/lib/easing/easing.min.js'/>"></script>
	<script src="<c:url value='/template/web/lib/slick/slick.min.js'/>"></script>

	<!-- Template Javascript -->
	<script src="<c:url value='/template/web/js/main.js'/>"></script>

	<script src="<c:url value='/template/web/js/jquery.min.js'/>"></script>
	<script src="<c:url value='/template/web/js/popper.min.js'/>"></script>
	<script src="<c:url value='/template/web/js/bootstrap.bundle.min.js'/>"></script>
	<script src="<c:url value='/template/web/js/jquery-3.0.0.min.js'/>"></script>
	<script src="<c:url value='/template/web/js/plugin.js'/>"></script>
	<script type="text/javascript">
		function clearSearch() {
			window.location = "[[@{/}]]";
		}
	</script>
</body>
</html>