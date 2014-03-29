<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="medm" value="/MedicalManager" />

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.cookie/jquery.cookie.js"></script>
<script type="text/javascript" src="js/jquery.pushmenu/js/jPushMenu.js"></script>
<script type="text/javascript" src="js/jquery.nanoscroller/jquery.nanoscroller.js"></script>
<script type="text/javascript" src="js/jquery.sparkline/jquery.sparkline.min.js"></script>
<script type="text/javascript" src="js/jquery.ui/jquery-ui.js"></script>
<script type="text/javascript" src="js/jquery.gritter/js/jquery.gritter.js"></script>
<script type="text/javascript" src="js/behaviour/core.js"></script>
<!-- Bootstrap core JavaScript -->
<!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="js/bootstrap/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap.bootbox/bootbox.min.js"></script>

<style type="text/css">
#color-switcher {
	position: fixed;
	background: #272930;
	padding: 10px;
	top: 50%;
	right: 0;
	margin-right: -109px;
}

#color-switcher .toggle {
	cursor: pointer;
	font-size: 15px;
	color: #FFF;
	display: block;
	position: absolute;
	padding: 4px 10px;
	background: #272930;
	width: 25px;
	height: 30px;
	left: -24px;
	top: 22px;
}

#color-switcher p {
	color: rgba(255, 255, 255, 0.6);
	font-size: 12px;
	margin-bottom: 3px;
}

#color-switcher .palette {
	padding: 1px;
}

#color-switcher .color {
	width: 15px;
	height: 15px;
	display: inline-block;
	cursor: pointer;
}

#color-switcher .color.purple {
	background: #7761A7;
}

#color-switcher .color.green {
	background: #19B698;
}

#color-switcher .color.red {
	background: #EA6153;
}

#color-switcher .color.blue {
	background: #54ADE9;
}

#color-switcher .color.orange {
	background: #FB7849;
}

#color-switcher .color.prusia {
	background: #476077;
}

#color-switcher .color.yellow {
	background: #fec35d;
}

#color-switcher .color.pink {
	background: #ea6c9c;
}

#color-switcher .color.brown {
	background: #9d6835;
}

#color-switcher .color.gray {
	background: #afb5b8;
}
</style>
<div id="color-switcher">
	<p>Select Color</p>
	<div class="palette">
		<div class="color purple" data-color="purple"></div>
		<div class="color green" data-color="green"></div>
		<div class="color red" data-color="red"></div>
		<div class="color blue" data-color="blue"></div>
		<div class="color orange" data-color="orange"></div>
	</div>
	<div class="palette">
		<div class="color prusia" data-color="prusia"></div>
		<div class="color yellow" data-color="yellow"></div>
		<div class="color pink" data-color="pink"></div>
		<div class="color brown" data-color="brown"></div>
		<div class="color gray" data-color="gray"></div>
	</div>
	<div class="toggle">
		<i class="fa fa-angle-left"></i>
	</div>
</div>

<script type="text/javascript">
	var link = $('link[href="css/style.css"]');

	if ($.cookie("css")) {
		link.attr("href", 'css/skin-' + $.cookie("css") + '.css');
	}

	$(function() {
		$("#color-switcher .toggle").click(function() {
			var s = $(this).parent();
			if (s.hasClass("open")) {
				s.animate({
					'margin-right' : '-109px'
				}, 400).toggleClass("open");
			} else {
				s.animate({
					'margin-right' : '0'
				}, 400).toggleClass("open");
			}
		});

		$("#color-switcher .color").click(function() {
			var color = $(this).data("color");
			$("body").fadeOut(function() {
				//link.attr('href','css/skin-' + color + '.css');
				$.cookie("css", color, {
					expires : 365,
					path : '/'
				});
				window.location.href = "";
				$(this).fadeIn("slow");
			});
		});
	});
</script>

<script type="text/javascript" src="js/jquery.flot/jquery.flot.js"></script>
<script type="text/javascript" src="js/jquery.flot/jquery.flot.pie.js"></script>
<script type="text/javascript" src="js/jquery.flot/jquery.flot.resize.js"></script>
<script type="text/javascript" src="js/jquery.flot/jquery.flot.labels.js"></script>