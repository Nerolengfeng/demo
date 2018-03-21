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
<%
	MzglFB fb = null;
	if (request.getAttribute("fb") != null) {
		fb = (MzglFB) request.getAttribute("fb");
	}
	String ghkbh = "";
	String ghsj = "";
	String grbh = "";
	String wzbh = "";
	if (fb != null) {
		ghkbh = StringTools.toTirm(fb.getGhkbh());
		ghsj = StringTools.toTirm(fb.getGhsj());
		grbh = StringTools.toTirm(fb.getGrbh());
		wzbh = StringTools.toTirm(fb.getWzbh());
	}
	BrnyxxbVB[] nys = (BrnyxxbVB[]) request.getAttribute("nys");
	BrjcxbVB[] jcs = (BrjcxbVB[]) request.getAttribute("jcs");
	int zje = 0;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>医生工作站</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path%>/static/style/css/YyjgptStyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="/static/message.jsp" %>
<form name="form1" method="post">
<input type="hidden" name="grbh" value="<%=grbh %>" />
<input type="hidden" name="ghkbh" value="<%=ghkbh %>" />
<input type="hidden" name="ghsj" value="<%=ghsj %>" />
<input type="hidden" name="wzbh" value="<%=wzbh %>" />
<h2 class="mbx">当前位置：门诊收费&nbsp;&gt;&nbsp; 收费</h2>

<div class="cztable">
	<table border="0" cellspacing="0" cellpadding="0" width="98%">
		<tr>
			<td align="left" colspan="4" bgcolor="#8DC5E6"><h1>药物收费</h1></td>
		</tr>
		<tr>
			<td colspan="4">
				<table width="98%">
					<thead>
						<tr>
							<td align="center" width="15%"><h2>序号</h2></td>
							<td align="center" width="45%"><h2>药物名称</h2></td>
							<td align="center" width="20%"><h2>份数</h2></td>
							<td align="center" width="20%"><h2>缴费金额</h2></td>
						</tr>
					</thead>
					<tbody>
					<%
						if (nys != null) {
							for (int i=0; i<nys.length; i++) {
								zje += Integer.parseInt(nys[i].getJnje());
							%>
								<tr align="center">
									<td><%=i+1 %></td>
									<td><%=nys[i].getYpbh() %></td>
									<td><%=nys[i].getYpfs() %></td>
									<td><%=nys[i].getJnje() %></td>
								</tr>
							<%
							}
						}
					%>
					</tbody>
				</table>
			</td>
		</tr>
		
		<tr>
			<td align="left" colspan="4" bgcolor="#8DC5E6"><h1>检查收费</h1></td>
		</tr>
		<tr>
			<td colspan="4">
				<table width="98%">
					<thead>
						<tr>
							<td align="center" width="20%"><h2>序号</h2></td>
							<td align="center" width="50%"><h2>检查名称</h2></td>
							<td align="center" width="30%"><h2>缴费金额</h2></td>
						</tr>
					</thead>
					<tbody>
					<%
						if (jcs != null) {
							for (int i=0; i<jcs.length; i++) {
								zje += Integer.parseInt(jcs[i].getJnje());
							%>
								<tr align="center">
									<td><%=i+1 %></td>
									<td><%=jcs[i].getJcmc() %></td>
									<td><%=jcs[i].getJnje() %></td>
								</tr>
							<%
							}
						}
					%>
					</tbody>
				</table>
			</td>
		</tr>
		<tr><td align="center" colspan="4">总金额：<%=zje %></td></tr>
		<tr><td></td><td></td><td></td><td></td></tr>
		<tr align="center">
			<td colspan="4">
				<input type="button" class="input2" value="缴 费" onclick="tj()" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" class="input2" value="返 回" onclick="goBack()" />
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
		if (confirm("是否缴费？")) {
			form1.action = "<%=path %>/mzgl/ryjf.do";
			form1.submit();
		}
	}
	function goBack() {
		window.location.href = "<%=path%>/mzgl/mzsf_cx.jsp";
	}
</script>
</html>