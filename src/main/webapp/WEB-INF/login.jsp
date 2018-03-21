<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.example.demo.util.StringTools"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	String msg = null;
	if (session.getAttribute("errorMsg") != null) {
		msg = (String) session.getAttribute("errorMsg");
		session.removeAttribute("errorMsg");

	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>登录页面</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<style type="text/css">
body {
	font-size: 12px;
	color: #ffffff;
	font-family: 宋体
}

td {
	font-size: 12px;
	color: #ffffff;
	font-family: 宋体;
}
</style>
</head>
<body>

	<form name="form1" action="<%=path %>/common/login" method="post">
		<div>
			<div
				style="left: 0px; position: absolute; top: 0px; background-color: #0066ff"></div>
			<div
				style="left: 0px; position: absolute; top: 0px; background-color: #0066ff"></div>
			<div>&nbsp;&nbsp;</div>
			<div>
				<table cellspacing="0" cellpadding="0" width="900px" align="center"
					border="0">
					<tbody>
						<tr>
							<td style="height: 105px"><img
								src="\static\style\img\login_1.gif" border="0"></td>
						</tr>
						<tr>
							<td background="<%=path %>\static\style\img\login_2.jpg"
								height="300px">
								<table height="300px" cellPadding="0" width="900px" border="0">
									<tbody>
										<tr>
											<td colspan="2" height="35px"></td>
										</tr>
										<tr>
											<td width="360px"></td>
											<td>
												<table cellspacing="0" cellpadding="2" border="0">
													<tbody>
														<tr>
															<td style="height: 28px; width: 80px;">登 录 名：</td>
															<td style="height: 28px; width:150px;"><input
																id="txtName" style="width: 130px" name="username"
																value="fwc" /></td>
															<td style="height: 28px; width:370px;"><span
																id="span1"
																style="display: none; font-weight: bold; color: white">请输入登录名</SPAN>
															</td>
														</tr>
														<tr>
															<td style="height: 28px">登录密码：</td>
															<td style="height: 28px"><input id="txtPwd"
																value="0" style="WIDTH: 130px" type="password"
																name="password"></td>
															<td style="height: 28px"><span id="span2"
																style="display: none; font-weight: bold; color: white">请输入密码</span>
															</td>
														</tr>

														<tr>
															<td style="height: 18px"></td>
															<td style="height: 18px"></td>
															<td style="height: 18px"></td>
														</tr>
														<tr>
															<td></td>
															<td><img
																style="border-top-width: 0px; border-left-width: 0px; border-bottom-width: 0px; border-right-width: 0px"
																onclick="loginFunc()"
																src="<%=path %>\static\style\img\login_button.gif"
																name="loginBtn" /></td>
														</tr>
													</tbody>
												</table>
									</tbody>
								</table>
							</td>
						</tr>
						<tr>
							<td><img src="<%=path %>\static\style\img\login_3.jpg"></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript">
	function loginFunc() {
		var flag = true;
		var span1 = document.getElementById("span1");
		var span2 = document.getElementById("span2");
		if (form1.username.value == "") {
			span1.style.display = "";
			flag = false;
		} else {
			span1.style.display = "none";
		}
		if (form1.password.value == "") {
			span2.style.display = "";
			flag = false;
		} else {
			span2.style.display = "none";
		}
		if (flag) {
			form1.submit();
		}
	}
</script>
</html>





