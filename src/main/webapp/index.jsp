<%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE>
<html>
<head lang="zh_CN">
	<title>paddingdun</title>
</head>
<body>
<form action="userAdd" method="post">
姓名:<input name="username">
密码:<input type="password" name="password">

<button class="save" type="button" value="保存">保存</button>
</form>
<button class="list" type="button" value="列表">列表</button>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$(".save").off().on("click", function(){
		var data = $("form").serialize();
		$.ajax("user/userAdd", { 
			    type:"post",
			    dataType:"json",
			    data:data, 
			    success:function(d){
			    	
			    },
			    error:function(e){
			    	
			    },
			    complete:function(e){
			    	
			    }});
	});
	
	$(".list").off().on("click", function(){
		var data = $("form").serialize();
		$.ajax("user/userList", { 
			    type:"post",
			    dataType:"json",
			    success:function(d){
			    	
			    },
			    error:function(e){
			    	
			    },
			    complete:function(e){
			    	
			    }});
	});
});
</script>
</body>
</html>
