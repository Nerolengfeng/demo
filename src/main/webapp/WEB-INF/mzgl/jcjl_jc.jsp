<%@page import="com.example.demo.dto.BrjcxbVB"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	RyjbxxbVB ryxx = null;
	if (request.getAttribute("ryxx") != null) {
		ryxx = (RyjbxxbVB) request.getAttribute("ryxx");
	}
	String grbh = "";// 个人编号
	String sfzhm = "";// 身份证号码 
	String xm = "";// 姓名
	String xb = "";// 性别
	String nl = "";// 年龄
	String birthday = "";// 出生日期 
	String mz = "";// 民族
	String telephone = "";// 手机
	String phone = "";// 家庭电话
	String hkszdxzqh = "";// 户口所在地行政区划
	String jzszdxzqh = "";// 居住所在地行政区划
	String jzszdxx = "";// 居住所在地细项
	

	if (ryxx != null) {
		grbh = StringTools.toTirm(ryxx.getGrbh());// 个人编号
		sfzhm = StringTools.toTirm(ryxx.getSfzhm());// 身份证号码 
		xm = StringTools.toTirm(ryxx.getXm());// 姓名
		xb = StringTools.toTirm(ryxx.getXb());// 性别
		nl = StringTools.toTirm(ryxx.getNl());// 年龄
		birthday = StringTools.toTirm(ryxx.getBirthday());// 出生日期 
		mz = StringTools.toTirm(ryxx.getMz());// 民族
		telephone = StringTools.toTirm(ryxx.getTelephone());// 手机
		phone = StringTools.toTirm(ryxx.getPhone());// 家庭电话
		hkszdxzqh = StringTools.toTirm(ryxx.getHkszdxzqh());// 户口所在地行政区划
		jzszdxzqh = StringTools.toTirm(ryxx.getJzszdxzqh());// 居住所在地行政区划
		jzszdxx = StringTools.toTirm(ryxx.getJzszdxx());// 居住所在地细项
	}
	
	MzglFB fb = null;
	if (request.getAttribute("fb") != null) {
		fb = (MzglFB) request.getAttribute("fb");
	}
	String ghkbh = "";
	String wzbh = "";
	if (fb != null) {
		ghkbh = StringTools.toTirm(fb.getGhkbh());
		wzbh = StringTools.toTirm(fb.getWzbh());
	}
	BrjcxbVB[] jcs = null;
	if (request.getAttribute("jcs") != null) {
		jcs = (BrjcxbVB[]) request.getAttribute("jcs");
	}
	
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
<input type="hidden" name="ghsj" value="<%=wzbh %>" />
<h2 class="mbx">当前位置：护士工作站 &nbsp;&gt;&nbsp; 检查记录</h2>

<div class="cztable">
	<table border="0" cellspacing="0" cellpadding="0" width="98%">
		<tr>
			<td align="left" colspan="4" bgcolor="#8DC5E6"><h1>人员基本信息</h1></td>
		</tr>
		<tr>
			<td align="right" width="20%">身份证号码</td>
			<td align="left" width="40%"><%=sfzhm %></td>
			<td align="right" width="15%">姓名</td>
			<td align="left" width="25%"><%=xm %></td>
		</tr>
		<tr>
			<td align="right">性别</td>
			<td align="left"><%=xb %></td>
			<td align="right">年龄</td>
			<td align="left"><%=nl %></td>
		</tr>
		<tr>
			<td align="right">民族</td>
			<td align="left"><%=mz %></td>
			<td align="right">出生年月</td>
			<td align="left"><%=birthday %></td>
		</tr>
		
		<tr>
			<td align="left" colspan="4" bgcolor="#8DC5E6">检查信息</td>
		</tr>
		<tr>
			<td colspan="4">
				<table width="98%">
					<thead>
						<tr>
							<td align="center" width="40%"><h2>检查名称</h2></td>
							<td align="center" width="60%">检查说明</td>
						</tr>
					</thead>
					<tbody>
					<%
						if (jcs != null) {
							for (int i=0; i<jcs.length; i++) {
							%>
								<tr align="center">
									<td><%=jcs[i].getJcmc() %></td>
									<td><input type="hidden" name="jcid" value="<%=jcs[i].getJcdm() %>" /><input type="text" name="jcsm" size="45" /></td>
								</tr>
							<%
							}
						}
					%>
					</tbody>
				</table>
			</td>
		</tr>
		<tr><td></td><td></td><td></td><td></td></tr>
		<tr align="center">
			<td colspan="4">
				<input type="button" class="input2" value="提 交" onclick="tj()" />
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
	function goBack() {
		window.location.href = "<%=path%>/mzgl/jcjl_cx.jsp";
	}
</script>
</html>