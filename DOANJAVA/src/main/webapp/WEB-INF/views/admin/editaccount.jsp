<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="accountURL" value="/quan-tri/tai-khoan/danh-sach"/>
<c:url var="editAccountURL" value="/quan-tri/tai-khoan/chinh-sua"/>
<c:url var="accountAPI" value="/api/account"/>
<html>
<head>
<title>Sửa tài khoản</title>
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

				<li><a href="<c:url value ='/quan-tri/tai-khoan/danh-sach'/>">Tài khoản</a></li>
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
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Tên đầy đủ</label>
								<div class="col-sm-9">
									<form:input path="fullname" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Tên đăng nhập</label>
								<div class="col-sm-9">
									<form:input path="username" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Mật khẩu</label>
								<div class="col-sm-9">
									<form:input path="password" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<form:hidden path="id" id="accountId"/>
						<div class="clearfix form-actions">
							<div class="col-md-offset-3 col-md-9">
											<c:if test="${not empty model.id}">
												<button class="btn btn-info" type="button" id="btnAddOrUpdateAccount">
													<i class="ace-icon fa fa-check bigger-110"></i>
													Lưu
												</button>
											</c:if>
											<c:if test="${empty model.id}">
												<button class="btn btn-info" type="button" id="btnAddOrUpdateAccount">
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
	$('#btnAddOrUpdateAccount').click(function (e) {
	    e.preventDefault();
	    var data = {};
	    var formData = $('#formSubmit').serializeArray();
	    $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
	    var id = $('#accountId').val();
	    if (id == "") {
	    	addAccount(data);
	    } else {
	    	updateAccount(data);
	    }
	});
	
	function addAccount(data) {
		$.ajax({
            url: '${accountAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${editAccountURL}?id="+result.id+"&message=insert_success";
            },
            error: function (error) {
            	window.location.href = "${accountURL}?&message=error_system";
            }
        });
	}
	
	function updateAccount(data) {
		$.ajax({
            url: '${accountAPI}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${editAccountURL}?id="+result.id+"&message=update_success";
            },
            error: function (error) {
            	window.location.href = "${editAccountURL}?id="+result.id+"&message=error_system";
            }
        });
	}
</script>
</body>
</html>