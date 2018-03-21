<%@page import="com.example.demo.dto.RyjbxxbVB"%>
<%@page import="com.example.demo.util.StringTools"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.example.demo.util.DateTools"%>
<%@page import="com.example.demo.controller.TableOperator"%>
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
	RyjbxxbVB ryxxvb = (RyjbxxbVB) request.getAttribute("ryxxvb");
	
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
	
	
	if (ryxxvb != null) {
		grbh = StringTools.toTirm(ryxxvb.getGrbh());// 个人编号
		sfzhm = StringTools.toTirm(ryxxvb.getSfzhm());// 身份证号码 
		xm = StringTools.toTirm(ryxxvb.getXm());// 姓名
		xb = StringTools.toTirm(ryxxvb.getXb());// 性别
		nl = StringTools.toTirm(ryxxvb.getNl());// 年龄
		birthday = StringTools.toTirm(ryxxvb.getBirthday());// 出生日期 
		mz = StringTools.toTirm(ryxxvb.getMz());// 民族
		telephone = StringTools.toTirm(ryxxvb.getTelephone());// 手机
		phone = StringTools.toTirm(ryxxvb.getPhone());// 家庭电话
		hkszdxzqh = StringTools.toTirm(ryxxvb.getHkszdxzqh());// 户口所在地行政区划
		jzszdxzqh = StringTools.toTirm(ryxxvb.getJzszdxzqh());// 居住所在地行政区划
		jzszdxx = StringTools.toTirm(ryxxvb.getJzszdxx());// 居住所在地细项
	}
	String jcksfcz = "0";
	if (request.getAttribute("jcksfcz") != null) {
		jcksfcz = "1";
	}
	String ghsj = request.getParameter("ghsj");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>人员新增</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path%>/static/style/css/YyjgptStyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="/static/message.jsp" %>
<form name="form1" method="post">
<input type="hidden" name="jcksfcz" value="<%=jcksfcz %>" />
<input type="hidden" name="ghsj" value="<%=ghsj %>" />
<h2 class="mbx">当前位置：问诊挂号 &nbsp;&gt;&nbsp; 挂号</h2>  

<div class="cztable">
	<table border="0" cellspacing="0" cellpadding="0" width="98%">
		<tr>
			<td align="left" colspan="4" bgcolor="#8DC5E6"><h1>人员基本信息</h1></td>
		</tr>
		<tr>
			<td align="right" width="20%">身份证号码</td>
			<td align="left" width="40%">
			<%
				if (StringTools.isEmpty(sfzhm)) {
			%>
				<input type="text" class="input_2" name="sfzhm" maxlength="18" size="30" onblur="checkSfzhm(this.value)" />
			<%
				} else {
			%>
					<%=sfzhm %><input type="hidden" name="sfzhm" value="<%=sfzhm %>"/>
			<%
				}
			%>
				
			</td>
			<td align="right" width="15%">姓名</td>
			<td align="left" width="25%"><input type="text" class="input_2" value="<%=xm %>" name="xm" size="20" maxlength="20" /></td>
		</tr>
		<tr>
			<td align="right">性别</td>
			<td align="left"><%="1".equals(xb)?"男":("0".equals(xb)?"女":"") %><input type="hidden" name="xb" value="<%=xb %>" /></td>
			<td align="right">年龄</td>
			<td align="left"><%=nl %><input type="hidden" name="nl" value="<%=nl %>" /></td>
		</tr>
		<tr>
			<td align="right">民族</td>
			<td align="left">
				<select name="mz" style="width: 40%"></select>
			</td>
			<td align="right">出生年月</td>
			<td align="left"><%=DateTools.getFormatDate(birthday, "yyyyMMddHHmmss", "yyyy-MM-dd") %><input type="hidden" name="birthday" value="<%=birthday %>" /></td>
		</tr>
		<tr>
			<td align="right">户口所在地</td>
			<td align="left" colspan="3">
				<select name="hkszs" style="width: 10%;"></select>省（市）
				<select name="hkszq" style="width: 10%;"></select>市
				<select name="hkszx" style="width: 10%;"></select>县（区）
				<select name="hkszz" style="width: 10%;"></select>镇（街道）
				<select name="hkszc" style="width: 10%;"></select>村（居）
				<input type="hidden" name="hkszdxzqh" value="" />
			</td>
		</tr>
		<tr>
			<td align="right">居住所在地</td>
			<td align="left" colspan="3">
				<select name="jzszs" style="width: 10%"></select>省（市）
				<select name="jzszq" style="width: 10%"></select>市
				<select name="jzszx" style="width: 10%"></select>县（区）
				<select name="jzszz" style="width: 10%"></select>镇（街道）
				<select name="jzszc" style="width: 10%"></select>村（居）
				<input type="hidden" name="jzszdxzqh" value="" />
			</td>
		</tr>
		<tr>
			<td align="right" >居住所在地细项</td>
			<td colspan="3"><textarea name="jzszdxx" cols="80" rows="1" class="input_2"><%=jzszdxx %></textarea></td>
		</tr>
		<tr>
			<td align="right">家庭电话</td>
			<td align="left"><input type="text" class="input_2" name="phone" value="<%=phone %>" size="30" maxlength="50" /></td>
			<td align="right">手机</td>
			<td align="left"><input type="text" class="input_2" name="telephone" value="<%=telephone %>" size="20" maxlength="11" /></td>
		</tr>
		<tr>
			<td></td><td></td>
			<td></td><td></td>
		</tr>
		<tr>
			<td align="center" colspan="4">
				<input type="button" class="input2" value="保 存" onclick="save()" />&nbsp;&nbsp;
				<input type="button" class="input2" value="返 回" onclick="goBack()" />
			</td>
		</tr>
	</table>
