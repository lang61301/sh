开发必须遵守约定
1.spring的mvc的自定义controller必须继承BaseController;
2.资源国际化:
${resource}/i18n/message*.properties文件中,添加key=value;注意本资源文件编码是UTF-8;
jsp中使用:
	jsp页面头中添加:
	<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	使用:
	<spring:message code="key" /> key可以替换为对应的键值:user.login.name
	