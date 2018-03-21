<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE>医院动态监管平台</TITLE>
<META http-equiv="Content-Type" content="text/html; charset=utf-8">
</HEAD>
<FRAMESET frameSpacing="0" rows="80,*">
	<FRAME name="top" src="<%=path %>/frame/top.jsp" frameBorder="0" noResize
		scrolling="no">
	<FRAMESET frameSpacing="0" cols="220,*">
		<FRAME name="menu" src="<%=path %>/frame/left.jsp" frameBorder="0" noResize>
		<FRAME name="dmMain" src="<%=path %>/frame/right.jsp" frameBorder="0">
	</FRAMESET>
	<NOFRAMES>
		<p>This page requires frames, but your browser does not support
			them.</p>
	</NOFRAMES>
</FRAMESET>
</HTML>