</div>
<input type="hidden" name="grbh" value="<%=grbh %>" />
</form>
</body>
<script type="text/javascript" src="<%=path %>/static/js/jquery/jquery-1.7.2.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/common.js"></script>
<script type="text/javascript">
$(function() {
	initDmb ("mz", "mzdmb","<%=mz %>");
	initXzqh("hksz", "<%=hkszdxzqh %>");
	initXzqh("jzsz", "<%=jzszdxzqh %>");
			
});

function save() {

	if ($("[name='sfzhm']").val() == '') {
		alert("身份证号码不能为空！");
		return;
	} else if ($("[name='xm']").val() == ''){
		alert("姓名不能为空！");
		return;
	} else if ($("[name='xb']").val() == ''){
		alert("性别不能为空！");
		return;
	} else if ($("[name='nl']").val() == ''){
		alert("年龄不能为空！");
		return;
	} else if ($("[name='mz']").val() == ''){
		alert("请选择民族！");
		return;
	} else if ($("[name='birthday']").val() == ''){
		alert("出生日期不能为空！");
		return;
	} else if ($("[name='hkszdxzqh']").val() == '' || $("[name='hkszdxzqh']").val().length != 12){
		if ($("[name='hkszdxzqh']").val() == '') {
			alert("请选择户口所在省（市）！");
		} else if ($("[name='hkszdxzqh']").val().length == 2) {
			alert("请选择户口所在市！");
		} else if ($("[name='hkszdxzqh']").val().length == 4) {
			alert("请选择户口所在县（区）！");
		} else if ($("[name='hkszdxzqh']").val().length == 6) {
			alert("请选择户口所在镇（街道）！");
		} else if ($("[name='hkszdxzqh']").val().length == 9) {
			alert("请选择户口所在村（居）！");
		}
		return;
	} else if ($("[name='jzszdxzqh']").val() == '' || $("[name='jzszdxzqh']").val().length != 12){
		if ($("[name='jzszdxzqh']").val() == '') {
			alert("请选择居住所在省（市）！");
		} else if ($("[name='jzszdxzqh']").val().length == 2) {
			alert("请选择居住所在市！");
		} else if ($("[name='jzszdxzqh']").val().length == 4) {
			alert("请选择居住所在县（区）！");
		} else if ($("[name='jzszdxzqh']").val().length == 6) {
			alert("请选择居住所在镇（街道）！");
		} else if ($("[name='jzszdxzqh']").val().length == 9) {
			alert("请选择居住所在村（居）！");
		}
		return;
	} else if ($("[name='phone']").val() == '' && $("[name='telephone']").val() == ''){
		alert("联系方式只是要有一个！");
		return;
	}
	form1.action = "<%=path %>/mzgl/brrySave.do";
	form1.submit();
}

function goBack() {
	window.location.href = "<%=path %>/mzgl/ghsy.jsp";
}
</script>
</html>







