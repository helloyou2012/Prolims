<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="layout/header.jsp"/>
    <link rel="stylesheet" type="text/css" href="js/jasny.bootstrap/extend/css/jasny-bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="js/jquery.easypiechart/jquery.easy-pie-chart.css" />
	<link rel="stylesheet" type="text/css" href="js/jquery.niftymodals/css/component.css" />
	<link rel="stylesheet" type="text/css" href="js/jquery.crop/css/jquery.Jcrop.css" />
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
                <li class="active">个人设置</li>
              </ol>
            </div>
            <div class="row">
					<div class="col-sm-12">
						<div class="tab-container">
							<ul class="nav nav-tabs">
								<li class="active"><a data-toggle="tab" href="#home">基本信息</a></li>
								<li><a data-toggle="tab" href="#settings">修改信息</a></li>
							</ul>
							<div class="tab-content">
								<div id="home" class="tab-pane active cont">
									<table class="no-border no-strip information">
										<tbody class="no-border-x no-border-y">
											<tr>
												<td style="width: 20%;" class="category"><strong>CONTACT</strong></td>
												<td>
													<table class="no-border no-strip skills">
														<tbody class="no-border-x no-border-y">
															<tr>
																<td style="width: 20%;"><b>Website</b></td>
																<td>www.website.com</td>
															</tr>
															<tr>
																<td style="width: 20%;"><b>E-mail</b></td>
																<td>johnny@example.com</td>
															</tr>
															<tr>
																<td style="width: 20%;"><b>Mobile</b></td>
																<td>(999) 999-9999</td>
															</tr>
															<tr>
																<td style="width: 20%;"><b>Location</b></td>
																<td>Montreal, Canada</td>
															</tr>
														</tbody>
													</table>
												</td>
											</tr>
											<tr>
												<td class="category"><strong>ABOUT ME</strong></td>
												<td><p>I am a web developer and desginer based in
														Medellín - Colombia, I like read books, good music and
														nature.</p></td>
											</tr>
											<tr>
												<td class="category"><strong>SOCIAL</strong></td>
												<td>
													<button class="btn btn-default btn-flat btn-facebook bg"
														type="button">
														<i class="fa fa-facebook"></i> <span>Facebook</span>
													</button>
													<button class="btn btn-default btn-flat btn-twitter bg"
														type="button">
														<i class="fa fa-twitter"></i> <span>Twitter</span>
													</button>
													<button class="btn btn-default btn-flat btn-google-plus bg"
														type="button">
														<i class="fa fa-google-plus"></i> <span>Google+</span>
													</button>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
								<div id="settings" class="tab-pane">
									<form class="form-horizontal">
										<div class="form-group">
											<label class="col-sm-3 control-label" for="nick">Avatar</label>
											<div class="col-sm-9">
												<div class="avatar-upload">
													<img src="images/av.jpg" width="140" height="140"
														class="profile-avatar img-thumbnail" />
                                                    <input id="fileupload" type="file" name="files[]">
													<div id="progress" class="overlay"></div>
												</div>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-3 control-label" for="nick">Nick</label>
											<div class="col-sm-9">
												<input type="email" placeholder="Your Nickname" id="nick"
													class="form-control">
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-3 control-label" for="name">Name</label>
											<div class="col-sm-9">
												<input type="email" placeholder="Your Name" id="name"
													class="form-control">
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-3 control-label" for="inputEmail3">Email</label>
											<div class="col-sm-9">
												<input type="email" placeholder="Email" id="inputEmail3"
													class="form-control">
											</div>
										</div>
										<div class="form-group spacer2">
											<div class="col-sm-3"></div>
											<label class="col-sm-9" for="inputPassword3">Change
												Password</label>

										</div>
										<div class="form-group">
											<label class="col-sm-3 control-label" for="inputPassword3">Password</label>
											<div class="col-sm-9">
												<input type="password" placeholder="Password"
													id="inputPassword3" class="form-control">
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-3 control-label" for="inputPassword4">Repeat
												Password</label>
											<div class="col-sm-9">
												<input type="password" placeholder="Password"
													id="inputPassword4" class="form-control">
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-offset-3 col-sm-9">
												<button class="btn btn-primary" type="submit">Update</button>
												<button class="btn btn-default">Reset</button>
											</div>
										</div>
									</form>
									<div id="crop-image"
										class="md-modal colored-header md-effect-1">
										<div class="md-content">
											<div class="modal-header">
												<h3>裁剪图片</h3>
												<button data-dismiss="modal"
													class="close md-close" type="button">×</button>
											</div>
											<div class="modal-body">
												<div class="text-center crop-image"></div>
											</div>
											<div class="modal-footer">
												<button data-dismiss="modal"
													class="btn btn-default btn-flat md-close" type="button">取消</button>
												<button id="save-image" class="btn btn-primary btn-flat"
													type="button">保存</button>
											</div>
										</div>
									</div>
									<div class="md-overlay"></div>
								</div>
							</div>
						</div>
					</div>
				</div><!-- row end -->
        </div><!-- cl-mcont end -->
    </div><!-- container-fluid end -->
</div><!-- cl-wrapper end -->

<jsp:include page="layout/body_rightchat.jsp"></jsp:include>
<jsp:include page="layout/footer.jsp"></jsp:include>

<script type="text/javascript" src="js/jasny.bootstrap/extend/js/jasny-bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.sparkline/jquery.sparkline.min.js"></script>
<script type="text/javascript" src="js/jquery.easypiechart/jquery.easy-pie-chart.js"></script>
<script type="text/javascript" src="js/jquery.niftymodals/js/jquery.modalEffects.js"></script>   
<script type="text/javascript" src="js/jquery.crop/js/jquery.Jcrop.js"></script>
<!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
<script src="js/jquery.upload/js/jquery.iframe-transport.js"></script>
<!-- The basic File Upload plugin -->
<script src="js/jquery.upload/js/jquery.fileupload.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	//Profile Image Upload
	'use strict';
	// Change this to the location of your server-side upload handler:
	var url = 'avatar_upload';
	var jcrop;
	var timg;

	$('#fileupload').fileupload({
		url : url,
		dataType : 'json',
		done : function(e, data) {
			$.each(data.result, function(index, file) {
                console.log(file);
				timg = file.fileName;
				$(".crop-image").html('<img src="temp/' + file.fileName + '" />');
				$('#progress').fadeOut();
				//Crop Image
				$(".crop-image img").Jcrop({aspectRatio : 1},function() {
                    jcrop = this;
				});
			});

			$("#crop-image").niftyModal({
				afterClose:function(){$(".crop-image").html('');}
            });
		},
		progressall : function(e, data) {
			var progress = parseInt(data.loaded / data.total * 100, 10);
			$('#progress').fadeIn();
			$('#progress').css('width', progress + '%');
		}
	});
	$("#save-image").click(function() {
		var c = jcrop.tellSelect();
        var s = jcrop.getBounds();
		if (c.w != 0) {
			$(".profile-avatar").attr("src",'crop_image?src='
							+ timg + '&x=' + c.x + '&y='+ c.y + '&w=' + c.w + '&h=' + c.h + '&sw=' + s[0] + '&sh=' + s[1]);
			$("#crop-image").niftyModal('hide');
			$(".crop-image").html('');
		} else {
			alert("请选择裁剪区域，然后单击保存.");
		}
	});

});
</script>
</html>