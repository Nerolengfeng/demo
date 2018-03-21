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
	}	
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>人员新增</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path%>//static//style/css/YyjgptStyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="/static/message.jsp" %>
<form name="form1" method="post">
<h2 class="mbx">当前位置：人员管理 &nbsp;&gt;&nbsp; 人员新增</h2>  

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
			<td align="left"><%=birthday %><input type="hidden" name="birthday" value="<%=birthday %>" /></td>
		</tr>
		<tr>
			<td align="right">政治面貌</td>
			<td align="left">
				<select name="zzmm" style="width:40%"></select>
			</td>
			<td align="right">文化程度</td>
			<td align="left">
				<select name="whcd" style="width:60%"></select>
			</td>
		</tr>
		<tr>
			<td align="right">毕业院校</td>
			<td align="left"><input type="text" class="input_2" name="byyx" value="<%=byyx %>" size="30" maxlength="50" /></td>
			<td align="right">所学专业</td>
			<td align="left"><input type="text" class="input_2" name="sxzy" value="<%=sxzy %>" size="20" maxlength="50" /></td>
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
			<td align="left" colspan="4" bgcolor="#8DC5E6"><h1>工作基本信息</h1></td>
		</tr>
		<tr>
			<td align="right">所属科室</td>
			<td align="left"><select name="ssks" style="width: 40%"></select></td>
			<td align="right">人员身份</td>
			<td align="left"><select name="rysf" style="width: 60%"></select></td>
		</tr>
		<tr>
			<td align="right">医师等级</td>
			<td align="left"><select name="ysdj" style="width: 40%"></select></td>
			<td align="right">年假天数</td>
			<td align="left">
				<select name="njts" style="width: 60%">
					<option value="1">1</option>
					<option value="3">3</option>
					<option value="7">7</option>
					<option value="15">15</option>
					<option value="20">20</option>
				</select>天
			</td>
		</tr>
		<tr>
			<td align="right">基本工资</td>
			<td align="left"><input type="text" class="input_2" name="jbgz" value="<%=jbgz %>" style="width: 40%" maxlength="6" />元</td>
			<td align="right"></td>
			<td align="left"></td>
		</tr>
		<tr>
			<td align="right">录入人</td>
			<td align="left"><%=StringTools.toTirm(sessionConf.getXm()) %><input type="hidden" name="czyid" value="<%=sessionConf.getGrbh() %>" /></td>
			<td align="right">录入时间</td>
			<td align="left"><%=DateTools.getCurYMD() %><input type="hidden" name="czsj" value="<%=DateTools.getCurYMD() %>" /></td>
		</tr>
		<tr>
			<td align="left" colspan="4" bgcolor="#8DC5E6"><h1>账号信息</h1></td>
		</tr>
		<tr>
			<td align="right">用户名</td>
			<td align="left"><input type="text" class="input_2" name="zhbm" style="width: 40%" value="<%=zhbm %>" onblur="pdzhsfcz(this)" /><span id="span1" class="sucMg"></span></td>
			<td align="right">密码</td>
			<td align="left"><input type="password" class="input_2" name="zhmm" style="width: 60%" value="<%=zhmm %>" /></td>
		</tr>
		<tr>
			<td></td><td></td>
			<td align="right">确认密码</td>
			<td align="left"><input type="password" class="input_2" name="zhmm1" style="width: 60%" value="" /></td>
		</tr>
		<tr>
			<td></td><td></td>
			<td></td><td></td>
		</tr>
		<tr>
			<td align="center" colspan="4">
				<input type="button" class="input2" value="保 存" onclick="save()" />&nbsp;&nbsp;
				<input type="button" class="input2" value="重 置" onclick="javascript:window.location.href='<%=path %>/rygl/ryxz.jsp'" />
			</td>
		</tr>
	</table>
