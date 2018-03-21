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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>人员查询</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path%>/static/style/css/YyjgptStyle.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/static/style/css/pagination.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="/static/message.jsp" %>
<h2 class="mbx">当前位置：考勤管理 &nbsp;&gt;&nbsp; 历史考勤查询</h2> 
<input type="hidden" name="grbh" value="<%=sessionConf.getGrbh() %>">
<div class="cztable">
	<table border="0" cellspacing="0" cellpadding="0" width="98%">
		<tr>
			<td align="left" colspan="4" bgcolor="#8DC5E6"><h1>查询条件</h1></td>
		</tr>
		<tr>
			<td align="right" width="40%">
				时间段：
			</td>
			<td width="60%">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="sjxz" onclick="qdqzsj('1')" />本月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="sjxz" onclick="qdqzsj('2')" />本周&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="sjxz" onclick="qdqzsj('3')" />本天
			</td>
		</tr>
		<tr>
			<td align="center" colspan="4">
				<input type="button" class="input2" value="查 询" onclick="cx()" />&nbsp;&nbsp;
				<input type="button" class="input2" value="重 置" onclick="cz()" />
			</td>
		</tr>
	</table>
</div>
<input type="hidden" name="sjq" />
<input type="hidden" name="sjz" />
<br />
<div class="cztable" align="center" id="datadiv" style="display: none;">
	<table border="0" cellspacing="0" cellpadding="0" width="94%">
		<thead align="center">
			<tr bgcolor="#8DC5E6">
				<td width="5%"><h1>序号</h1></td>
				<td width="17%"><h1>打卡日期</h1></td>
				<td width="12%"><h1>签到时间</h1></td>
				<td width="12%"><h1>是否迟到</h1></td>
				<td width="12%"><h1>签退时间</h1></td>
				<td width="6%"><h1>是否早退</h1></td>
			</tr>
		</thead>
		<tbody id="dataTab" align="center">
		</tbody>
	</table>
	<div align="center" id="Pagination" class="pagination"></div>
</div>
</body>
<script type="text/javascript" src="<%=path %>/static/js/jquery/jquery-1.7.2.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/jquery/jquery.pagination.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/common.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/dateRangeUtil.js"></script>
<script type="text/javascript">

	var pageIndex = 0;     //页面索引初始值   
	var pageSize = 10; //每页显示条数初始化，修改显示条数，修改这里即可   
	var rowsCount = 0;
	function cx () {
		
		if ($("[name='sjq']").val() == "" ||  $("[name='sjz']").val() == "") {
			alert("请选择时间段！");
			return;
		}
		
		//分页，PageCount是总条目数，这是必选参数，其它参数都是可选
		InitRowsCount();
		function InitRowsCount() {
			$.ajax({
				type : "POST",
				dataType : "json",
				async : false,
				url : "<%=path %>/rygl/kqjlsCx.do", //提交到一般处理程序请求数据   
				data : {
					"grbh" : $("[name='grbh']").val(), 
					"sjq" : $("[name='sjq']").val(), 
					"sjz" : $("[name='sjz']").val()
				}, //提交两个参数：pageIndex(页面索引)，pageSize(显示条数)                   
				success : function(data) {
					rowsCount = data.returnData;
				}
			});
		}
		if (rowsCount == 0) {
			$("#dataTab").html("<tr><td colspan='6' align='center'>暂无数据！</td></tr>");
			return;
		}
		$("#datadiv").css("display", "");
		$("#Pagination").pagination(rowsCount, 
			{
			callback : PageCallback, //PageCallback() 为翻页调用次函数。
			prev_text : "« 上一页",
			next_text : "下一页 »",
			items_per_page : pageSize,
			num_edge_entries : 2, //两侧首尾分页条目数
			num_display_entries : 6, //连续分页主体部分分页条目数
			current_page : pageIndex, //当前页索引
		});
		//翻页调用   
		function PageCallback(index, jq) {
			InitTable(index);
		}
		//请求数据   
		function InitTable(pageIndex) {
			$.ajax({
				type : "POST",
				dataType : "json",
				url : "<%=path %>/rygl/kqjlCx.do", //提交到一般处理程序请求数据   
				data : {
					"grbh" : $("[name='grbh']").val(), 
					"sjq" : $("[name='sjq']").val(), 
					"sjz" : $("[name='sjz']").val(),
					"pageIndex" : pageIndex, 
					"pageSize" : pageSize
				}, //提交两个参数：pageIndex(页面索引)，pageSize(显示条数)                   
				success : function(data) {
					var msg = "";
					if (data.returnCode == 1) {
						data.returnData.forEach(function (e,i) {
							msg += "<tr>" +
									"<td>" + (pageIndex*pageSize+1+i) + "</td>" +
									"<td>" + e.kqrq + "</td>" +
									"<td>" + e.dksjz + "</td>" +
									"<td>" + e.sfcd + "</td>" +
									"<td>" + e.dksjw + "</td>" +
									"<td>" + e.sfzt + "</td>" +
								"</tr>";
						});
						$("#dataTab").html(msg);
					}
				}
			});
		}
	}

	function cz() {
		$("[name='sjxz']").attr("checked",false);
		$("[name='sjq']").val("");
		$("[name='sjz']").val("");
	}
	
	
	function qdqzsj (i) {
		var sjq = "";
		var sjz = "";
		if (i == 1) {
		 	sjq = dateRangeUtil.getCurrentWeek()[0].Format("yyyyMMdd")
	        sjz = dateRangeUtil.getCurrentWeek()[1].Format("yyyyMMdd")
		} else if (i == 2) {
	        sjq = dateRangeUtil.getCurrentMonth()[0].Format("yyyyMMdd")
	        sjz = dateRangeUtil.getCurrentMonth()[1].Format("yyyyMMdd")
		} else if (i == 3) {
			var date = new Date();
	   
		    var month = date.getMonth() + 1;
		    var strDate = date.getDate();
		    if (month >= 1 && month <= 9) {
		        month = "0" + month;
		    }
		    if (strDate >= 0 && strDate <= 9) {
		        strDate = "0" + strDate;
		    }
	    	var currentdate = date.getFullYear() + month + strDate;
			sjq = currentdate;
			sjz = currentdate;
		}
		$("[name='sjq']").val(sjq);
		$("[name='sjz']").val(sjz);
	}
</script>
</html>