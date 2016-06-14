<%@page contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="cus" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ --%>
    <title><spring:message code="app.title" /></title>
    
	<cus:Css/>
	
    <style type="text/css">
    body {
	  padding-top: 40px;
	  padding-bottom: 40px;
	  background-color: #eee;
	}
	
	/** 页脚******/
    </style>
  </head>
  <body>
    <div class="container">
		405
    </div> <!-- /container -->
<cus:Footer/>
<cus:JavaScript/>
<script type="text/javascript">
$(document).ready(function(){
	
});
</script>
</body>
</html>
