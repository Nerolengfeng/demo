<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.example.demo.util.SessionConfig"%>
<%@page import="com.example.demo.util.StringTools"%>
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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE>顶部</TITLE>
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
	FONT-SIZE: 12px;
	COLOR: #003366;
	FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif
}

TD {
	FONT-SIZE: 12px;
	COLOR: #003366;
	FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif
}

DIV {
	FONT-SIZE: 12px;
	COLOR: #003366;
	FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif
}

P {
	FONT-SIZE: 12px;
	COLOR: #003366;
	FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif
}
</STYLE>
</HEAD>
<BODY>
	<FORM id="form1" name="form1" method="post">
		<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
			<TBODY>
				<TR>
					<TD width=10><IMG src="<%=path %>/static/style/img/new_001.jpg"
						border=0></TD>
					<TD background="<%=path %>/static/style/img/new_002.jpg"><FONT
						size=4><B>医院动态监管平台 管理中心</B></FONT></TD>
					<TD background="<%=path %>/static/style/img/new_002.jpg">
						<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
							<TBODY>
								<TR>

									<TD align="right" height="35"><b>欢迎[<%=StringTools.toTirm(sessionConf.getXm())%>]进入页面
									</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A
										href="<%=path %>/login.jsp" target="_top"><FONT color=red><B>安全退出</B></FONT></A></TD>
								</TR>
							</TBODY>
						</TABLE>
					</TD>
					<TD width=10><IMG src="<%=path %>/static/style/img/new_003.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>