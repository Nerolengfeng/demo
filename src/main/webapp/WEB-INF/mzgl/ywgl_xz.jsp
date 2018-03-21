<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.example.demo.dto.BrjcxbVB"%>
<%@page import="com.example.demo.dto.BrnyxxbVB"%>
<%@page import="com.example.demo.dto.MzglFB"%>
<%@page import="com.example.demo.dto.RyjbxxbVB"%>
<%@page import="com.example.demo.util.StringTools"%>
<%@page import="com.example.demo.util.DateTools"%>
<%@page import="com.example.demo.controller.TableOperator"%>
<%@page import="com.example.demo.dto.YwryPojoVB"%>
<%@page import="com.example.demo.dto.SessionConfig"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>
<%
	SessionConfig sessionConf = (SessionConfig) session.getAttribute("sessionConf");
	if (sessionConf == null) {
		session.setAttribute("errorMsg","连接超时，请重新登录！");
		response.sendRedirect(path+"/error.jsp");
		return;
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>门诊药价</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path%>/static/style/css/YyjgptStyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="/static/message.jsp" %>
<form name="form1" method="post">
<h2 class="mbx">当前位置：门诊药价 &nbsp;&gt;&nbsp; 药物新增</h2>

<div class="cztable">
	<table border="0" cellspacing="0" cellpadding="0" width="98%">
		<tr>
			<td align="left" bgcolor="#8DC5E6"><h1>药物新增</h1></td>
		</tr>
		<tr>
			<td align="center">
				<table width="50%">
					<tr>
						<td align="right" width="40%"><h2>药物名称</h2></td>
						<td width="60%"><input type="text" name="ywmc" /></td>
					</tr>
					<tr>
						<td align="right" width="40%"><h2>药物单价</h2></td>
						<td width="60%"><input type="text" name="ywdj" /></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr><td></td></tr>
		<tr align="center">
			<td colspan="4">
				<input type="button" class="input2" value="提 交" onclick="tj()" />
			</td>
		</tr>
	</table>
</div>
</form>
</body>
<script type="text/javascript" src="<%=path %>/static/js/jquery/jquery-1.7.2.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/common.js"></script>
<script type="text/javascript">
		
	function tj () {
		if ($("[name='ywmc']").val() == "") {
			alert("请输入药物名称！");
			return;
		}
		if ($("[name='ywdj']").val() == "") {
			alert("请输入药物单价！");
			return;
		}
		if (confirm("确定提交？")) {
			form1.action = "<%=path %>/mzgl/ywxz.do";
			form1.submit();
		}
	}
</script>
</html>







							