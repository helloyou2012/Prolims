<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="cl-sidebar">
    <div class="cl-toggle">
        <i class="fa fa-bars"></i>
    </div>
    <div class="cl-navblock">
        <div class="menu-space">
            <div class="content">
                <!-- logo -->
                <div class="sidebar-logo">
                    <div class="logo">
                        <a href="dashboard"></a>
                    </div>
                </div>
                <!-- user -->
                <div class="side-user">
                    <div class="avatar">
                        <img src="uploads/${empty userSessionInfo.avatar ? 'icon.png' : userSessionInfo.avatar}" width="50" height="50" alt="Avatar" />
                    </div>
                    <div class="info">
                        <p><span><i class="fa fa-male"></i></span>    ${userSessionInfo.username}</p>
                        <p>${userSessionInfo.department.name}</p>
                    </div>
                </div>
                <!-- navigation -->
                <ul class="cl-vnavigation">
                    <li class="${dashboard}"><a href="dashboard"><i
                        class="fa fa-home"></i><span>首页面板</span></a></li>
                    <c:if test="${userSessionInfo.level.id>1}">
                    
                    <li>
                        <a href="#"><i class="fa fa-user"></i><span>系统管理</span></a>
                         <ul class="sub-menu">
                            <li class="${staff_list}"><a href="staff_list">用户列表</a></li>
                            <li class="${staff_new}"><a href="staff_new">部门管理</a></li>
                            <li class="${staff_new}"><a href="staff_new"> 权限管理</a></li>
                        </ul>
                    </li>
                    
                    <li>
                        <a href="#"><i class="fa fa-user"></i><span>用户管理</span></a>
                        <ul class="sub-menu">
                            <li class="${staff_list}"><a href="staff_list">用户列表</a></li>
                            <li class="${staff_new}"><a href="staff_new">用户添加</a></li>
                        </ul>
                    </li>
                    </c:if>
                    <c:if test="${userSessionInfo.level.id>2}">
                    <li>
                        <a href="#"><i class="fa fa-group"></i><span>部门管理</span></a>
                        <ul class="sub-menu">
                            <li class="${dept_list}"><a href="dept_list">部门列表</a></li>
                            <li class="${dept_edit}"><a href="dept_edit">部门添加</a></li>
                        </ul>
                    </li>
                    </c:if>
                    <li>
                        <a href="#"><i class="fa fa-download"></i><span>入库管理</span></a>
                        <ul class="sub-menu">
                            <li class="${goods_list}"><a href="goods_list">入库列表</a></li>
                            <li class="${goods_edit}"><a href="goods_edit">入库添加</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-upload"></i><span>出库管理</span></a>
                        <ul class="sub-menu">
                            <li class="${outstore_list}"><a href="outstore_list">出库列表</a></li>
                            <li class="${outstore_edit}"><a href="outstore_edit">出库添加</a></li>
                        </ul>
                    </li>
                    <c:if test="${userSessionInfo.level.id>2}">
                    <li class="${syslog_list}"><a href="syslog_list"><i class="fa fa-list-ul"></i><span>日志管理</span></a></li>
                    </c:if>
                    <li class="${user_profile}"><a href="user_profile"><i class="fa fa-cog"></i><span>个人设置</span></a></li>
                </ul>
            </div><!-- content end -->
        </div><!-- menu-space end -->
        
        <div class="text-right collapse-button" style="padding: 7px 9px;">
            <button id="sidebar-collapse" class="btn btn-default" style="">
            <i style="color: #fff;" class="fa fa-angle-left"></i>
            </button>
        </div>
    </div>
</div>