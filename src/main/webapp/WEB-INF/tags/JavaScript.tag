<%@ tag language="java" pageEncoding="UTF-8"%>
<% session.setAttribute("_ctx", request.getContextPath()); %>
<%-- jQuery文件。务必在bootstrap.min.js 之前引入 --%>
<script type="text/javascript" src="${_ctx }/static/js/jquery/2.1.4/jquery-2.1.4.min.js"></script>
<%-- 最新的 Bootstrap 核心 JavaScript 文件 --%>
<script type="text/javascript" src="${_ctx }/static/js/bootstrap/3.3/js/bootstrap.min.js"></script>
<%-- jquery form文件 --%>
<script type="text/javascript" src="${_ctx}/static/js/jquery/jquery.form.js"></script>
<%--jquery mask --%>
<script type="text/javascript" src="${_ctx}/static/js/jquery/jquery.blockUI.js"></script>
<%-- 验证输入 --%>
<script type="text/javascript" src="${_ctx}/static/js/bootstrapvalidator/js/bootstrapValidator.min.js"></script>
<%-- datatables 文件--%>
<script type="text/javascript" src="${_ctx}/static/js/datatable/1.1/js/jquery.dataTables.min.js"></script>
<%--datatables bootstrap 文件 --%>
<script type="text/javascript" src="${_ctx}/static/js/datatable/1.1/js/dataTables.bootstrap.min.js"></script>
<%--json2 文件 --%>
<script type="text/javascript" src="${_ctx}/static/js/json2.js"></script>
<%--ztree 文件 --%>
<script type="text/javascript" src="${_ctx}/static/js/ztree/js/jquery.ztree.all-3.5.min.js"></script>
<%--日期 文件 --%>
<script type="text/javascript" src="${_ctx}/static/js/My97DatePicker/WdatePicker.js"></script>

<%--上传uploadify --%>
<script type="text/javascript" src="${_ctx}/static/js/uploadify/jquery.uploadify.fix.js"></script>

<%--应用工具类 --%>
<script type="text/javascript" src="${_ctx}/static/js/util.js?ver=<%=me.paddingdun.web.util.IResourceVersion.VERSION %>"></script>
<%--默认datatables构造文件 --%>
<script type="text/javascript" src="${_ctx}/static/js/tables.js?ver=<%=me.paddingdun.web.util.IResourceVersion.VERSION %>"></script>
<%--main --%>
<script type="text/javascript" src="${_ctx}/static/js/main.js?ver=<%=me.paddingdun.web.util.IResourceVersion.VERSION %>"></script>
