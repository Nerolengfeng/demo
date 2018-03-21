<%@page import="com.example.demo.util.StringTools"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.example.demo.util.DateTools"%>
<%@page import="com.example.demo.controller.TableOperator"%>
<%@page import="com.example.demo.dto.YwryPojoVB"%>
<%@page import="com.example.demo.dto.SessionConfig"%>
<%@page import="com.example.demo.dto.YwryqjbVB"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	SessionConfig sessionConf = (SessionConfig) session
			.getAttribute("sessionConf");
	if (sessionConf == null) {
		session.setAttribute("errorMsg", "连接超时，请重新登录！");
		response.sendRedirect(path + "/error.jsp");
		return;
	}
%>
<%
	YwryPojoVB vb = null;
	if (request.getAttribute("vb") != null) {
		vb = (YwryPojoVB) request.getAttribute("vb");
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
	String zzmm = "";// 政治面貌
	String whcd = "";// 文化程度
	String ssks = "";// 所属科室
	String rysf = "";// 人员身份 
	String byyx = "";// 毕业院校
	String sxzy = "";// 所学专业
	String ysdj = "";// 医师等级
	String njts = "";// 年假天数
	String jbgz = "";// 基本工资
	String zjfzr = "";// 直接负责人
	String czyid = "";// 操作员ID
	String czsj = "";// 操作时间
	String zhbm = "";// 账号编号
	String zhmm = "";// 账号密码
	int rows = 0;// 请假记录数
	if (vb != null) {
		if (vb.getRyxx() != null) {
			grbh = StringTools.toTirm(vb.getRyxx().getGrbh());// 个人编号
			sfzhm = StringTools.toTirm(vb.getRyxx().getSfzhm());// 身份证号码 
			xm = StringTools.toTirm(vb.getRyxx().getXm());// 姓名
			xb = StringTools.toTirm(vb.getRyxx().getXb());// 性别
			nl = StringTools.toTirm(vb.getRyxx().getNl());// 年龄
			birthday = StringTools.toTirm(vb.getRyxx().getBirthday());// 出生日期 
			mz = StringTools.toTirm(vb.getRyxx().getMz());// 民族
			telephone = StringTools.toTirm(vb.getRyxx().getTelephone());// 手机
			phone = StringTools.toTirm(vb.getRyxx().getPhone());// 家庭电话
			hkszdxzqh = StringTools.toTirm(vb.getRyxx().getHkszdxzqh());// 户口所在地行政区划
			jzszdxzqh = StringTools.toTirm(vb.getRyxx().getJzszdxzqh());// 居住所在地行政区划
			jzszdxx = StringTools.toTirm(vb.getRyxx().getJzszdxx());// 居住所在地细项
		}
		if (vb.getYwry() != null) {
			zzmm = StringTools.toTirm(vb.getYwry().getZzmm());// 政治面貌
			whcd = StringTools.toTirm(vb.getYwry().getWhcd());// 文化程度
			ssks = StringTools.toTirm(vb.getYwry().getSsks());// 所属科室
			rysf = StringTools.toTirm(vb.getYwry().getRysf());// 人员身份 
			byyx = StringTools.toTirm(vb.getYwry().getByyx());// 毕业院校
			sxzy = StringTools.toTirm(vb.getYwry().getSxzy());// 所学专业
			ysdj = StringTools.toTirm(vb.getYwry().getYsdj());// 医师等级
			njts = StringTools.toTirm(vb.getYwry().getNjts());// 年假天数
			jbgz = StringTools.toTirm(vb.getYwry().getJbgz());// 基本工资
			czyid = StringTools.toTirm(vb.getYwry().getCzyid());// 操作员ID
			czsj = StringTools.toTirm(vb.getYwry().getCzsj());// 操作时间
		}
		if (vb.getZhxx() != null) {
			zhbm = StringTools.toTirm(vb.getZhxx().getZhbm());
			zhmm = StringTools.toTirm(vb.getZhxx().getZhmm());
		}
		if (vb.getQjxx() != null) {
			rows = vb.getQjxx().length;
		}
	}
	String nowtime = DateTools.getCurYMD();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>人员请假</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path%>/static/style/css/YyjgptStyle.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/static/style/css/jquery-ui.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="/static/message.jsp"%>
<h2 class="mbx">当前位置：请假管理 &nbsp;&gt;&nbsp; 请假删除</h2>
<input type="hidden" name="grbh" value="<%=grbh%>" />
<div class="cztable">
	<table border="0" cellspacing="0" cellpadding="0" width="98%">
		<tr>
			<td align="left" colspan="4" bgcolor="#8DC5E6"><h1>人员基本信息</h1></td></tr>
		<tr>
			<td align="right" width="20%">身份证号码</td>
			<td align="left" width="40%"><%=sfzhm%></td>
			<td align="right" width="15%">姓名</td>
			<td align="left" width="25%"><%=xm%></td>
		</tr>
		<tr>
			<td align="right">性别</td>
			<td align="left"><%=xb%></td>
			<td align="right">年龄</td>
			<td align="left"><%=nl%></td>
		</tr>
		<tr>
			<td align="right">居住所在地</td>
			<td align="left"><%=jzszdxzqh%></td>
			<td align="right">居住所在地细项</td>
			<td colspan="3"><%=jzszdxx%></td>
		</tr>
		<tr>
			<td align="right">家庭电话</td>
			<td align="left"><%=phone%></td>
			<td align="right">手机</td>
			<td align="left"><%=telephone%></td>
		</tr>
		<tr>
			<td align="left" colspan="4" bgcolor="#8DC5E6"><h1>请假信息:共[&nbsp;<%=rows%>&nbsp;]条</h1></td>
		</tr>
		<%
			if (vb.getQjxx() != null && vb.getQjxx().length > 0) {
		%>
		<tr align="center">
			<td colspan="4">
				<table border="0" cellspacing="0" cellpadding="0" width="98%">
					<tr align="center">
							<td width="14%"><h1>请假日期</h1></td>
							<td width="14%"><h1>请假时间起</h1></td>
							<td width="14%"><h1>请假时间止</h1></td>
							<td width="9%"><h1>请假时长</h1></td>
							<td width="9%"><h1>请假类别</h1></td>
							<td width="23%"><h1>请假原因</h1></td>
							<td width="9%"><h1>负责人</h1></td>
							<td width="8%"><h1>操&nbsp;作</h1></td>
						</tr>
						<%
							YwryqjbVB[] vbs = vb.getQjxx();
								for (int i = 0; i < vbs.length; i++) {
						%>
						<tr align="center" id="tr<%=i%>">
							<td><%=vbs[i].getQjrq()%></td>
							<td><%=vbs[i].getQjsjq()%></td>
							<td><%=vbs[i].getQjsjz()%></td>
							<td><%=vbs[i].getQjsc() + "（天）"%></td>
							<td><%=vbs[i].getQjlb()%></td>
							<td><%=vbs[i].getQjyy()%></td>
							<td><%=vbs[i].getFzrid()%></td>
							<td>
								<a href="#" onclick="sc('tr<%=i%>','<%=vbs[i].getQjrq()%>','<%=vbs[i].getQjsjq()%>','<%=vbs[i].getQjsjz()%>')">删&nbsp;除</a>
							</td>
						</tr>
						<%
							}
						%>
					</table>
				</td>
			</tr>
		<%
			}
		%>
		<tr><td></td><td></td><td></td><td></td></tr>
		<tr align="center">
			<td colspan="4">
				<input type="button" class="input2" value="返 回" onclick="goBack()" />
			</td>
		</tr>
	</table>
</div>
</body>
<script type="text/javascript" src="<%=path%>/static/js/jquery/jquery-1.7.2.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/common.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/jquery/jquery-ui-datepicker.js"></script>
<script type="text/javascript">
	function goBack() {
		window.location.href = "<%=path%>/rygl/ryqjjlsccx.jsp";
	}

	function sc(box, qjrq, qjsjq, qjsjz) {
		if ('<%=nowtime%>' > qjsjz) {
			alert("已休假的记录不能删除！");
			return;
		}
		var flag = false;
		if (confirm("确定取消请假？")) {
			$.ajax({
				url : "<%=path%>/rygl/qjjlsc.do",
				type : "post",
				data : {
					"grbh" : $("[name='grbh']").val(),
					"qjrq" : qjrq,
					"qjsjq" : qjsjq,
					"qjsjz" : qjsjz
				},
				dataType : "json",
				success : function(data) {
					if (data.returnCode == 1) {
						flag = true;
					}
					alert(data.returnMsg);
				},
				complete : function() {
					if (flag) {
						$("#" + box).remove();
					}
				}
			});
		}
	}
</script>
</html>