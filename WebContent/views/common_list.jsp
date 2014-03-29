<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="layout/header.jsp"/>
    <link rel="stylesheet" type="text/css" href="js/jquery.datatables/bootstrap-adapter/css/datatables.css" />
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
			    <li><a href="#">${main_nav}</a></li>
			    <li class="active">${sub_nav}</li>
			  </ol>
			</div>
	        <div class="row">
				<div class="col-md-12">
                    <div class="block-flat">
                        <div class="header">                            
                            <h3>${sub_nav}</h3>
                        </div>
                        <div class="content">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="datatable" >
                                    <thead>
                                        <tr>
                                            <c:forEach var="item" items="${columns_value}">
                                                <th><c:out value="${item}"/></th>
                                            </c:forEach>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                        </div><!-- table content end -->
                    </div>
                </div>
            </div><!-- row end -->
        </div><!-- cl-mcont end -->
    </div><!-- container-fluid end -->
</div><!-- cl-wrapper end -->

<jsp:include page="layout/body_rightchat.jsp"></jsp:include>
<jsp:include page="layout/footer.jsp"></jsp:include>

<script type="text/javascript" src="js/jquery.ui/jquery-ui.js"></script>
<script type="text/javascript" src="js/jquery.jeditable/jquery.jeditable.mini.js"></script>
<script type="text/javascript" src="js/jquery.datatables/jquery.datatables.min.js"></script>
<script type="text/javascript" src="js/jquery.datatables/bootstrap-adapter/js/datatables.js"></script>

<script type="text/javascript">
$(document).ready(function(){
    bootbox.setDefaults({locale:"zh_CN"});
    
    var columns=[];
    <c:forEach var="item" items="${columns_key}" varStatus="loop">
    columns.push({"mData":"${item}"});
    </c:forEach>
    columns.push({"mData":null, "sClass":"text-center", "bSortable":false});
    //Basic Instance
    var myTable=$("#datatable").dataTable({
        "bProcessing":true,
        "bServerSide":true,
        "sServerMethod":"POST",
        "sAjaxSource":"${ajax_url}",
        "aoColumns":columns,
        "fnDrawCallback":function(settings){
            if(settings.aoData.length>0){
                var tmpl = '<a class="label label-default" href="${edit_url}?id={id}"><i class="fa fa-pencil"></i></a> '+
                '<a class="label label-danger delete_item_op" href="javascript:;" data-id="{id}"><i class="fa fa-times"></i></a>';
                
                $("#datatable tbody tr td:last-child").each(function(index){
                  $(this).html("");
                  var functions=$(tmpl.replace(/\{id\}/g, settings.aoData[index]._aData["id"]));
                  functions.appendTo(this);
                });
                $(".delete_item_op").on( "click", function() {
                    var delete_id=$(this).data("id");
                    bootbox.confirm("亲，是否删除当前记录?", function(result) {
                        if(result){
                      	  $.ajax({
                                type: 'post',
                                url: '${delete_url}',
                                data: {id:delete_id},
                                success: function (data) {
                              	  myTable.fnDraw();
                              	  bootbox.alert(data.message);
                                }
                            });
                        }
                    });
                });
            }//end if
        }
    });
});
</script>
</html>


