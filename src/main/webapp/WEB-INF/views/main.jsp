<%@page contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="cus" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title><spring:message code="app.title" /></title>
	<%-- 引用公共css文件 --%>
    <cus:Css/>
    
  </head>
  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">项目</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="${_ctx }/logout">退出</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>
    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <div class="panel-group" role="tablist" id="menuList">
          <c:forEach items="${sys_menu }" var="s1" varStatus="m">
		    <div class="panel panel-default">
		      <div class="panel-heading" role="tab">
		        <h4 class="panel-title">
		          <a class="" role="button" data-toggle="collapse" href="#collapseListGroup${s1.nodeId }" data-parent="#menuList" aria-expanded="true" aria-controls="collapseListGroup${s1.nodeId }">
		            	${s1.nodeName }
		          </a>
		        </h4>
		      </div>
		      <div id="collapseListGroup${s1.nodeId }" class="panel-collapse collapse <c:if test='${m.index==0}'>in</c:if>" role="tabpanel" aria-expanded="true">
		        <ul class="list-group">
		        <c:forEach items="${s1.children }" var="s2">
		        	 <li class="list-group-item"><a class="nav-link" href="#" data-href="<c:if test='${s2.object.url!=null }'>${_ctx }/${s2.object.url}</c:if>">${s2.nodeName }</a></li>
		        </c:forEach>
		        </ul>
		      </div>
		    </div>
		    </c:forEach>
		  </div>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main detail-right-content">
        </div>
      </div>
    </div>
    
	<%-- 引用的公共javascript文件--%>
	<cus:JavaScript/>
	<script type="text/javascript">
	$(document).ajaxStart(function (a, b, c) {
		}).ajaxSend(function (e, jqXHR, options) {
		}).ajaxError(function (e, xhr, opts) {
		}).ajaxSuccess(function (e, xhr, opts) {
			if(!!window.sessionTimeout)return false;
			if(me.Util.session_ajax_timeout(xhr)){
				alert("登录已超时,请重新登录");
				window.location.href = "${_ctx}/login.jsp";
				return false;
			}
		}).ajaxComplete(function (e, xhr, options) {
		}).ajaxStop(function () {
		}).ready(function(){
			Index.init();
	});
	</script>
</body>
</html>