</div>
<input type="hidden" name="grbh" value="<%=grbh %>" />
</form>
</body>
<script type="text/javascript" src="<%=path %>//static//js/jquery/jquery-1.7.2.js"></script>
<script type="text/javascript" src="<%=path %>//static//js//static/.js"></script>
<script type="text/javascript">
$(function() {
	initDmb ("mz", "mzdmb","<%=mz %>");
	initDmb ("zzmm", "zzmmdmb", "<%=zzmm %>");
	initDmb ("whcd", "xldmb", "<%=whcd %>");
	initDmb ("ssks", "yyksb", "<%=ssks %>");
	initDmb ("ysdj", "ysjbdmb", "<%=ysdj %>");
	initDmb ("rysf", "rysfdmb", "<%=rysf %>");
	initXzqh("hksz", "<%=hkszdxzqh %>");
	initXzqh("jzsz", "<%=jzszdxzqh %>");
			
});

$(function () {
	<%
		if (vb == null) {
	%>
		$("[name='sfzhm']").focus();
	<%
		}
	%>
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
	} else if ($("[name='zzmm']").val() == ''){
		alert("请选择政治面貌！");
		return;
	} else if ($("[name='whcd']").val() == ''){
		alert("请选择文化程度！");
		return;
	} else if ($("[name='byyx']").val() == ''){
		alert("毕业院校不能为空！");
		return;
	} else if ($("[name='sxzy']").val() == ''){
		alert("所学专业不能为空！");
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
	} else if ($("[name='ssks']").val() == ''){
		alert("请选择所属科室！");
		return;
	} else if ($("[name='rysf']").val() == ''){
		alert("请选择人员身份！");
		return;
	} else if ($("[name='ysdj']").val() == ''){
		alert("请选择医师等级！");
		return;
	} else if ($("[name='njts']").val() == ''){
		alert("年假天数不过为空！");
		return;
	} else if ($("[name='jbgz']").val() == ''){
		alert("基本工资不过为空！");
		return;
	} else if ($("[name='zjfzr']").val() == ''){
		alert("请选择直接负责人");
		return;
	} else if ($("[name='czyid']").val() == ''){
		alert("操作员不过为空！");
		return;
	} else if ($("[name='czsj']").val() == ''){
		alert("操作时间不过为空！");
		return;
	} else if ($("[name='zhbm']").val() == "") {
		alert("账号不过为空！");
		return;
	} else if ($("[name='zhmm']").val() == "" || $("[name='zhmm1']").val() == '') {
		if ($("[name='zhmm']").val() == "") {
			alert("请输入密码！");
			return;
		} else {
			alert("请确认密码！");
			return;
		}
	} else if ($("[name='zhmm']").val() != $("[name='zhmm1']").val()) {
		alert("两次密码必须一致！");
		return;
	}
	form1.action = "<%=path %>/rygl/ywrySave.do";
	form1.submit();
}
function checkSfzhm(sfzhm) {
	if ($("[name='sfzhm']").val() == "") {
		alert("请先输入身份证号码！");
		return;
	}
	if (!IdCardValidate(sfzhm)) {
		$("[name='sfzhm']").focus();
		$("[name='sfzhm']").val("");
		return;
	}
	if (sfzhm.length == 15) {
		sfzhm = transformatIdFrom15To18(sfzhm);
		$("[name='sfzhm']").val(sfzhm);
	}	
	form1.action = "<%=path %>/rygl/getRyxxBySfzhm.do";
	form1.submit();
}

// 判断账号是否存在
function pdzhsfcz (box) {
	$.ajax({
		url : "<%=path %>/rygl/getzhsfcz.do",
		type : "post",
		data : {
			"zhbm" : $(box).val()
		},
		dataType : "json",
		success : function(data) {
			if (data.returnCode == 1) {
				$("#span1").html(data.returnMsg);
			} else {
				$("#span1").html(data.returnMsg);
				$(box).val("");
			}
		}
	});
}
</script>
</html>







