<%@page import="com.example.demo.util.StringTools"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	SessionConfig sessionConf = (SessionConfig) session
			.getAttribute("sessionConf");
	if (sessionConf == null) {
		session.setAttribute("errorMsg", "连接超时，请重新登录！");
		response.sendRedirect(path + "/error.jsp");
		return;
	}
%>
<%
	
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
					<td align="center" width="70%"><span id="liveclock"
						style="font-weight: bolder; font-size: 30px;"></span>
						<input type="hidden" name="ghsj" />
					</td>
				</tr>
			</table>
			<br /> <br />
			<table border="0" cellspacing="0" cellpadding="0" width="98%">
				<tr height="100px">
					<td align="center">
						<input type="button" id="qdBut" value="挂  号" onclick="gh()" style="font-size: 30px; border:0px; width:200px; height:71px; background:url('<%=path %>/static/style/images/button.jpg') no-repeat center; cursor:pointer;"/>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						<input type="button" id="qtBut" value="退  号" onclick="th()" style="font-size: 30px; border:0px; width:200px; height:71px; background:url('<%=path %>/static/style/images/button.jpg') no-repeat center; cursor:pointer;"/>
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
<script type="text/javascript" src="<%=path %>/static/js/jquery/jquery-1.7.2.js"></script>
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
	
	function gh() {
		window.location.href = "<%=path %>/mzgl/ghsy_1.jsp?sfgh=1";
	}
	
	function th() {
		window.location.href = "<%=path %>/mzgl/ghsy_1.jsp?sfgh=0";
	}
	
</script>
</html>