<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>欢迎页面</title>
<style>
body {
	background: url(/static/style/img/welcome.jpg) top left;
	background-size: 100% 100%;
	overflow: hidden;
}
</style>
</head>

<body style="width:100%; height:100%;">

</body>
</html>
