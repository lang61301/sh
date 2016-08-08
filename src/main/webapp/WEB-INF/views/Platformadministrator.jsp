<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="cus" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>


    <meta name="description" content="">
    <meta name="author" content="">

	<cus:Css/>   
   
  </head>
  <body>
<div class="container-fluid">

<div class="row">
	<div class="col-sm-12 col-md-12">
		<div class="panel panel-default">
		<div class="panel-heading">查询</div>
		<div class="panel-body">
	    	<div class="container-fluid">
			    <div class="row">
					<div class="col-md-12">
						<form class="form-horizontal PlatformadministratorformQuery" role="form">
						
	<div class="form-group">
		
	<label class="col-sm-2 control-label">
		姓名
		</label>
		<div class="col-sm-2">
			<input type="text" class="form-control" name="fullname">
		</div> 
	
	<label class="col-sm-2 control-label">
		角色
		</label>
		<div class="col-sm-2">
			<input type="text" class="form-control" name="rolename">
		</div> 
	
		</div> 
	
						</form>
					</div>
				</div>
	      	</div>
		</div>
		<div class="panel-heading">
	    	<div class="row">
	    		<div class="col-lg-offset-10 col-lg-2">
	    			<a class="btn btn-primary Platformadministratorquery" href="#" role="button">查询</a>
	    			<a class="btn btn-default Platformadministratorreset" href="#" role="button">重置</a>
	    		</div>
	    	</div>
		</div>
		</div>
	</div>
</div>
  <div class="row">
    <div class="col-sm-12 col-md-12 main">
    <div class="panel panel-default">
	  <!-- Default panel contents -->
	  <div class="panel-heading">
	  	   <div class="row">
	    		<div class="col-lg-2">
	    			<a class="btn btn-primary Platformadministratornew" role="button">新增</a>
	    			<a class="btn btn-primary Platformadministratordelete" role="button">删除</a>
	    		</div>
	    	</div>
	  </div>
        <table id="table_id" class="table table-striped table-bordered" style="margin-top:0px !important" width="100%" cellspacing="0">
		 <thead>
				 <tr>
				 											<th>
	<input type="checkbox" class="list_head_group_checkbox"> 
	</th>
																				<th></th>
																				<th>昵称</th>
																				<th>姓名</th>
																													<th>手机</th>
																				<th>角色</th>
																				<th>操作</th>
													 </tr>
			</thead>
		 <tbody>
		 </tbody>
		</table>
	 </div>
    </div>
  </div>
</div>

<div class="modal fade" id="editModal" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
  <form class="form-horizontal PlatformadministratorformEdit" role="form" action="${_ctx}/Platformadministrator/edit" method="post">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">编辑</h4>
      </div>
      <div class="modal-body">
        <div class="container-fluid">
		    <div class="row">
				<div class="col-md-12">
																		
	<input type="hidden" id="paid" name="paid"> 
	
																								
	<div class="form-group">
			<label for="headportrait" class="col-sm-2 control-label">
			头像
			</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="headportrait" name="headportrait">
			</div>
		</div> 
	
																								
	<div class="form-group">
			<label for="nickname" class="col-sm-2 control-label">
			昵称
			</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="nickname" name="nickname">
			</div>
		</div> 
	
																								
	<div class="form-group">
			<label for="fullname" class="col-sm-2 control-label">
			姓名
			</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="fullname" name="fullname">
			</div>
		</div> 
	
																								
	<div class="form-group">
			<label for="psrid" class="col-sm-2 control-label">
			角色
			</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="psrid" name="psrid">
			</div>
		</div> 
	
																								
	<div class="form-group">
			<label for="mphone" class="col-sm-2 control-label">
			手机
			</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="mphone" name="mphone">
			</div>
		</div> 
	
																								
	<div class="form-group">
			<label for="loginpassword" class="col-sm-2 control-label">
			登录密码
			</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="loginpassword" name="loginpassword">
			</div>
		</div> 
	
																	
				</div>
			</div>
      	</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary Platformadministratorsave">保存</button>
      </div>
    </div>
    </form>
  </div>
</div>
<cus:JavaScript/>

