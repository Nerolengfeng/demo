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
	SessionConfig sessionConf = (SessionConfig) session
			.getAttribute("sessionConf");
	if (sessionConf == null) {
		session.setAttribute("errorMsg", "连接超时，请重新登录！");
		response.sendRedirect(path + "/error.jsp");
		return;
	}
%>
<%
	String sfgh = request.getParameter("sfgh");
	String url = "";
	if ("1".equals(sfgh)) {
		url = path + "/mzgl/gh.do";
	} else {
		url = path + "/mzgl/ghth.do";
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>挂号</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path%>/static/style/css/YyjgptStyle.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
<input type="hidden" name="grbh" value="<%=sessionConf.getGrbh() %>" />
	<%@include file="/static/message.jsp"%>
	<form name="form1" method="post">
		<h2 class="mbx">当前位置：门诊挂号 &nbsp;&gt;&nbsp; 挂号</h2>

		<div class="cztable">
			<table border="0" cellspacing="0" cellpadding="0" width="98%">
				<tr>
					<td align="left" colspan="2" bgcolor="#8DC5E6"><h1>当前时间</h1></td>
				</tr>
				<tr height="100px">
					<td align="center" colspan="2"><span id="liveclock"
						style="font-weight: bolder; font-size: 30px;"></span>
						<input type="hidden" name="ghsj" />
					</td>
				</tr>
				<tr height="100px">
					<td align="right" width="45%">身份证号码</td>
					<td align="left" width="55%">
						<input type="text" name="sfzhm" size="30" onblur="checkSfzhm(this.value)" maxlength="18"  />
					</td>
				</tr>
			</table>
			<br /> <br />
			<table border="0" cellspacing="0" cellpadding="0" width="98%">
				<tr>
					<td align="center">
						<input type="button" id="qdBut" value="提  交" onclick="tj()" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						<input type="button" id="qtBut" value="返   回" onclick="goBack()" />
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
<script type="text/javascript" src="<%=path %>/static/js/jquery/jquery-1.7.2.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/common.js"></script>
<script type="text/javascript">
	function showTime() {
		var Digital = new Date();
		var year = Digital.getFullYear();
		var month = Digital.getMonth() + 1;
		var day = Digital.getDate();
		var hours = Digital.getHours();
		var minutes = Digital.getMinutes();
		var seconds = Digital.getSeconds();

		if (month <= 9)
			month = "0" + month;
		if (day <= 9)
			day = "0" + day;
		if (hours <= 9)
			hours = "0" + hours;
		if (minutes <= 9)
			minutes = "0" + minutes;
		if (seconds <= 9)
			seconds = "0" + seconds;
		myclock = year + "年" + month + "月" + day + "日" + "  " + hours + ":"
				+ minutes + ":" + seconds;
		liveclock.innerHTML = myclock;
		$("[name='ghsj']").val("" + year + month + day + hours + minutes + seconds);
		setTimeout("showTime()", 1000);
	}
	showTime();
	
	
	function checkSfzhm(sfzhm) {
		if ($("[name='sfzhm']").val() == "") {
			alert("请先输入身份证号码！");
			return;
		}
		if (!IdCardValidate(sfzhm)) {
			$("[name='sfzhm']").val("");
			return;
		}
		if (sfzhm.length == 15) {
			sfzhm = transformatIdFrom15To18(sfzhm);
			$("[name='sfzhm']").val(sfzhm);
		}
	}
	
	function tj() {
		if ($("[name='sfzhm']").val() == "") {
			alert("请先输入身份证号码！");
			return;
		}
		if (confirm("是否确认提交？")) {
			form1.action = "<%=url %>";
			form1.submit();
		}
	}
	
	function goBack() {
		window.location.href = "<%=path %>/mzgl/ghsy.jsp";
	}
	
</script>
</html>