<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login Page</title>
</head>
<body>
    <div class="container" id="container">
        <div class="form-container sign-in-container">
            <form action="j_spring_security_check" id="formLogin" method="post">
            
                <h1 style="margin-bottom: 20px">Đăng nhập</h1>
                <c:if test="${param.incorrectAccount!=null}">
						<div class="alert alert-danger}">Tài khoản hoặc mật khẩu
							không đúng</div>
					</c:if>
					<c:if test="${param.accessDenied!=null}">
						<div class="alert alert-danger}">Không thể đăng nhập</div>
					</c:if>
                <input type="text" id="userName" name="j_username" placeholder="Tên đăng nhập" />
                <input type="password" id="password" name="j_password" placeholder="Mật khẩu" />
                <a href="<c:url value ='/lien-he'/>">Quên mật khẩu?</a>
                <button>Đăng Nhập</button>
                
            </form>
        </div>
        <div class="overlay-container">
            <div class="overlay">
                <div class="overlay-panel overlay-right">
                    <h1>Xin chào, Admin!</h1>
                    <p>Nhập thông tin tài khoản của bạn và bắt đầu quản trị website</p>
                </div>                
            </div>
        </div>
    </div>
</body>
</html>