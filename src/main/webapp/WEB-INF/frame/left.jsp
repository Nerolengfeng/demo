<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE>导航</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<STYLE type=text/css>
BODY {
	PADDING-RIGHT: 0px;
	PADDING-LEFT: 0px;
	PADDING-BOTTOM: 0px;
	MARGIN: 0px;
	PADDING-TOP: 0px;
	BACKGROUND-COLOR: #2a8dc8
}

BODY {
	FONT-SIZE: 11px;
	COLOR: #003366;
	FONT-FAMILY: Verdana
}

TD {
	FONT-SIZE: 11px;
	COLOR: #003366;
	FONT-FAMILY: Verdana
}

DIV {
	FONT-SIZE: 11px;
	COLOR: #003366;
	FONT-FAMILY: Verdana
}

P {
	FONT-SIZE: 11px;
	COLOR: #003366;
	FONT-FAMILY: Verdana
}

.mainMenu {
	FONT-WEIGHT: bold;
	FONT-SIZE: 14px;
	CURSOR: hand;
	COLOR: #000000
}

A.style2:link {
	PADDING-LEFT: 4px;
	COLOR: #0055bb;
	TEXT-DECORATION: none
}

A.style2:visited {
	PADDING-LEFT: 4px;
	COLOR: #0055bb;
	TEXT-DECORATION: none
}

A.style2:hover {
	PADDING-LEFT: 4px;
	COLOR: #ff0000;
	TEXT-DECORATION: none
}

A.active {
	PADDING-LEFT: 4px;
	COLOR: #ff0000;
	TEXT-DECORATION: none
}

.span {
	COLOR: #ff0000
}
</STYLE>

<script type="text/javascript">
	function MenuDisplay(obj) {
		for (var i = 1; i <= 9; i++) {
			if (obj != "table_"+i) {
				document.getElementById('table_' + i).style.display = 'none';
				document.getElementById('table_' + i + 'Span').innerText = '＋';
			}
		}
		if (document.getElementById(obj).style.display == 'none') {
			document.getElementById(obj).style.display = 'block';
			document.getElementById(obj + 'Span').innerText = '－';
		} else {
			document.getElementById(obj).style.display = 'none';
			document.getElementById(obj + 'Span').innerText = '＋';
		}
	}
