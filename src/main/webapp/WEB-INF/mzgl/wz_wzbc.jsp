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
	String ghsj = "";
	if (fb != null) {
		ghkbh = StringTools.toTirm(fb.getGhkbh());
		ghsj = StringTools.toTirm(fb.getGhsj());
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
<input type="hidden" name="ghsj" value="<%=ghsj %>" />
<h2 class="mbx">当前位置：医生工作站 &nbsp;&gt;&nbsp; 问诊</h2>

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
			<td align="left" colspan="4" bgcolor="#8DC5E6">所患病种</td>
		</tr>
		<tr id="shbzTr">
			<td colspan="4">
				<table width="98%">
					<thead>
						<tr>
							<td align="center" width="40%"><h2>患病名称</h2></td>
							<td align="center" width="40%"><h2>疾病表现</h2></td>
							<td align="center" width="20%"><input type="button" value="增加" onclick="shbzZj()"></td>
						</tr>
					</thead>
					<tbody id="shbzBody">
					</tbody>
				</table>
			</td>
		</tr>
		
		<tr>
			<td align="left" colspan="4" bgcolor="#8DC5E6">是否取药<input type="checkbox" onclick="changeSfqy(this)" name="sfqy" value="1"></td>
		</tr>
		<tr id="sfqyTr" style="display: none">
			<td colspan="4">
				<table width="98%">
					<thead>
						<tr>
							<td align="center" width="60%"><h2>药物名称</h2></td>
							<td align="center" width="30%"><h2>份数</h2></td>
							<td align="center" width="10%"><input type="button" value="增加" onclick="sfqyZj()"></td>
						</tr>
					</thead>
					<tbody id="sfqyBody">
					</tbody>
				</table>
			</td>
		</tr>
		
		<tr>
			<td align="left" colspan="4" bgcolor="#8DC5E6">是否检查<input type="checkbox" onclick="changeSfjc(this)" name="sfjc" value="1"></td>
		</tr>
		<tr id="sfjcTr" style="display: none">
			<td colspan="4">
				<table width="98%">
					<thead>
						<tr>
							<td align="center" width="80%"><h2>检查名称</h2></td>
							<td align="center" width="20%"><input type="button" value="增加" onclick="sfjcZj()"></td>
						</tr>
					</thead>
					<tbody id="sfjcBody">
					</tbody>
				</table>
			</td>
		</tr>
		
		<!-- <tr>
			<td align="left" colspan="4" bgcolor="#8DC5E6">是否住院<input type="checkbox" name="sfzy" value="1"></td>
		</tr> -->
				
		<tr>
			<td colspan="4" align="center"><textarea name="zysx" rows="5" cols="70"></textarea></td>
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
		window.location.href = "<%=path%>/mzgl/wz_cx.jsp";
	}
	
	function changeSfqy(boz) {
		if ($(boz).attr("checked") == "checked") {
			$("#sfqyTr").css("display","")
		} else {
			$("#sfqyTr").css("display","none")
			$("#sfqyBody").html("");
		}
	}
	
	function changeSfjc(boz) {
		if ($(boz).attr("checked") == "checked") {
			$("#sfjcTr").css("display","")
		} else {
			$("#sfjcTr").css("display","none")
			$("#sfjcBody").html("");
		}
	}
	function sfqyZj() {
		$("#sfqyBody").append("<tr align='center'><td><select name='ywid' style='width: 50%'></select></td><td><input type='text' name='ywfs' /></td><td><input type='button' onclick='delSfqy(this)' value='删 除' /></td></tr>");
		$("[name='ywid']").each(function (i) {
			if($(this).html() == "") {
				$.ajax({
					url : "<%=path %>/mzgl/getYwxxHtml.do",
					data : {"tablename" : "ywxxdmb"},
					type : "post",
					dataType : "json",
					success : function(data) {
						$("[name='ywid']").eq(i).html(data.returnData);
					},
				});
			}
		});
	}
	function sfjcZj() {
		$("#sfjcBody").append("<tr align='center'><td><select name='jcid' style='width: 50%'></select></td><td><input type='button' onclick='delSfjc(this)' value='删 除' /></td></tr>");
		$("[name='jcid']").each(function (i) {
			if($(this).html() == "") {
				$.ajax({
					url : "<%=path %>/mzgl/getYwxxHtml.do",
					data : {"tablename" : "jcxxdmb"},
					type : "post",
					dataType : "json",
					success : function(data) {
						$("[name='jcid']").eq(i).html(data.returnData);
					},
				});
			}
		});
	}
	
	function shbzZj() {
		$("#shbzBody").append("<tr align='center'><td><select name='jbid' style='width: 50%'></select></td><td><input size='30' type='text' name='jbbx' maxlength='50'/></td><td><input type='button' onclick='delShbz(this)' value='删 除' /></td></tr>");
		$("[name='jbid']").each(function (i) {
			if($(this).html() == "") {
				$.ajax({
					url : "<%=path %>/mzgl/getJbxxHtml.do",
					type : "post",
					dataType : "json",
					success : function(data) {
						$("[name='jbid']").eq(i).html(data.returnData);
					},
				});
			}
		});
	}
	
	function tj () {
		if ($("[name='jbid']") != undefined) {
			var jbid = document.getElementsByName("jbid");
			if (jbid != null) {
				for (var i=0; i<jbid.length; i++) {
					if (jbid[i].value == "") {
						alert("请选择疾病种类！");
						return;
					}
					for (var j = i+1; j<jbid.length; j++) {
						if (jbid[i].value == jbid[j].value) {
							alert("疾病种类不能相同");
							return;
						}
					}
				}
			}
		}
		if ($("[name='sfqy']:checked").val() == "1") {
			var ywid = document.getElementsByName("ywid");
			if (ywid != null) {
				for (var i=0; i<ywid.length; i++) {
					if (ywid[i].value == "") {
						alert("请选择药物！");
						return;
					}
					for (var j = i+1; j<ywid.length; j++) {
						if (ywid[i].value == ywid[j].value) {
							alert("药物名称不能相同");
							return;
						}
					}
				}
			}
			var ywfs = document.getElementsByName("ywfs");
			if (ywfs != null) {
				for (var i=0; i<ywfs.length; i++) {
					if (ywfs[i].value == "") {
						alert("请选择药物份数！");
						return;
					}
				}
			}
		}
		if ($("[name='sfjc']:checked").val() == "1") {
			var jcid = document.getElementsByName("jcid");
			if (jcid != null) {
				for (var i=0; i<jcid.length; i++) {
					if (jcid[i].value == "") {
						alert("请选择检查！");
						return;
					}
				}
			}
		}
		form1.action = "<%=path %>/mzgl/rywzBc.do";
		form1.submit();
	}
	
	function delSfjc(boz) {
		$(boz).parent().parent().remove();
	}
	function delSfqy(boz) {
		$(boz).parent().parent().remove();
	}
	function delShbz(boz) {
		$(boz).parent().parent().remove();
	}
</script>
</html>