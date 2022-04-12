<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="sidebar" class="sidebar                  responsive                    ace-save-state">
    <ul class="nav nav-list">
        <li >
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-list"></i>
                <span class="menu-text"></span>
                Quản lý
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
            	<li>
                    <a href="<c:url value ='/quan-tri/danh-muc/danh-sach'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        DS Danh Mục
                    </a>
                    <b class="arrow"></b>
                </li>
                <li>
                    <a href="<c:url value ='/quan-tri/san-pham/danh-sach'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        DS Sản Phẩm
                    </a>
                    <b class="arrow"></b>
                </li>
                
                <li>
                    <a href="<c:url value ='/quan-tri/video/danh-sach'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        DS Video
                    </a>
                    <b class="arrow"></b>
                </li>
                <li>
                    <a href="<c:url value ='/quan-tri/bai-viet/danh-sach'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        DS Bài Viết
                    </a>
                    <b class="arrow"></b>
                </li>
                <li>
                    <a href="<c:url value ='/quan-tri/tai-khoan/danh-sach'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        DS Tài Khoản
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul>
    <div class="sidebar-toggle sidebar-collapse">
        <i class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>
</div>