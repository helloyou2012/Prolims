<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="layout/header.jsp"/>
</head>
<body class="animated">

<div id="cl-wrapper">
    <jsp:include page="layout/body_slidebar.jsp"></jsp:include>
	<div class="container-fluid" id="pcont">
	    <jsp:include page="layout/body_header.jsp"></jsp:include>
	    <div class="cl-mcont">
	        <div class="row">
				
				<div class="col-md-3 col-sm-6">
				  <div class="fd-tile detail clean tile-green">
				    <div class="content"><h1 class="text-left">170</h1><p>入库器械数</p></div>
				    <div class="icon"><i class="fa fa-download"></i></div>
				    <a class="details" href="#">Details <span><i class="fa fa-arrow-circle-right pull-right"></i></span></a>
				  </div>
				</div>
				
				<div class="col-md-3 col-sm-6">
				  <div class="fd-tile detail clean tile-red">
				    <div class="content"><h1 class="text-left">24</h1><p>出库器械数</p></div>
				    <div class="icon"><i class="fa fa-upload"></i></div>
				    <a class="details" href="#">Details <span><i class="fa fa-arrow-circle-right pull-right"></i></span></a>
				  </div>
				</div>
				
				<div class="col-md-3 col-sm-6">
				  <div class="fd-tile detail clean tile-prusia">
				    <div class="content"><h1 class="text-left">25</h1><p>用户注册数</p></div>
				    <div class="icon"><i class="fa fa-user"></i></div>
				    <a class="details" href="#">Details <span><i class="fa fa-arrow-circle-right pull-right"></i></span></a>
				  </div>
				</div>
				
				<div class="col-md-3 col-sm-6">
				  <div class="fd-tile detail clean tile-purple">
				    <div class="content"><h1 class="text-left">72</h1><p>日志记录数</p></div>
				    <div class="icon"><i class="fa fa-list-ul"></i></div>
				    <a class="details" href="#">Details <span><i class="fa fa-arrow-circle-right pull-right"></i></span></a>
				  </div>
				</div>
            </div><!-- row end -->
        </div><!-- cl-mcont end -->
    </div><!-- container-fluid end -->
</div><!-- cl-wrapper end -->

<jsp:include page="layout/body_rightchat.jsp"></jsp:include>
<jsp:include page="layout/footer.jsp"></jsp:include>
</html>


