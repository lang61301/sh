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
    <h1>Uploadify Demo</h1>
	<form>
		
		<input id="uploadFile" name="uploadFile" type="file" multiple="true">
	</form>
	<textarea rows="30" cols="30" id="editor"></textarea>
    
	<%-- 引用的公共javascript文件--%>
	<cus:JavaScript/>
	<script type="text/javascript">
	$(document).ready(function(){
		/**CKEDITOR.editorConfig = function( config ) {
			// Define changes to default configuration here. For example:
			// config.language = 'fr';
			config.toolbar_AAA =
				[
				    ['Bold', 'Italic', 'Underline', '-', 'NumberedList', 'BulletedList', '-','Outdent','Indent','-','Image']
				];
			
			config.uiColor = '#34dd45';
		};**/

		CKEDITOR.replace("editor",{
			customConfig: '',
			toolbar_Basic :
				[
				    ['Source','-','Bold', 'Italic', 'Underline', '-', 'NumberedList', 'BulletedList', '-','Outdent','Indent', '-', 'Image']
				],
			toolbar:"Basic",
			baseHref : 'http://localhost:8080/yjtk/',
			filebrowserImageUploadUrl :'${_ctx}/test/upload',
			removeDialogTabs :'image:advanced;image:Link',
		});
		
		$('#uploadFile').uploadify({
			'multi':false,
			'buttonText':'选择文件',
			'fileObjName':'uploadFile',
			//'fileTypeExts':'*.zip',
			'fileTypeDesc':'zip文件',
			//'fileSizeLimit':'1KB',
			'onSelectError':function(file, errorCode){//选择错误;
				
				//文件大小控制;
				if(errorCode == -110){
					this.queueData.errorMsg = "文件大小不能超过" + this.settings.fileSizeLimit;
				
				//文件类型错误;
				}else if(errorCode == -130){
					this.queueData.errorMsg = "请选择zip文件!";
				}
			},
			'onUploadSuccess':function(file, data, response){//上传成功;
				console.info(JSON.parse(data));
				console.info(data);
			},
			'onUploadError' : function(file, errorCode, errorMsg){//上传失败;
				
			},
			'onUploadComplete':function(file){//上传完成;
				
			},
			'swf'      : '${_ctx}/static/js/uploadify/uploadify.swf',
			'uploader' : '${_ctx}/test/upload'
		});
	});
	</script>
</body>
</html>
