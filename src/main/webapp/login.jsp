<%@page contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title><spring:message code="app.title" /></title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet" href="static/js/bootstrap/css/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <style type="text/css">
    body {
	  padding-top: 40px;
	  padding-bottom: 40px;
	  background-color: #eee;
	}
	
	.form-signin {
	  max-width: 330px;
	  padding: 15px;
	  margin: 0 auto;
	}
	.form-signin .form-signin-heading,
	.form-signin .checkbox {
	  margin-bottom: 10px;
	}
	.form-signin .checkbox {
	  font-weight: normal;
	}
	.form-signin .form-control {
	  position: relative;
	  height: auto;
	  -webkit-box-sizing: border-box;
	     -moz-box-sizing: border-box;
	          box-sizing: border-box;
	  padding: 10px;
	  font-size: 16px;
	}
	.form-signin .form-control:focus {
	  z-index: 2;
	}
	.form-signin input[type="text"] {
	  margin-bottom: -1px;
	  border-bottom-right-radius: 0;
	  border-bottom-left-radius: 0;
	}
	.form-signin input[type="password"] {
	  margin-bottom: 10px;
	  border-top-left-radius: 0;
	  border-top-right-radius: 0;
	}
	
	/** 页脚******/
	.footer {
	  position: absolute;
	  bottom: 0;
	  width: 100%;
	  /* Set the fixed height of the footer here */
	  height: 60px;
	  background-color: #f5f5f5;
	}
    </style>
  </head>
  <body>
    <div class="container">

      <form class="form-signin" action="login" method="post">
        <h2 class="form-signin-heading"><spring:message code="user.login.head" /></h2>
        <label for="loginName" class="sr-only"><spring:message code="user.login.name" /></label>
        <input type="text" id="loginName" name="loginName" class="form-control" placeholder="<spring:message code="user.login.name" />" required autofocus>
        <label for="password" class="sr-only"><spring:message code="user.login.pwd" /></label>
        <input type="password" id="password" name="password" class="form-control" placeholder="<spring:message code="user.login.pwd" />" required>
        <div class="form-group col-md-6">
        	<label for="code" class="sr-only"><spring:message code="user.login.captcha" /></label>
        	<input type="text" id="code" name="code" class="form-control" placeholder="<spring:message code="user.login.captcha" />" required>
        </div>
        <div class="form-group col-md-6">
        	<img id="genCode" title="点击刷新验证码">
        </div>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> <spring:message code="user.login.remember" />
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="user.login.button" /></button>
      </form>

    </div> <!-- /container -->
    
    
    <footer class="footer">
      <div class="container">
        <p class="text-muted">联系我.</p>
      </div>
    </footer>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script type="text/javascript" src="static/js/jquery/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script type="text/javascript" src="static/js/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#genCode").on("click", function(){
		$(this).attr("src", "captcha?_r=" + (new Date().getTime()));
		$('#code').val('').focus();
	});
	$("#genCode").trigger("click");
});
</script>
</body>
</html>