</script>
</HEAD>
<BODY>
	<FORM id="form1" name="form1" method="post">
		<TABLE cellSpacing="0" cellPadding="0" width="210" align="center" border="0">
			<TBODY>
				<TR>
					<TD width=15><IMG src="<%=path %>/static/style/img/new_005.jpg" border=0></TD>
					<TD align="center" width="180" background="<%=path %>/static/style/img/new_006.jpg"
						height="35"><B>医院监管平台 －功能菜单</B></TD>
					<TD width="15"><IMG src="<%=path %>/static/style/img/new_007.jpg" border="0"></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing="0" cellPadding="0" width="210" align="center" border="0">
			<TBODY>
				<TR>
					<TD width="15" background="<%=path %>/static/style/img/new_008.jpg"></TD>
					<TD vAlign="top" width="180" bgColor="#ffffff">
						<TABLE cellSpacing="0" cellPadding="3" width="165" align="center" border="0">
							<TBODY>
								<TR>
									<TD class="mainMenu" onClick="MenuDisplay('table_1');"><SPAN
										class="span" id="table_1Span">＋</SPAN>人员管理</TD>
								</TR>
								<TR>
									<TD>
										<TABLE id="table_1" style="DISPLAY: none" cellSpacing="0"
											cellPadding="2" width="155" align="center" border="0">
											<TBODY>
												<TR>
													<TD class="menuSmall"><A class="style2" href="<%=path %>/rygl/ryxz.jsp"
														target="dmMain">－ 人员新增</A></TD>
												</TR>
												<TR>
													<TD class="menuSmall"><A class="style2" href="<%=path %>/rygl/ryxgcx.jsp"
														target="dmMain">－ 人员修改</A></TD>
												</TR>
												<TR>
													<TD class="menuSmall"><A class="style2" href="<%=path %>/rygl/ryzx.jsp"
														target="dmMain">－ 人员注销</A></TD>
												</TR>
												<TR>
													<TD class="menuSmall"><A class="style2" href="<%=path %>/rygl/rycx.jsp"
														target="dmMain">－ 人员查询</A></TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
								<TR>
									<TD background="<%=path %>/static/style/img/new_027.jpg" height="1"></TD>
								</TR>
								<TR>
									<TD class="mainMenu" onClick="MenuDisplay('table_2');"><SPAN
										class="span" id="table_2Span">＋</SPAN>请假管理</TD>
								</TR>
								<TR>
									<TD>
										<TABLE id="table_2" style="DISPLAY: none" cellSpacing="0"
											cellPadding="2" width="155" align="center" border="0">
											<TBODY>
												<TR>
													<TD class="menuSmall"><A class="style2" href="<%=path %>/rygl/ryqjcx.jsp"
														target="dmMain">－ 人员请假</A></TD>
												</TR>
												<TR>
													<TD class="menuSmall"><A class="style2" href="<%=path %>/rygl/ryqjjlcx.jsp"
														target="dmMain">－ 请假查询</A></TD>
												</TR>
												<TR>
													<TD class="menuSmall"><A class="style2" href="<%=path %>/rygl/ryqjjlsccx.jsp"
														target="dmMain">－ 请假删除</A></TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
								<TR>
									<TD background="<%=path %>/static/style/img/new_027.jpg" height="1"></TD>
								</TR>
								<TR>
									<TD class="mainMenu" onClick="MenuDisplay('table_3');"><SPAN
										class="span" id="table_3Span">＋</SPAN> 绩效考核管理</TD>
								</TR>
								<TR>
									<TD>
										<TABLE id="table_3" style="DISPLAY: none" cellSpacing="0"
											cellPadding="2" width="155" align="center" border="0">
											<TBODY>
												<TR>
													<TD class="menuSmall"><A class="style2" href="<%=path %>/rygl/ryjxkhcx.jsp"
														target="dmMain">－ 绩效考核</A></TD>
												</TR>
												<TR>
													<TD class="menuSmall"><A class="style2" href="<%=path %>/rygl/ryjxkhjlcx.jsp"
														target="dmMain">－ 绩效考核查询</A></TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
								<TR>
									<TD background="<%=path %>/static/style/img/new_027.jpg" height=1></TD>
								</TR>
								<TR>
									<TD class=mainMenu onClick="MenuDisplay('table_4');"><SPAN
										class=span id=table_4Span>＋</SPAN>考勤管理</TD>
								</TR>
								<TR>
									<TD>
										<TABLE id=table_4 style="DISPLAY: none" cellSpacing=0
											cellPadding=2 width=155 align=center border=0>
											<TBODY>
												<TR>
													<TD class=menuSmall><A class=style2 href="<%=path %>/rygl/rykq.jsp"
														target=dmMain>－ 考勤</A></TD>
												</TR>
												<TR>
													<TD class=menuSmall><A class=style2 href="<%=path %>/rygl/rykqCx.jsp"
														target=dmMain>－ 历史考勤查询</A></TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
								<TR>
									<TD background="<%=path %>/static/style/img/new_027.jpg" height=1></TD>
								</TR>
								<TR>
									<TD class=mainMenu onClick="MenuDisplay('table_5');"><SPAN
										class=span id=table_5Span>＋</SPAN> 工资管理</TD>
								</TR>
								<TR>
									<TD>
										<TABLE id=table_5 style="DISPLAY: none" cellSpacing=0
											cellPadding=2 width=155 align=center border=0>
											<TBODY>
												<TR>
													<TD class=menuSmall><A class=style2 href="<%=path %>/rygl/rygzCx.jsp"
														target=dmMain>－ 工资查询</A></TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
								<TR>
									<TD background="<%=path %>/static/style/img/new_027.jpg" height=1></TD>
								</TR>
								<TR>
									<TD class=mainMenu onClick="MenuDisplay('table_6');"><SPAN
										class=span id=table_6Span>＋</SPAN>门诊挂号</TD>
								</TR>
								<TR>
									<TD>
										<TABLE id=table_6 style="DISPLAY: none" cellSpacing=0
											cellPadding=2 width=155 align=center border=0>
											<TBODY>
												<TR>
													<TD class=menuSmall><A class=style2 href="<%=path %>/mzgl/ghsy.jsp"
														target=dmMain>－ 挂号</A></TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
								<TR>
									<TD background="<%=path %>/static/style/img/new_027.jpg" height=1></TD>
								</TR>
								<TR>
									<TD class=mainMenu onClick="MenuDisplay('table_7');"><SPAN
										class=span id=table_7Span>＋</SPAN>医生工作室</TD>
								</TR>
								<TR>
									<TD>
										<TABLE id=table_7 style="DISPLAY: none" cellSpacing=0
											cellPadding=2 width=155 align=center border=0>
											<TBODY>
												<TR>
													<TD class=menuSmall><A class=style2 href="<%=path %>/mzgl/wz_cx.jsp"
														target=dmMain>－问诊</A></TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
								<TR>
									<TD background="<%=path %>/static/style/img/new_027.jpg" height=1></TD>
								</TR>
								<TR>
									<TD class=mainMenu onClick="MenuDisplay('table_8');"><SPAN
										class=span id=table_8Span>＋</SPAN>护士工作室</TD>
								</TR>
								<TR>
									<TD>
										<TABLE id=table_8 style="DISPLAY: none" cellSpacing=0
											cellPadding=2 width=155 align=center border=0>
											<TBODY>
												<TR>
													<TD class=menuSmall><A class=style2 href="<%=path %>/mzgl/jcjl_cx.jsp"
														target=dmMain>－ 检查记录</A></TD>
												</TR>
												<TR>
													<TD class=menuSmall><A class=style2 href="#"
														target=dmMain>－ 领取药物</A></TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
								<TR>
									<TD background="<%=path %>/static/style/img/new_027.jpg" height=1></TD>
								</TR>
								<TR>
									<TD class=mainMenu onClick="MenuDisplay('table_9');"><SPAN
										class=span id=table_9Span>＋</SPAN>门诊收费</TD>
								</TR>
								<TR>
									<TD>
										<TABLE id=table_9 style="DISPLAY: none" cellSpacing=0
											cellPadding=2 width=155 align=center border=0>
											<TBODY>
												<TR>
													<TD class=menuSmall><A class=style2 href="<%=path %>/mzgl/mzsf_cx.jsp"
														target=dmMain>－ 收费</A></TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
								<TR>
									<TD background="<%=path %>/static/style/img/new_027.jpg" height=1></TD>
								</TR>
								<TR>
									<TD class=mainMenu onClick="MenuDisplay('table_10');"><SPAN
										class=span id=table_10Span>＋</SPAN>门诊药价</TD>
								</TR>
								<TR>
									<TD>
										<TABLE id=table_10 style="DISPLAY: none" cellSpacing=0
											cellPadding=2 width=155 align=center border=0>
											<TBODY>
												<TR>
													<TD class=menuSmall><A class=style2 href="<%=path %>/mzgl/ywgl_xz.jsp"
															target=dmMain>－ 药物新增</A></TD>
												</TR>
												<TR>
													<TD class=menuSmall><A class=style2 href="<%=path %>/mzgl/ywgl_ywsc.jsp"
															target=dmMain>－ 药物删除</A></TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
							</TBODY>
						</TABLE>
					</TD>
					<TD width="15" background="<%=path %>/static/style/img/new_009.jpg"></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing="0" cellPadding="0" width="210" align="center" border="0">
			<TBODY>
				<TR>
					<TD width="15"><IMG src="<%=path %>/static/style/img/new_010.jpg" border="0"></TD>
					<TD align="center" width="180" background="<%=path %>/static/style/img/new_011.jpg"
						height="15"></TD>
					<TD width="15"><IMG src="<%=path %>/static/style/img/new_012.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
