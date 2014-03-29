<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
if(request.getSession() != null && request.getSession().getAttribute("userSessionInfo") != null)
	response.sendRedirect(path+"/dashboard");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="layout/header.jsp"/>
</head>

<body class="texture">

<div id="cl-wrapper" class="login-container">

	<div class="middle-login">
		<div class="block-flat">
			<div class="header">							
				<h3 class="text-center"><img class="logo-img" src="images/logo.png" alt="logo"/></h3>
			</div>
			<div>
				<form action="login" method="post" class="form-horizontal" id="login" style="margin-bottom: 0px !important;">
					<div class="content">
					    <span id="login_error" style="color:#9DBB00;text-align:center;">${message}</span>
						<div class="form-group">
							<div class="col-sm-12">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user"></i></span>
									<input class="form-control" name="username" id="username" type="text" placeholder="邮箱或用户名" autofocus required>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-12">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock"></i></span>
									<input class="form-control" name="password" id="password" type="password" placeholder="密码" required>
								</div>
							</div>
						</div>
					</div>
					<div class="foot">
						<button id="login_register" class="btn btn-default" data-dismiss="modal" type="button">注册</button>
						<button id="login_submit" class="btn btn-primary" data-dismiss="modal" type="submit">登录系统</button>
					</div>
				</form>
			</div>
		</div>
		<div class="text-center out-links"><a href="#">&copy; 2014 Your Company</a></div>
	</div>
	
</div>

<script src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){
  $("#cl-wrapper").css({opacity:1,'margin-left':0});
});
$(document).ready(function(){
    $('#login_submit').on('click',function(){
        if($('#username').val() == ""){
            $('#login_error').text("请输入用户名！");
            return false;
        }
        if($('#password').val() == ""){
            $('#login_error').text("请输入密码！");
            return false;
        }
        return true;
	});
});
</script>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="js/bootstrap/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.flot/jquery.flot.js"></script>
<script type="text/javascript" src="js/jquery.flot/jquery.flot.pie.js"></script>
<script type="text/javascript" src="js/jquery.flot/jquery.flot.resize.js"></script>
<script type="text/javascript" src="js/jquery.flot/jquery.flot.labels.js"></script>
</body>
</html>

