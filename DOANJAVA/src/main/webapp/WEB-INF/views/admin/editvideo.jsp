<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="videoURL" value="/quan-tri/video/danh-sach"/>
<c:url var="editVideoURL" value="/quan-tri/video/chinh-sua"/>
<c:url var="videoAPI" value="/api/video"/>
<html>
<head>
<title>Sửa danh mục</title>
</head>
<body>
<div class="main-content">
	<div class="main-content-inner">
		<div class="breadcrumbs" id="breadcrumbs">
			<script type="text/javascript">
				try {
					ace.settings.check('breadcrumbs', 'fixed')
				} catch (e) {
				}
			</script>

			<ul class="breadcrumb">
				<li><i class="ace-icon fa fa-home home-icon"></i> <a href="<c:url value ='/quan-tri/trang-chu'/>">Trang chủ</a>
				</li>

				<li><a href="<c:url value ='/quan-tri/video/danh-sach'/>">Video</a></li>
				<li class="active">Thêm và chỉnh sửa</li>
			</ul>
			<!-- /.breadcrumb -->
		</div>
		<div class="page-content">
			<div class="row">
				<div class="col-xs-12">
					<c:if test="${not empty message}">
						<div class="alert alert-${alert}">
  							${message}
						</div>
					</c:if>
					<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">
						
						<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Liên kết video</label>
								<div class="col-sm-9">
									<form:input path="lienket" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<form:hidden path="id" id="videoId"/>
						<div class="clearfix form-actions">
							<div class="col-md-offset-3 col-md-9">
											<c:if test="${not empty model.id}">
												<button class="btn btn-info" type="button" id="btnAddOrUpdateVideo">
													<i class="ace-icon fa fa-check bigger-110"></i>
													Lưu
												</button>
											</c:if>
											<c:if test="${empty model.id}">
												<button class="btn btn-info" type="button" id="btnAddOrUpdateVideo">
													<i class="ace-icon fa fa-check bigger-110"></i>
													Thêm
												</button>
											</c:if>

											&nbsp; &nbsp; &nbsp;
											<button class="btn" type="reset">
												<i class="ace-icon fa fa-undo bigger-110"></i>
												Hủy
											</button>
							</div>		
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>	

<script>
	$('#btnAddOrUpdateVideo').click(function (e) {
	    e.preventDefault();
	    var data = {};
	    var formData = $('#formSubmit').serializeArray();
	    $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
	    var id = $('#videoId').val();
	    if (id == "") {
	    	addVideo(data);
	    } else {
	    	updateVideo(data);
	    }
	});
	
	function addVideo(data) {
		$.ajax({
            url: '${videoAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${editVideoURL}?id="+result.id+"&message=insert_success";
            },
            error: function (error) {
            	window.location.href = "${VideoURL}?&message=error_system";
            }
        });
	}
	
	function updateVideo(data) {
		$.ajax({
            url: '${videoAPI}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${editVideoURL}?id="+result.id+"&message=update_success";
            },
            error: function (error) {
            	window.location.href = "${editVideoURL}?id="+result.id+"&message=error_system";
            }
        });
	}
</script>
</body>
</html>