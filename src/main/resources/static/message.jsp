<%
	String msg = null;
	if (session.getAttribute("errorMsg") != null) {
		msg = (String) session.getAttribute("errorMsg");
		session.removeAttribute("errorMsg");

	}
%>