<script type="text/javascript">
$(document).ready(function(){
	/**
	 * datatables表格数据;
	 */
	var table = Tables.initTable($("#table_id"), {
		"processing":true,
		"serverSide": true,
		"createdRow": function ( row, data, index ) {
        },
        columns:[
        
	{"data":"PAID", "defaultContent":"",
				 "render":function( data, type, row, meta ){
				 	return '<input type="checkbox" class="list_group_checkbox" value="' + data + '">';
				 }
				} 
	,
	{"data":"HeadPortrait", "defaultContent":""} 
	,
	{"data":"Nickname", "defaultContent":""} 
	,
	{"data":"FullName", "defaultContent":""} 
	,
	{"data":"MPhone", "defaultContent":""} 
	,
	{"data":"RoleName", "defaultContent":""} 
	,
	{"data":null, "defaultContent":"",
		 "render":function( data, type, row, meta ){
			return '<button type="button" class="btn btn-default">'+
			  '<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>'+
			'</button>'+
			'<button type="button" class="btn btn-default">'+
			  '<span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>'+
			'</button>';
		 }
		} 
	        ]
        ,"ajax":{
			"url":"${_ctx}/Platformadministrator/queryPaging",
			"dataType": "json",
			"type":"post",
			"dataSrc":function(json){
				if(json.status == 0){
					json.recordsTotal = json.data.total;
					json.recordsFiltered = json.data.total;
				
					var data = json["data"]["data"];
					return data;
				}else if(json.status < 0){
					alert(json.msg);
				}
				return [];
			},
			"data":function(d){
				//修正传入后台的数据, 使其可以对应java对象;
				me.pdd.DataTable.plainfy_datatables(d);
				
								var f = me.pdd.Form.getForm($(".PlatformadministratorformQuery"));
				$.extend(d, f);
							},
			"complete":function(d){
			}
			
		}
	});
	
	/**
	 * 全选事件;
	 */
	$("#table_id").on("click", ".list_head_group_checkbox", function(){
		var f = this.checked; 
		$(".list_group_checkbox").each(function(){
			this.checked = f;
		});
	});
	
	/**
	 * 编辑记录;
	 */
	$("#table_id").on("click", ".glyphicon-edit", function(){
		//var id = $(this).closest("tr").find(".list_group_checkbox").val();
		var row = $(this).closest("tr");
		var rowData = table.row(row).data();
		var objData = {};
objData["paid"]=rowData["PAID"];
		
		$.blockUI({"baseZ":2001,
			"message":"",
			"css":{border:		'',
				backgroundColor:''}});
		$.ajax("${_ctx}/Platformadministrator/get", 
			{"data":objData, type:"get",
			dataType:"json", success:function(d){
				if(d.status == 0){
					var o = d.data;
					me.pdd.Form.setForm($(".PlatformadministratorformEdit"), o);
					
					//清除验证错误;
					$('.PlatformadministratorformEdit').data('bootstrapValidator').resetForm();
					
					$('#editModal').modal({
			   		  keyboard: false
			   		});
				}else if(d.status < 0){
					alert(d.msg);
				}
			}, complete:function(){$.unblockUI();}});
	});
	
	/**
	 * 单个删除;
	 */
	$("#table_id").on("click", ".glyphicon-remove-circle", function(){
		if(confirm("确定要删除吗?")){
			var row = $(this).closest("tr");
			var rowData = table.row(row).data();
			var dataArr = [];
				var objData = {};
						dataArr.push(rowData["PAID"]);
				objData["paid"]=dataArr; 
				
			$.blockUI({"baseZ":2001,
				"message":"<h2>删除中...</h2>",
				"css":{border:		'',
					backgroundColor:''}});
			$.ajax("${_ctx}/Platformadministrator/delete", 
				{"data":objData, type:"post",
					dataType:"json", success:function(d){
						if(d.status == 0){
							alert(d.msg);
							table.ajax.reload();
						}else if(d.status <0){
							alert(d.msg);
						}
					}, complete:function(){   
						$.unblockUI();
					} 
				});
		}
	});
	
	/**
	 * 选择删除;
	 */
	$(".Platformadministratordelete").on("click", function(){
		  var dataArr = [];
		  $("#table_id .list_group_checkbox").each(function(){
			  if(this.checked)
				  dataArr.push(this.value);
		  });
		  if(dataArr.length == 0){
			  alert("请至少选择一项");
			  return;
		  }
		  if(confirm("确定要删除吗?")){
		   $.blockUI({"baseZ":2001,
						"message":"<h2>删除中...</h2>",
						"css":{border:		'',
							backgroundColor:''}});
					var objData = {};
					objData["paid"]=dataArr; 
					
				$.ajax("${_ctx}/Platformadministrator/delete", 
					{"data":objData, type:"post",
						dataType:"json", success:function(d){
							if(d.status == 0){
								alert(d.msg);
								table.ajax.reload();
							}else if(d.status < 0){
								alert(d.msg);
							}
						}, complete:function(){   
							$.unblockUI();
						} 
					});
			}
	  });
	
	/**
	 * 打开新增;
	 */
	$(".Platformadministratornew").on("click", function(){
		//清空form;
		me.pdd.Form.clearForm($(".PlatformadministratorformEdit"));
		//清除验证错误;
		$('.PlatformadministratorformEdit').data('bootstrapValidator').resetForm();
		$('#editModal').modal({
   		  keyboard: false
   		});
	});
	
	/**
	 * 编辑保存按钮绑定form验证事件;
	 */
	$(".Platformadministratorsave").on("click", function(){
		 $(".PlatformadministratorformEdit").data('bootstrapValidator').validate();
	});
	
	/**
	 * 新增/编辑form验证规则;
	 */
	$('.PlatformadministratorformEdit').bootstrapValidator({
		 excluded:[':disabled'],//默认值为[':disabled', ':hidden', ':not(:visible)'], 但是如果不配置则会发生,隐藏的form不能清除错误提示!;
	     feedbackIcons: {
	         valid: 'glyphicon glyphicon-ok',
	         invalid: 'glyphicon glyphicon-remove',
	         validating: 'glyphicon glyphicon-refresh'
	     },
	     submitButtons: '.Platformadministratorsave', //查找编辑按按钮的规则(使其可以更改编辑按钮状态让其是否可以提交);
	     fields:
	    	 	    		 {
  "headportrait": {
    "validators": {
      "stringLength": {
        "min": 0.0,
        "max": 255.0,
        "message": "必须少于等于255个字符"
      }
    }
  },
  "nickname": {
    "validators": {
      "stringLength": {
        "min": 0.0,
        "max": 40.0,
        "message": "必须少于等于40个字符"
      }
    }
  },
  "fullname": {
    "validators": {
      "notEmpty": {
        "message": "不能为空"
      },
      "stringLength": {
        "min": 0.0,
        "max": 20.0,
        "message": "必须少于等于20个字符"
      }
    }
  },
  "psrid": {
    "validators": {
      "notEmpty": {
        "message": "关联：字典表编号：009平台人员角色：PSRID不能为空"
      },
      "integer": {
        "message": "不是整形数字"
      }
    }
  },
  "mphone": {
    "validators": {
      "notEmpty": {
        "message": "不能为空"
      },
      "stringLength": {
        "min": 0.0,
        "max": 15.0,
        "message": "必须少于等于15个字符"
      }
    }
  },
  "loginpassword": {
    "validators": {
      "notEmpty": {
        "message": "MD5加密存放不能为空"
      },
      "stringLength": {
        "min": 0.0,
        "max": 50.0,
        "message": "MD5加密存放必须少于等于50个字符"
      }
    }
  }
}
	    	 	 });
	
   /**
	* 编辑form验证成功后执行;
	*/
   $('.PlatformadministratorformEdit').on("success.form.bv", function(){
		$.blockUI({"baseZ":2001,
			"message":"<h2>保存中...</h2>",
			"css":{border:		'',
				backgroundColor:''}});
		$(".PlatformadministratorformEdit").ajaxSubmit(
			{	success:function(d){
					if(d.status == 0){
						alert(d.msg);
						table.ajax.reload();
					}else if(d.status < 0){
						alert(d.msg);
					}
				},
				error:function(e){
				},
				complete:function(e){
					$('#editModal').modal("hide");
					$.unblockUI();
				}
		});
		
		//
		return false;
	});
	
	/**
	 * 查询重置;
	 */
	$(".Platformadministratorreset").on("click", function(){
		me.pdd.Form.clearForm($(".PlatformadministratorformQuery"));
	});
	
	/**
	 * 查询;
	 */
	$(".Platformadministratorquery").on("click", function(){
		table.ajax.reload();
	});
});
</script>
</body>
</html>
