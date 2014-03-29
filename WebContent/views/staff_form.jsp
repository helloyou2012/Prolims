<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="layout/header.jsp"/>
    <link rel="stylesheet" type="text/css" href="js/jquery.icheck/skins/flat/green.css">
    <link rel="stylesheet" type="text/css" href="js/bootstrap.multiselect/css/bootstrap-multiselect.css"/>
    <link rel="stylesheet" type="text/css" href="js/jquery.multiselect/css/multi-select.css" />
</head>
<body class="animated">

<div id="cl-wrapper">
    <jsp:include page="layout/body_slidebar.jsp"></jsp:include>
    <div class="container-fluid" id="pcont">
        <jsp:include page="layout/body_header.jsp"></jsp:include>
        <div class="cl-mcont">
            <div class="page-head">
              <ol class="breadcrumb">
                <li><a href="dashboard">Home</a></li>
                <li><a href="#">用户管理</a></li>
                <c:choose>
                    <c:when test="${staff['new']}">
                        <li class="active">用户添加</li>
                    </c:when>
                    <c:otherwise>
                        <li class="active">用户更新</li>
                    </c:otherwise>
                </c:choose>
              </ol>
            </div>
            <div class="row">
                <div class="col-sm-12 col-md-12">
                    <div class="block-flat">
                      <div class="header">
                        <c:choose>
                            <c:when test="${staff['new']}">
                                <h3>添加用户</h3>
                            </c:when>
                            <c:otherwise>
                                <h3>更新用户</h3>
                            </c:otherwise>
                        </c:choose>
                      </div>
                      <div class="content">
                      <c:if test="${not empty edit_fail}">
                      <div class="alert alert-warning">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <i class="fa fa-warning sign"></i><strong>失败!</strong> ${edit_fail}
                      </div>
                      </c:if>
                      
                      <form class="form-horizontal group-border-dashed" action="staff_new" method="post" parsley-validate novalidate>
                      <input value="${staff.id}" type="hidden" name="id"></input>
                      <input value="${staff.avatar}" type="hidden" name="avatar"></input>
                      <!-- username -->
                      <div class="form-group">
                        <label class="col-sm-3 control-label">用户名</label>
                        <div class="col-sm-6">
                          <input value="${staff.username}" type="text" name="username" parsley-trigger="change" class="form-control" required placeholder="请输入用户名 (仅支持英文字母、数字和下划线)" />
                        </div>
                      </div>
                      <!-- email -->
                      <div class="form-group">
                        <label class="col-sm-3 control-label">邮箱</label>
                        <div class="col-sm-6">
                          <input value="${staff.email}" type="email" name="email" parsley-trigger="change" class="form-control" required placeholder="请输入常用邮箱" />
                        </div>
                      </div>
                      <!-- password -->
                      <div class="form-group">
                        <label class="col-sm-3 control-label">密码</label>
                        <div class="col-sm-6">
                          <input value="" id="password1" type="password" name="password" parsley-rangelength="[6,20]" class="form-control" required placeholder="请输入密码 (长度6-20字符)" />
                        </div>
                      </div>
                      <!-- repeat password -->
                      <div class="form-group">
                        <label class="col-sm-3 control-label">重复密码</label>
                        <div class="col-sm-6">
                          <input value="" type="password" parsley-equalto="#password1" parsley-rangelength="[6,20]" class="form-control" required placeholder="请再次输入密码 (长度6-20字符)" />
                        </div>
                      </div>
                      <!-- department -->
                      <div class="form-group">
                        <label class="col-sm-3 control-label">所属部门</label>
                        <div class="col-sm-6">
                          <select id="department.id" name="department.id">
                              <c:forEach items="${departments}" var="dept" varStatus = "status">
                                <option value="${dept.id}" ${dept.id==cur_department ? 'selected' : ''}>${dept.name}</option>
                              </c:forEach>
                          </select>
                        </div>
                      </div>
                      <!-- sex -->
                      <div class="form-group">
                        <label class="col-sm-3 control-label">性别</label>
                        <div class="col-sm-6">
                          <label class="radio-inline"> <input class="icheck" type="radio" value="男" ${staff.sex=='男' ? 'checked' : ''} name="sex"  data-required="true"> 男</label> 
                          <label class="radio-inline"> <input class="icheck" type="radio" value="女" ${staff.sex=='女' ? 'checked' : ''} name="sex" data-required="true"> 女</label>
                        </div>
                      </div>
                      <!-- level -->
                      <div class="form-group">
                        <label class="col-sm-3 control-label">等级</label>
                        <div class="col-sm-6">
                          <c:forEach items="${levels}" var="level" varStatus = "status">
                            <label class="radio-inline"> <input class="icheck" type="radio" value="${level.id}" ${level.id==cur_level ? 'checked' : ''} name="level.id"> ${level.name}</label>
                          </c:forEach>
                        </div>
                      </div>
                      <!-- buttons -->
                      <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <c:choose>
                                <c:when test="${staff['new']}">
                                    <button type="submit" class="btn btn-primary">添加</button>
                                </c:when>
                                <c:otherwise>
                                    <button type="submit" class="btn btn-primary">更新</button>
                                </c:otherwise>
                            </c:choose>
                        </div>
                      </div>
                      </form>
                      </div>
                    </div>
                  </div>
			</div><!-- row end -->
        </div><!-- cl-mcont end -->
    </div><!-- container-fluid end -->
</div><!-- cl-wrapper end -->

<jsp:include page="layout/body_rightchat.jsp"></jsp:include>
<jsp:include page="layout/footer.jsp"></jsp:include>

<script type="text/javascript" src="js/jquery.parsley/parsley.js"></script>
<script type="text/javascript" src="js/jquery.icheck/icheck.min.js"></script>
<script type="text/javascript" src="js/bootstrap.multiselect/js/bootstrap-multiselect.js"></script>
<script type="text/javascript" src="js/jquery.multiselect/js/jquery.multi-select.js"></script>

<script type="text/javascript">

    $(document).ready(function(){
    	//Input & Multi Select
    	//$('#department').multiselect();
        //Input & Radio Buttons
        $('.icheck').iCheck({
          checkboxClass: 'icheckbox_flat-green',
          radioClass: 'iradio_flat-green'
        });
    });
</script>

</html>