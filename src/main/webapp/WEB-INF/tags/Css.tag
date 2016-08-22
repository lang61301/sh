<%@ tag language="java" pageEncoding="UTF-8"%>
<% session.setAttribute("_ctx", request.getContextPath()); %>
<%-- 新 Bootstrap 核心 CSS 文件 --%>
<link rel="stylesheet" href="${_ctx}/static/js/bootstrap/3.3/css/bootstrap.min.css">
<%-- 验证输入样式--%>
<link rel="stylesheet" href="${_ctx}/static/js/bootstrapvalidator/css/bootstrapValidator.min.css">
<%-- datatable 样式--%>
<%--<link rel="stylesheet" href="${_ctx}/static/js/datatable/1.1/css/jquery.dataTables.min.css">--%>
<%-- datatables bootstrap 样式文件--%>
<link rel="stylesheet" href="${_ctx}/static/js/datatable/1.1/css/dataTables.bootstrap.min.css">
<%--ztree 文件 --%>
<link rel="stylesheet" href="${_ctx}/static/js/ztree/css/zTreeStyle/zTreeStyle.css">
<%--日期样式 --%>
<link rel="stylesheet" href="${_ctx}/static/js/My97DatePicker/skin/WdatePicker.css">
<%--上传uploadify --%>
<link rel="stylesheet" href="${_ctx}/static/js/uploadify/uploadify.css">

<%--main  CSS 文件 --%>
<link rel="stylesheet" href="${_ctx}/static/css/main.css?ver=<%=me.paddingdun.web.util.IResourceVersion.VERSION %>">

