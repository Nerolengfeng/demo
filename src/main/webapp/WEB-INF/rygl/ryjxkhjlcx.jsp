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
<title>绩效考核</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path%>/static/style/css/YyjgptStyle.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/static/style/css/pagination.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="/static/message.jsp" %>
<h2 class="mbx">当前位置：绩效考核管理 &nbsp;&gt;&nbsp; 绩效考核</h2>  
<div class="cztable">
	<table border="0" cellspacing="0" cellpadding="0" width="98%">
		<tr>
			<td align="left" colspan="4" bgcolor="#8DC5E6"><h1>查询条件</h1></td>
		</tr>
		<tr>
			<td align="right" width="20%">身份证号码</td>
			<td align="left" width="40%">
				<input type="text" class="input_2" name="sfzhm" maxlength="18" size="30" onblur="checkSfzhm(this.value)" />
			</td>
			<td align="right" width="15%">姓名</td>
			<td align="left" width="25%"><input type="text" class="input_2" name="xm" size="20" maxlength="20" /></td>
		</tr>
		<tr>
			<td align="right" width="20%">考核年</td>
			<td align="left" width="40%">
				<select name="khn" style="width: 45%">
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
			<td align="right" width="15%">考核月</td>
			<td align="left" width="25%">
				<select name="khy" style="width: 50%">
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
				<input type="button" class="input2" value="重 置" onclick="cz()" />
			</td>
		</tr>
	</table>
</div>
<br />
<div class="cztable" align="center" id="datadiv" style="display: none;">
	<table border="0" cellspacing="0" cellpadding="0" width="94%">
		<thead align="center">
			<tr bgcolor="#8DC5E6">
				<td width="5%"><h1>序号</h1></td>
				<td width="17%"><h1>身份证号码</h1></td>
				<td width="11%"><h1>姓名</h1></td>
				
				<td width="9%"><h1>遵守工作时间</h1></td>
				<td width="9%"><h1>责任事故</h1></td>
				<td width="9%"><h1>遵守纪律</h1></td>
				<td width="9%"><h1>工作态度</h1></td>
				<td width="9%"><h1>任务完成情况</h1></td>
				<td width="9%"><h1>工作合规性</h1></td>
				<td width="9%"><h1>工作质量</h1></td>
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
<script type="text/javascript">

	var pageIndex = 0;     //页面索引初始值   
	var pageSize = 10; //每页显示条数初始化，修改显示条数，修改这里即可   
	var rowsCount = 0;
	function cx () {
		//
		//分页，PageCount是总条目数，这是必选参数，其它参数都是可选
		InitRowsCount();
		function InitRowsCount() {
			$.ajax({
				type : "POST",
				dataType : "json",
				async : false,
				url : "<%=path %>/rygl/rykhjlsCx.do", //提交到一般处理程序请求数据   
				data : {
					"sfzhm" : $("[name='sfzhm']").val(), 
					"xm" : $("[name='xm']").val(),
					"khn" : $("[name='khn']").val(),
					"khy" : $("[name='khy']").val()
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
				url : "<%=path %>/rygl/rykhjlCx.do", //提交到一般处理程序请求数据   
				data : {
					"sfzhm" : $("[name='sfzhm']").val(), 
					"xm" : $("[name='xm']").val(), 
					"khn" : $("[name='khn']").val(),
					"khy" : $("[name='khy']").val(),
					"pageIndex" : pageIndex, 
					"pageSize" : pageSize
				}, //提交两个参数：pageIndex(页面索引)，pageSize(显示条数)                   
				success : function(data) {
					var msg = "";
					if (data.returnCode == 1) {
						data.returnData.forEach(function (e,i) {
							msg += "<tr>" +
									"<td>" + (pageIndex*pageSize+1+i) + "</td>" +
									"<td>" + e.ryxx.sfzhm + "</td>" +
									"<td>" + e.ryxx.xm + "</td>" +
									"<td>" + e.jxkh.zsgzsj + "</td>" +
									"<td>" + e.jxkh.zrsg + "</td>" +
									"<td>" + e.jxkh.zsjl + "</td>" +
									"<td>" + e.jxkh.gztd + "</td>" +
									"<td>" + e.jxkh.rwwcqk + "</td>" +
									"<td>" + e.jxkh.gzhgx + "</td>" +
									"<td>" + e.jxkh.gzzl + "</td>" +
								"</tr>";
						});
						$("#dataTab").html(msg);
					}
				}
			});
		}
	}

	function checkSfzhm(sfzhm) {
		if (!IdCardValidate(sfzhm)) {
			$("[name='sfzhm']").val("");
			return;
		}
		if (sfzhm.length == 15) {
			sfzhm = transformatIdFrom15To18(sfzhm);
			$("[name='sfzhm']").val(sfzhm);
		}
	}

	function cz() {
		$("[name='khn']").val("");
		$("[name='khy']").val("");
		$("[name='sfzhm']").val("");
		$("[name='xm']").val("");
	}
</script>
</html>