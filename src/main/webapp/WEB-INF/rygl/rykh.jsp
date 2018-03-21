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
	SessionConfig sessionConf = (SessionConfig) session.getAttribute("sessionConf");
	if (sessionConf == null) {
		session.setAttribute("errorMsg","连接超时，请重新登录！");
		response.sendRedirect(path+"/error.jsp");
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
<%@include file="/static/message.jsp" %>
<h2 class="mbx">当前位置：绩效考核管理 &nbsp;&gt;&nbsp; 绩效考核</h2>
<form name="form1" method="post">
<input type="hidden" name="grbh" value="<%=grbh %>" />
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
			<td align="right">居住所在地</td>
			<td align="left"><%=jzszdxzqh %></td>
			<td align="right" >居住所在地细项</td>
			<td colspan="3"><%=jzszdxx %></td>
		</tr>
		<tr>
			<td align="right">家庭电话</td>
			<td align="left"><%=phone %></td>
			<td align="right">手机</td>
			<td align="left"><%=telephone %></td>
		</tr>
		<tr>
			<td align="left" colspan="4" bgcolor="#8DC5E6"><h1>人员绩效考核</h1></td>
		</tr>
		<tr>
			<td align="right">遵守工作时间</td>
			<td colspan="3">
				<span title="严格遵守工作时间，无迟到/早退，请假手续齐全"><input type="radio" name="zsgzsj" value="5" />非常满意</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span title="有1-2次迟到/早退，请假手续齐全"><input type="radio" name="zsgzsj" value="4" />满意</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span title="有3-5次迟到/早退，请假手续齐全"><input type="radio" name="zsgzsj" value="3" />基本满意</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span title="一月有1/3工作日迟到/早退，请假手续齐全"><input type="radio" name="zsgzsj" value="2" />一般</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span title="一月有1/3工作日迟到/早退或请假手续不齐全超过3天"><input type="radio" name="zsgzsj" value="1" />较差</span>
			</td>
		</tr>
		<tr>
			<td align="right">责任事故</td>
			<td colspan="3">
				<span title="无责任事故发生"><input type="radio" name="zrsg" value="5" />非常满意</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span title="有轻微责任事故发生、但及时解决"><input type="radio" name="zrsg" value="4" />满意</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span title="有责任事故发生、未及时解决"><input type="radio" name="zrsg" value="3" />基本满意</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span title="有责任事故发生、但及时解决"><input type="radio" name="zrsg" value="2" />一般</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span title="有重大责任事故发生、未及时解决"><input type="radio" name="zrsg" value="1" />较差</span>
			</td>
		</tr>
		<tr>
			<td align="right">遵守纪律</td>
			<td colspan="3">
				<span title="严格遵守纪律"><input type="radio" name="zsjl" value="5" />非常满意</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span title="遵守纪律"><input type="radio" name="zsjl" value="4" />满意</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span title="基本遵守纪律、但有些小问题"><input type="radio" name="zsjl" value="3" />基本满意</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span title="基本遵守纪律，存在一些问题"><input type="radio" name="zsjl" value="2" />一般</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span title="基本遵守纪律，存在很大问题"><input type="radio" name="zsjl" value="1" />较差</span>
			</td>
		</tr>
		<tr>
			<td align="right">工作态度</td>
			<td colspan="3">
				<span title="工作踏实、认真，态度积极负责"><input type="radio" name="gztd" value="5" />非常满意</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span title="工作踏实、认真，态度良好"><input type="radio" name="gztd" value="4" />满意</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span title="工作踏实、认真，态度一般"><input type="radio" name="gztd" value="3" />基本满意</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span title="工作踏实，态度一般"><input type="radio" name="gztd" value="2" />一般</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span title="工作一般，表现态度差"><input type="radio" name="gztd" value="1" />较差</span>
			
			</td>
		</tr>
		<tr>
			<td align="right">任务完成情况</td>
			<td colspan="3">
				<span title="工作任务情况按时完成，完成质量很好"><input type="radio" name="rwwcqk" value="30" />非常满意</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span title="工作任务情况按时完成，完成质量合格"><input type="radio" name="rwwcqk" value="24" />满意</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span title="工作任务情况按时完成，完成质量良好"><input type="radio" name="rwwcqk" value="18" />基本满意</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span title="工作任务情况按时完成，完成质量一般"><input type="radio" name="rwwcqk" value="12" />一般</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span title="工作任务情况未按时完成"><input type="radio" name="rwwcqk" value="6" />较差</span>
			</td>
		</tr>
		<tr>
			<td align="right">工作合规性</td>
			<td colspan="3">
				<span title="工作严格按照规定执行"><input type="radio" name="gzhgx" value="30" />非常满意</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span title="工作很好按照规定执行"><input type="radio" name="gzhgx" value="24" />满意</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span title="工作较好按照规定执行"><input type="radio" name="gzhgx" value="18" />基本满意</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span title="工作按照规定执行"><input type="radio" name="gzhgx" value="12" />一般</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span title="工作未按照规定执行"><input type="radio" name="gzhgx" value="6" />较差</span>
			</td>
		</tr>
		<tr>
			<td align="right">工作质量</td>
			<td colspan="3">
				<span title="无失误"><input type="radio" name="gzzl" value="20" />非常满意</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span title="存在失误，但失误不大"><input type="radio" name="gzzl" value="16" />满意</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span title="存在失误，失误有点大"><input type="radio" name="gzzl" value="12" />基本满意</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span title="无失误，失误很大"><input type="radio" name="gzzl" value="8" />一般</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span title="存在明显错误"><input type="radio" name="gzzl" value="4" />较差</span>
			</td>
		</tr>
		<tr><td></td><td></td><td></td><td></td></tr>
		<tr align="center">
			<td colspan="4">
				<input type="button" class="input2" value="考 核" onclick="kh()" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" class="input2" value="返 回" onclick="goBack()" />
			</td>
		</tr>
	</table>
</div>
</form>
</body>
<script type="text/javascript" src="<%=path %>/static/js/jquery/jquery-1.7.2.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/common.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/jquery/jquery-ui-datepicker.js"></script>
<script type="text/javascript">
	function goBack() {
		window.location.href = "<%=path%>/rygl/ryjxkhcx.jsp";
	}
	
	function kh() {
		if ($("[name='zsgzsj']:checked").val() == undefined) {
			alert("遵守工作时间未考核");
			return;
		}
		if ($("[name='zrsg']:checked").val() == undefined) {
			alert("责任事故未考核");
			return;
		}
		if ($("[name='zsjl']:checked").val() == undefined) {
			alert("遵守纪律未考核");
			return;
		}
		if ($("[name='gztd']:checked").val() == undefined) {
			alert("工作态度未考核");
			return;
		}
		
		if ($("[name='rwwcqk']:checked").val() == undefined) {
			alert("任务完成情况未考核");
			return;
		}
		if ($("[name='gzhgx']:checked").val() == undefined) {
			alert("工作合规性未考核");
			return;
		}
		if ($("[name='gzzl']:checked").val() == undefined) {
			alert("工作质量未考核");
			return;
		}
		form1.action = "<%=path%>/rygl/rykhBc.do";
		form1.submit();
	}
</script>
</html>
