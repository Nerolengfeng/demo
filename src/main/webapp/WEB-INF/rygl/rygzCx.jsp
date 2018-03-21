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
	
	int curYear = Integer.parseInt(DateTools.getCurYear());
	int curMonth = Integer.parseInt(DateTools.getCurMonth());
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>人员查询</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path%>/static/style/css/YyjgptStyle.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/static/style/css/pagination.css" rel="stylesheet" type="text/css" />
</head>
<body>
<input type="hidden" name="grbh" value="<%=sessionConf.getGrbh() %>" />
<%@include file="/static/message.jsp" %>
<h2 class="mbx">当前位置：人员管理 &nbsp;&gt;&nbsp; 人员查询</h2>
<div class="cztable">
	<table border="0" cellspacing="0" cellpadding="0" width="98%">
		<tr>
			<td align="left" colspan="4" bgcolor="#8DC5E6"><h1>查询条件</h1></td>
		</tr>
		<tr>
			<td align="right" width="20%">工资发放年</td>
			<td align="left" width="40%">
				<select name="gzffn" style="width: 45%">
				<%
					for (int i=0; i<12; i++) {
						if ( curYear - i == curYear) {
						%>
							<option value="<%=curYear - i %>" selected><%=curYear - i %></option>
						<%
						} else {
						%>
							<option value="<%=curYear - i %>"><%=curYear - i %></option>
						<%
						}
					}
				%>
				</select>
			</td>
			<td align="right" width="15%">工资发放月</td>
			<td align="left" width="25%">
				<select name="gzffy" style="width: 50%">
					<option value="">请选择</option>
					<%
					for (int i=1; i<=12; i++) {
						if ( i == curMonth) {
						%>
							<option value="<%=i<10?("0"+i):(""+i) %>" selected><%=i %></option>
						<%
						} else {
						%>
							<option value="<%=i<10?("0"+i):(""+i) %>"><%=i %></option>
						<%
						}
					}
				%>
				</select>
			</td>
		</tr>
		<tr>
			<td align="center" colspan="4">
				<input type="button" class="input2" value="查 询" onclick="cx()" />&nbsp;&nbsp;
				<input type="reset" class="input2" value="重 置" onclick="cz()" />
			</td>
		</tr>
	</table>
</div>
<br />
<div class="cztable" align="center" id="datadiv" style="display: none;">
	<table border="0" cellspacing="0" cellpadding="0" width="94%">
		<tr>
			<td align="right">基本工资</td>
			<td id="jbgz"></td>
			<td align="right">绩效工资</td>
			<td id="jxgz"></td>
		</tr>
		<tr>
			<td align="right">请假扣除工资</td>
			<td id="qjkcgz"></td>
			<td align="right">总工资</td>
			<td id="zgz"></td>
		</tr>
	</table>
</div>
</body>
<script type="text/javascript" src="<%=path %>/static/js/jquery/jquery-1.7.2.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/jquery/jquery.pagination.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/common.js"></script>
<script type="text/javascript">

	var pageIndex = 0;     //页面索引初始值   
	var pageSize = 10; //每页显示条数初始化，修改显示条数，修改这里即可   
	var rowsCount = 0;
	function cx () {
		
		$.ajax({
			type : "POST",
			dataType : "json",
			url : "<%=path %>/rygl/rygzCx.do", //提交到一般处理程序请求数据   
			data : {
				"gzffsj" : "" + $("[name='gzffn']").val() + $("[name='gzffy']").val(),
				"grbh" : $("[name='grbh']").val()
			}, //提交两个参数：pageIndex(页面索引)，pageSize(显示条数)                   
			success : function(data) {
				var msg = "";
				if (data.returnData != undefined) {
					$("#datadiv").css("display", "");
					$("#jbgz").val(data.returnData.jbgz);
					$("#jxgz").val(data.returnData.jxgz);
					$("#qjkcgz").val(data.returnData.qjkcgz);
					$("#zgz").val(data.returnData.zgz);
				} else {
					$("#datadiv").css("display", "none");
					alert("暂无数据！");
				}
			}
		});
	}

	function cz() {
		$("[name='sfzhm']").val("");
		$("[name='xm']").val("");
	}
</script>
</html>